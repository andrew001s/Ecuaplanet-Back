package com.grupo3.ecuaplanet.service;

import com.grupo3.ecuaplanet.repository.IngresoRepository;    
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.sql.Date;

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
            map.put("paisCliente",row[1]);
            if(row[2] instanceof Date){
                map.put("fechaVenta",((Date) row[2]).toLocalDate());
            }else{
                map.put("fechaVenta",null);
            }
            map.put("montoTotalVenta",((Number) row[3]).doubleValue());
            return map;
        }).toList();
    }
}
