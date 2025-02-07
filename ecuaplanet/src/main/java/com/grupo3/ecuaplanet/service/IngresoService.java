package com.grupo3.ecuaplanet.service;

import com.grupo3.ecuaplanet.repository.IngresoRepository;    
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class IngresoService {
    private final IngresoRepository ingresoRepository;
    
    public IngresoService(IngresoRepository ingresoRepository){
        this.ingresoRepository = ingresoRepository;
    }
    public List<Map<String,Object>> obtenerPedidoMayorVenta(){
        List<Object[]> resultados = ingresoRepository.obtenerPedidoMayorVenta();
        
        //convertir los resultados en una lista de Map para mejor manejo
        return resultados.stream().map(row ->{
            Map<String,Object> map = new HashMap<>();
            map.put("nombreCliente",row[0]);
            map.put("tipoCliente",row[1]);
            map.put("paisCliente",row[2]);
            map.put("idPedido",row[3]);
            map.put("montoTotalVenta",row[4]);
            return map;
        }).toList();
    }
}
