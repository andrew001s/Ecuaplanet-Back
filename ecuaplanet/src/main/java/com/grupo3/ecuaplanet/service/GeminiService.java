package com.grupo3.ecuaplanet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.grupo3.ecuaplanet.dto.BodyGeminiDto;
import com.grupo3.ecuaplanet.dto.ContentDto;
import com.grupo3.ecuaplanet.dto.CultivoDto;
import com.grupo3.ecuaplanet.dto.GeminiResponseDto;
import com.grupo3.ecuaplanet.dto.PartDto;
import com.grupo3.ecuaplanet.dto.ProduccionDto;

import reactor.core.publisher.Mono;

@Service
public class GeminiService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private CultivoService ingresoMallasService;

    @Autowired
    private ProduccionService produccionService;

    public Mono<GeminiResponseDto> getCultivo(String text) {
        List<CultivoDto> cultivo = ingresoMallasService.obtenercultivo();
        text+=  ingresoMallasService.listToString(cultivo);
        
        return makeGeminiRequest(text);
    }

    public Mono<GeminiResponseDto> getProduccion(String text) {
        List<ProduccionDto> produccion = produccionService.obtenerProduccion();
        text+=  produccionService.listToString(produccion);
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

}
