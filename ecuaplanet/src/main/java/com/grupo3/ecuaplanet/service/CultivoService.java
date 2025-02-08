package com.grupo3.ecuaplanet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.ecuaplanet.dto.CultivoDto;
import com.grupo3.ecuaplanet.repository.CultivoRepository;

@Service
public class CultivoService {

    @Autowired
    private CultivoRepository ingresoMallaRepository;

    public String listToString(List<CultivoDto> list) {
        
        String text = "";
        for (CultivoDto cultivoDto : list) {
            text += "Nombre Variedad:" + cultivoDto.getNombreVariedad() + "|" +
                    "Color Variedad:" + cultivoDto.getColorVariedad() + "|" +
                    "Bloque:" + cultivoDto.getBloque() + "|" +
                    "Camas Variedad:" + cultivoDto.getCamasVariedad() + "|" +
                    "Cantidad Mallas Ingreso:" + cultivoDto.getCantidadMallasIngreso() + "|" +
                    "Fecha Hora Ingreso:" + cultivoDto.getFechaHoraIngreso() + "|" +
                    "Tallos Por Malla:" + cultivoDto.getTallosPorMalla() +
                    " \n";
        }
        return text;
    }

    public List<CultivoDto> obtenercultivo(String queryVector) {
        return ingresoMallaRepository.obtenercultivo(queryVector);
    }

}
