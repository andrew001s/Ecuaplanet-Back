package com.grupo3.ecuaplanet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.grupo3.ecuaplanet.dto.BodyGeminiDto;
import com.grupo3.ecuaplanet.dto.GeminiResponseDto;

import reactor.core.publisher.Mono;

@Service
public class GeminiService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Mono<GeminiResponseDto> getResponse(BodyGeminiDto text) {
        return webClientBuilder
          .build()
          .post()
          .uri(
              "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=AIzaSyDnpmCfLhQu-AZErdW9_35FeKcwLFlurnE")
          .bodyValue(text)
          .retrieve()
          .bodyToMono(GeminiResponseDto.class);
    }

    public Mono<String> getEmbbeding (String text) {
        return webClientBuilder
          .build()
          .post()
          .uri(
              "https://generativelanguage.googleapis.com/v1beta/models/text-embedding-004:embedContent?key=AIzaSyDnpmCfLhQu-AZErdW9_35FeKcwLFlurnE")
          .bodyValue(text)
          .retrieve()
          .bodyToMono(String.class);
    }
}
