package com.grupo3.ecuaplanet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.grupo3.ecuaplanet.dto.BodyGeminiDto;
import com.grupo3.ecuaplanet.dto.ContentDto;
import com.grupo3.ecuaplanet.dto.CultivoDto;
import com.grupo3.ecuaplanet.dto.GeminiResponseDto;
import com.grupo3.ecuaplanet.dto.PartDto;

import reactor.core.publisher.Mono;

@Service
public class GeminiService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private IngresoMallasService ingresoMallasService;

    public Mono<GeminiResponseDto> getResponse(String text) {
        List<CultivoDto> cultivo = ingresoMallasService.obtenercultivo();
        for (CultivoDto cultivoDto : cultivo) {
            text += "Nombre Variedad:" + cultivoDto.getNombreVariedad() + "|" +
                    "Color Variedad:" + cultivoDto.getColorVariedad() + "|" +
                    "Bloque:" + cultivoDto.getBloque() + "|" +
                    "Camas Variedad:" + cultivoDto.getCamasVariedad() + "|" +
                    "Cantidad Mallas Ingreso:" + cultivoDto.getCantidadMallasIngreso() + "|" +
                    "Fecha Hora Ingreso:" + cultivoDto.getFechaHoraIngreso() + "|" +
                    "Tallos Por Malla:" + cultivoDto.getTallosPorMalla() +
                    " \n";
        }
        PartDto part = new PartDto(text);
        ContentDto contents = new ContentDto(List.of(part));
        BodyGeminiDto body = new BodyGeminiDto(contents);

        return webClientBuilder
                .build()
                .post()
                .uri(
                        "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=AIzaSyDnpmCfLhQu-AZErdW9_35FeKcwLFlurnE")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(GeminiResponseDto.class);
    }

}
