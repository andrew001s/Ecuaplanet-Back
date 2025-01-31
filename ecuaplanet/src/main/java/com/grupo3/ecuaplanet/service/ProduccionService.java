package com.grupo3.ecuaplanet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.ecuaplanet.dto.ProduccionDto;
import com.grupo3.ecuaplanet.repository.ProduccionBonchesRepository;

@Service
public class ProduccionService {
    @Autowired
    private ProduccionBonchesRepository produccionBonchesRepository;


    public String listToString(List<ProduccionDto> lista){
        String text = "Nombre Variedad|Color Variedad|Largo Bonche|Tallos Por Bonche|Fecha Ingreso|Valor|Estado Bonche \n";
        for (ProduccionDto produccionDto : lista) {
            text +=  produccionDto.getNombreVariedad() + "|" +
                    produccionDto.getColorVariedad() + "|" +
                    produccionDto.getLargoBonche() + "|" +
                    produccionDto.getTallosPorBonche() + "|" +
                    produccionDto.getFechaIngreso() + "|" +
                    produccionDto.getValor() + "|" +
                    produccionDto.getEstadoBonche() +
                    " \n";
        }
        return text;
    }

    public List<ProduccionDto> obtenerProduccion(String queryVector) {
        return produccionBonchesRepository.obtenerProduccion(queryVector);
    }

}
