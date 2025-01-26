package com.grupo3.ecuaplanet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.ecuaplanet.model.Variedades;
import com.grupo3.ecuaplanet.service.VariedadesService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/variedades")
public class VariedadController {
    @Autowired
    private VariedadesService variedadesService;

    @GetMapping
    public ResponseEntity<List<Variedades>> getAll() {
        try {
            List<Variedades> variedades = variedadesService.getVariedadesRepository();
            return ResponseEntity.ok(variedades);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    
}
