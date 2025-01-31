package com.grupo3.ecuaplanet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.grupo3.ecuaplanet.dto.BodyGeminiDto;
import com.grupo3.ecuaplanet.dto.ContentDto;
import com.grupo3.ecuaplanet.dto.EmbeddingDto;
import com.grupo3.ecuaplanet.dto.GeminiResponseDto;
import com.grupo3.ecuaplanet.dto.PartDto;

import reactor.core.publisher.Mono;

@Service
public class GeminiService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Mono<GeminiResponseDto> getRequest(String text) {
        return makeGeminiRequest(text);
    }
    
    @Async
    private Mono<GeminiResponseDto> makeGeminiRequest(String text) {
        
        PartDto part = new PartDto(text);
        ContentDto contents = new ContentDto(List.of(part));
        BodyGeminiDto body = new BodyGeminiDto(contents);

        return webClientBuilder
                .build()
                .post()
                .uri("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=AIzaSyDnpmCfLhQu-AZErdW9_35FeKcwLFlurnE")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(GeminiResponseDto.class);
    }

    @Async
    public EmbeddingDto getEmbedding(String text) {
        return webClientBuilder
                .build()
                .post()
                .uri("https://generativelanguage.googleapis.com/v1beta/models/text-embedding-004:embedContent?key=AIzaSyDnpmCfLhQu-AZErdW9_35FeKcwLFlurnE")
                .header("Content-Type", "application/json")
                .bodyValue("{\"model\": \"models/text-embedding-004\", \"content\": {\"parts\": [{\"text\": \"" + text + "\"}]}}")
                .retrieve()
                .bodyToMono(EmbeddingDto.class)
                .block();
    }
    
    
}
