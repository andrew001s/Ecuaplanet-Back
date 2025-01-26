package com.grupo3.ecuaplanet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.ecuaplanet.model.Variedades;
import com.grupo3.ecuaplanet.repository.VariedadesRepository;

@Service
public class VariedadesService {
    @Autowired
    private VariedadesRepository variedadesRepository;

    public List<Variedades> getVariedadesRepository() {
        return variedadesRepository.findAll();
    }
}
