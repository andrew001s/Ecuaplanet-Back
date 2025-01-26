package com.grupo3.ecuaplanet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.ecuaplanet.dto.GeminiResponseDto;
import com.grupo3.ecuaplanet.service.GeminiService;

import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/gemini")
public class GeminiController {

    @Autowired
    private GeminiService geminiService;

    @PostMapping("/response")
    public Mono<GeminiResponseDto> getResponse(@RequestBody String text) {
        return geminiService.getResponse(text);
    }

}
