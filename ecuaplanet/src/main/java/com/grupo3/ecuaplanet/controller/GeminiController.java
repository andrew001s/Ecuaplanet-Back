package com.grupo3.ecuaplanet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.ecuaplanet.dto.GeminiResponseDto;
import com.grupo3.ecuaplanet.dto.RequestGeminiDto;
import com.grupo3.ecuaplanet.service.GeminiService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/gemini")
@CrossOrigin(origins = "*")
public class GeminiController {

    @Autowired
    private GeminiService geminiService;
    
    private final static String PROMP_STRING = "Eres un asistente que ayuda a los usuarios a obtener información de una base de datos de una floricola. \n" + //
                "Responde las preguntas del usuario basándote *únicamente* en la siguiente información extraída de la base de datos.\n" + //
                "Si no puedes responder la pregunta con la información dada, responde: \"No tengo información suficiente para responder esa pregunta\". \n" + //
                "No inventes información. \n" ;
    
    @PostMapping("/cultivo")
    public Mono<GeminiResponseDto> getCultivo(@RequestBody RequestGeminiDto requestGeminiDto) {

        String response = PROMP_STRING + requestGeminiDto.getText() + " \n";
        return geminiService.getCultivo(response);
    }

    @PostMapping("/produccion")
    public Mono<GeminiResponseDto> getProduccion(@RequestBody RequestGeminiDto requestGeminiDto) {
        
        String response = PROMP_STRING + requestGeminiDto.getText() + " \n";
        return geminiService.getProduccion(response);

    }
    

}
