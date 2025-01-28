package com.grupo3.ecuaplanet.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
public class GeminiService {

    @Value("${gemini.api.model.name}")
    private String modelName;

    @Value("${gemini.api.key}")
    private String apiKey;

    private final WebClient webClient;
    private final Gson gson = new Gson();

    public GeminiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://generativelanguage.googleapis.com/v1beta/models/" + modelName + ":generateContent")
                .build();
    }

    public Mono<String> getResponse(String text) {
        String requestBody = "{\n" +
                "  \"contents\": [\n" +
                "    {\n" +
                "      \"role\": \"user\",\n" +
                "      \"parts\": [\n" +
                "        {\n" +
                "          \"text\": \"" + text
                + ". Devuelve la respuesta en formato JSON con los campos 'text' y 'valor'.\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"generationConfig\": {\n" +
                "    \"temperature\": 0.9,\n" +
                "    \"topK\": 16,\n" +
                "    \"topP\": 0.1,\n" +
                "    \"maxOutputTokens\": 2048,\n" +
                "    \"stopSequences\": []\n" +
                "  }\n" +
                "}";

        return webClient
                .post()
                .uri("?key=" + apiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class) // Recibir la respuesta como String
                .map(response -> {
                    try {
                        // Intentar parsear la respuesta a un JsonObject
                        JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);

                        // Verificar si la respuesta contiene la estructura esperada
                        if (jsonResponse.has("candidates")) {
                            String respuestaTexto = jsonResponse.getAsJsonArray("candidates")
                                    .get(0).getAsJsonObject()
                                    .getAsJsonObject("content")
                                    .getAsJsonArray("parts")
                                    .get(0).getAsJsonObject()
                                    .get("text").getAsString();

                            // Intentar extraer un valor numérico de la respuesta de texto

                            String valorNumerico = respuestaTexto.replaceAll("[^0-9]", ""); // Eliminar todo lo que no
                                                                                            // sea un dígito

                            if (valorNumerico.isEmpty()) {
                                valorNumerico = "0"; // Valor por defecto si no se encuentra un número
                            }

                            // Construir el JSON de respuesta
                            return "{\"text\": \"" + respuestaTexto + "\", \"valor\": " + valorNumerico + "}";
                        } else {
                            return "{\"text\": \"Respuesta inesperada de la API de Gemini.\", \"valor\": 0}";
                        }
                    } catch (Exception e) {
                        // Manejar errores de parseo o formato
                        System.err.println("Error al parsear la respuesta JSON: " + e.getMessage());
                        return "{\"text\": \"Error al procesar la respuesta de la API.\", \"valor\": 0}";
                    }
                })
                .onErrorResume(e -> {
                    System.err.println("Error al llamar a la API de Gemini: " + e.getMessage());
                    return Mono.just("{\"text\": \"Error al comunicarse con la API de Gemini.\", \"valor\": 0}");
                });
    }
}
