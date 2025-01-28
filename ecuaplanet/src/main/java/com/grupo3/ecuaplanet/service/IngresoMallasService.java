package com.grupo3.ecuaplanet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.ecuaplanet.dto.CultivoDto;
import com.grupo3.ecuaplanet.model.IngresoMallas;
import com.grupo3.ecuaplanet.repository.IngresoMallaRepository;

@Service
public class IngresoMallasService {

    @Autowired
    private IngresoMallaRepository ingresoMallaRepository;


    public List<IngresoMallas> getAllIngresoMallas() {
        return ingresoMallaRepository.findAll();
    }

    public List<CultivoDto> obtenercultivo() {
        return ingresoMallaRepository.obtenercultivo();
    }
}
