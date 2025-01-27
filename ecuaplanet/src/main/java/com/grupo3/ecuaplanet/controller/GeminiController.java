package com.grupo3.ecuaplanet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.ecuaplanet.dto.BodyGeminiDto;
import com.grupo3.ecuaplanet.dto.ContentDto;
import com.grupo3.ecuaplanet.dto.GeminiResponseDto;
import com.grupo3.ecuaplanet.dto.PartDto;
import com.grupo3.ecuaplanet.dto.RequestGeminiDto;
import com.grupo3.ecuaplanet.model.IngresoMallas;
import com.grupo3.ecuaplanet.model.Variedades;
import com.grupo3.ecuaplanet.service.GeminiService;
import com.grupo3.ecuaplanet.service.IngresoMallaService;
import com.grupo3.ecuaplanet.service.VariedadesService;

import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/gemini")
public class GeminiController {

    @Autowired
    private GeminiService geminiService;

    @Autowired
    private VariedadesService variedadesService;

    @Autowired
    private IngresoMallaService ingresoMallaService;
    
    @PostMapping("/cultivo")
    public Mono<GeminiResponseDto> getEmbbeding(@RequestBody RequestGeminiDto requestGeminiDto) {

        List<Variedades> variedades = variedadesService.getVariedadesRepository();
        String response = requestGeminiDto.getText() + " \n";
        for (Variedades variedad : variedades) {
            response += "Lista Variedades: \n id:" + variedad.getIdVariedad() + "Nombre Variedad:"
                    + variedad.getNombreVariedad() + "|" + " Color:" + variedad.getColorVariedad()
                    + "|" + " Bloque:" + variedad.getBloque() + "|" + " Camas:" + variedad.getCamasVariedad() + "\n";
        }
        List<IngresoMallas> ingresoMallas = ingresoMallaService.getIngresoMallaRepository();
        for (IngresoMallas mallas : ingresoMallas) {
            response += "Lista Mallas: \n id:" + mallas.getIdIngresoMallas() + "|" + "id Variedad:"
                    + mallas.getIdVariedad()
                    + "|" + "Cantidad Mallas de Ingreso:" + mallas.getCantidadMallasIngreso() + "|" + "Fecha Ingreso:"
                    + mallas.getFechaHoraIngreso()
                    + "|" + "Tallos Por Malla:" + mallas.getTallosPorMalla()
                    + "\n";
        }
        PartDto part = new PartDto(response);
        ContentDto contents = new ContentDto(List.of(part));
        BodyGeminiDto body = new BodyGeminiDto(contents);

        return geminiService.getResponse(body);
    }

}
