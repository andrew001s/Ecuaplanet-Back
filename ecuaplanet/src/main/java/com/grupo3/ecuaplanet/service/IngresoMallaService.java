package com.grupo3.ecuaplanet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.ecuaplanet.model.IngresoMallas;
import com.grupo3.ecuaplanet.repository.IngresoMallasRepository;

@Service
public class IngresoMallaService {
    @Autowired
    private IngresoMallasRepository ingresoMallaRepository;

    public List<IngresoMallas> getIngresoMallaRepository() {
        return ingresoMallaRepository.findAll();
    }
    

}
