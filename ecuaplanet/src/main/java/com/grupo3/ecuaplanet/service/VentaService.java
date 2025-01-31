package com.grupo3.ecuaplanet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.ecuaplanet.dto.VentasDto;
import com.grupo3.ecuaplanet.repository.VentasRepository;

@Service
public class VentaService {

    @Autowired
    private VentasRepository ventasRepository;

    public String listToString(List<VentasDto> lista) {
        String text = "Nombre Cliente|Pais Cliente|Tipo Cliente|Color Variedad|Fecha Venta|Largo bonche| Fecha Venta | Monto Total \n";
        for (VentasDto produccionDto : lista) {
            text += produccionDto.getNombreCliente() + "|" +
                    produccionDto.getPaisCliente() + "|" +
                    produccionDto.getTipoCliente() + "|" +
                    produccionDto.getColorVariedad() + "|" +
                    produccionDto.getFechaVenta() + "|" +
                    produccionDto.getLargoBonche() + "|" +
                    produccionDto.getFechaVenta() + "|" +
                    produccionDto.getMontoTotal() +
                    " \n";
        }
        return text;
    }

    public List<VentasDto> obtenerVentas(String queryVector) {
        return ventasRepository.obtenerVentas(queryVector);
    }

}
