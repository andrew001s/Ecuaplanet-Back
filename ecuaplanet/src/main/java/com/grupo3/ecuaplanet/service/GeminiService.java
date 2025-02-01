package com.grupo3.ecuaplanet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.grupo3.ecuaplanet.constants.GeminiConstants;
import com.grupo3.ecuaplanet.dto.BodyGeminiDto;
import com.grupo3.ecuaplanet.dto.CandidateDto;
import com.grupo3.ecuaplanet.dto.ContentDto;
import com.grupo3.ecuaplanet.dto.EmbeddingDto;
import com.grupo3.ecuaplanet.dto.GeminiResponseDto;
import com.grupo3.ecuaplanet.dto.PartDto;
import com.grupo3.ecuaplanet.dto.RequestGeminiDto;

import reactor.core.publisher.Mono;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String ApiKey;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Mono<GeminiResponseDto> getRequest(String text) {
        return makeGeminiRequest(text);
    }

    private Mono<GeminiResponseDto> sendGeminiRequest(BodyGeminiDto body) {
        return webClientBuilder
                .build()
                .post()
                .uri("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key="
                        + ApiKey)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(GeminiResponseDto.class);

    }

    @Async
    private Mono<GeminiResponseDto> makeGeminiRequest(String text) {

        PartDto part = new PartDto(text);
        ContentDto contents = new ContentDto(List.of(part));
        BodyGeminiDto body = new BodyGeminiDto(contents);

        return sendGeminiRequest(body);
    }

    @Async
    public Mono<GeminiResponseDto> classifierGeminiRequest(String text) {

        PartDto part = new PartDto(text);
        ContentDto contents = new ContentDto(List.of(part));
        BodyGeminiDto body = new BodyGeminiDto(contents);
        return sendGeminiRequest(body);
    }

    @Async
    public EmbeddingDto getEmbedding(String text) {
        return webClientBuilder
                .build()
                .post()
                .uri("https://generativelanguage.googleapis.com/v1beta/models/text-embedding-004:embedContent?key="
                        + ApiKey)
                .header("Content-Type", "application/json")
                .bodyValue("{\"model\": \"models/text-embedding-004\", \"content\": {\"parts\": [{\"text\": \"" + text
                        + "\"}]}}")
                .retrieve()
                .bodyToMono(EmbeddingDto.class)
                .block();
    }

    public String clasificador(RequestGeminiDto RequestGeminiDto) {
        String response = GeminiConstants.PROMP_STRING_CLASSIFIER + RequestGeminiDto.getText();
        GeminiResponseDto geminiResponse = classifierGeminiRequest(response).block();
        CandidateDto candidate = geminiResponse.getCandidates().get(0);
        String valueClasificate = candidate.getContent().getParts().get(0).getText();
        valueClasificate = valueClasificate.replaceAll("\\s+", "");
        return valueClasificate;
    }

}
