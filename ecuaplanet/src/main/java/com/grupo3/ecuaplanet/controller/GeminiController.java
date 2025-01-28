package com.grupo3.ecuaplanet.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class GeminiController {

    @Autowired
    private GeminiService geminiService;
    
    @PostMapping("/cultivo")
    public Mono<GeminiResponseDto> getCultivo(@RequestBody RequestGeminiDto requestGeminiDto) {

        String response = requestGeminiDto.getText() + " \n";
        return geminiService.getResponse(response);
    }

    @PostMapping("/produccion")
    public Mono<GeminiResponseDto> getProduccion(@RequestBody RequestGeminiDto requestGeminiDto) {
        
        String response = requestGeminiDto.getText() + " \n";
      
       
        return geminiService.getResponse(response);

    }
    

}
