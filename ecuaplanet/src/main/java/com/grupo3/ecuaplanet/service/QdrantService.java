package com.grupo3.ecuaplanet.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.grupo3.ecuaplanet.dto.EmbeddingDto;

import reactor.core.publisher.Mono;


@Service
public class QdrantService {

    private static final String QDRANT_URL = "http://54.208.59.167:6333";

    private final WebClient webClient;

    @Autowired
    private GeminiService geminiService;


    public QdrantService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(QDRANT_URL).build();
    }

    public Mono<String> search(String embedding,String collection) {
        String queryVector = "{ \"vector\": " + embedding + ", \"name\": \"default\" }";

        return webClient.post()
                .uri("/collections/" + collection + "/points/search")
                .header("Content-Type", "application/json")
                .bodyValue("{\"vector\": " + queryVector + ", \"with_payload\": true, \"limit\": 5}")
                .retrieve()
                .bodyToMono(String.class);
    }

    public String listToString(Mono<String> list) {
        String text = list.block();
        return text;
    }

    public String searchVector(String RequestText, String collection) {
        String response = RequestText;
        EmbeddingDto embeddingDto = geminiService.getEmbedding(response);
        String arrays = Arrays.toString(embeddingDto.getEmbedding().getValues());
        Mono<String> qdrant = search(arrays, collection);
        response += listToString(qdrant);
        System.out.println(response);
        return response;

    }

}
