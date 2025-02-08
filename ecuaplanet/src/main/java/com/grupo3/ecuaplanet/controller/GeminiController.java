package com.grupo3.ecuaplanet.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.ecuaplanet.constants.GeminiConstants;
import com.grupo3.ecuaplanet.dto.CultivoDto;
import com.grupo3.ecuaplanet.dto.EmbeddingDto;
import com.grupo3.ecuaplanet.dto.GeminiResponseDto;
import com.grupo3.ecuaplanet.dto.ProduccionDto;
import com.grupo3.ecuaplanet.dto.RequestGeminiDto;
import com.grupo3.ecuaplanet.dto.VentasDto;
import com.grupo3.ecuaplanet.service.CultivoService;
import com.grupo3.ecuaplanet.service.GeminiService;
import com.grupo3.ecuaplanet.service.ProduccionService;
import com.grupo3.ecuaplanet.service.QdrantService;
import com.grupo3.ecuaplanet.service.VentaService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/gemini")
@CrossOrigin(origins = "*")
public class GeminiController {

    @Autowired
    private GeminiService geminiService;

    @Autowired
    private CultivoService cultivoService;

    @Autowired
    private ProduccionService produccionService;

    @Autowired
    private VentaService ventaService;

    @Autowired
    private QdrantService qdrantService;

    @PostMapping("/cultivo")
    public Mono<GeminiResponseDto> getCultivo(@RequestBody RequestGeminiDto requestGeminiDto) {
        try {
            String response = requestGeminiDto.getText();
            String clasification = geminiService.clasificador(requestGeminiDto);
            if (clasification.equals("Específica")) {
                EmbeddingDto embeddingDto = geminiService.getEmbedding(response);
                String arrays = Arrays.toString(embeddingDto.getEmbedding().getValues());
                List<CultivoDto> cultivo = cultivoService.obtenercultivo(arrays);
                response += GeminiConstants.PROMP_STRING + cultivoService.listToString(cultivo);
                return geminiService.getRequest(response);
            } else {
                response = qdrantService.searchVector(response, "cultivo_resumen");
                return geminiService.getRequest(response);
            }
        } catch (Exception e) {
            return Mono.just(new GeminiResponseDto());
        }
    }

    @PostMapping("/produccion")
    public Mono<GeminiResponseDto> getProduccion(@RequestBody RequestGeminiDto requestGeminiDto) {
        try {

            String response = requestGeminiDto.getText();
            String clasification = geminiService.clasificador(requestGeminiDto);
            if (clasification.equals("Específica")) {
                EmbeddingDto embeddingDto = geminiService.getEmbedding(response);
                String arrays = Arrays.toString(embeddingDto.getEmbedding().getValues());
                List<ProduccionDto> produccion = produccionService.obtenerProduccion(arrays);
                response += GeminiConstants.PROMP_STRING + produccionService.listToString(produccion);
                return geminiService.getRequest(response);
            } else {
                response = qdrantService.searchVector(response, "produccion_resumen");
                return geminiService.getRequest(response);
            }
        } catch (Exception e) {
            return Mono.just(new GeminiResponseDto());
        }
    }

    @PostMapping("/ventas")
    public Mono<GeminiResponseDto> getVentas(@RequestBody RequestGeminiDto requestGeminiDto) {
        try {
            String response = requestGeminiDto.getText();
            String clasification = geminiService.clasificador(requestGeminiDto);
            if (clasification.equals("Específica")) {
                EmbeddingDto embeddingDto = geminiService.getEmbedding(response);
                String arrays = Arrays.toString(embeddingDto.getEmbedding().getValues());
                List<VentasDto> ventas = ventaService.obtenerVentas(arrays);
                response += GeminiConstants.PROMP_STRING + ventaService.listToString(ventas);
                return geminiService.getRequest(response);
            } else {
                response = qdrantService.searchVector(response, "ventas_resumen");
                return geminiService.getRequest(response);
            }
        } catch (Exception e) {
            return Mono.just(new GeminiResponseDto());
        }
    }

    

   

}
