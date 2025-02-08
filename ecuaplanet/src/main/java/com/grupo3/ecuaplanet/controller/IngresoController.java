package com.grupo3.ecuaplanet.controller;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.ecuaplanet.service.IngresoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ingresos")
public class IngresoController {
    private final IngresoService ingresoService;

    public IngresoController(IngresoService ingresoService){
        this.ingresoService=ingresoService;
    }
    
    @GetMapping("/max-venta")
    public List<Map<String,Object>> obtenerPedidoMayorVenta() {
        return ingresoService.obtenerPedidoMayorVenta();
    }
}
