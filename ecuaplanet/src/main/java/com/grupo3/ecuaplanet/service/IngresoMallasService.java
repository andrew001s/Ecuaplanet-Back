package com.grupo3.ecuaplanet.service;

import com.grupo3.ecuaplanet.model.IngresoMallas;
import com.grupo3.ecuaplanet.repository.IngresoMallasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IngresoMallasService {

    @Autowired
    private IngresoMallasRepository ingresoMallasRepository;

    // --- Métodos CRUD ---

    public IngresoMallas saveIngresoMallas(IngresoMallas ingresoMallas) {
        return ingresoMallasRepository.save(ingresoMallas);
    }

    public List<IngresoMallas> getAllIngresoMallas() {
        return ingresoMallasRepository.findAll();
    }

    public Optional<IngresoMallas> getIngresoMallasById(Long id) {
        return ingresoMallasRepository.findById(id);
    }

    public IngresoMallas updateIngresoMallas(IngresoMallas ingresoMallas) {
        return ingresoMallasRepository.save(ingresoMallas);
    }

    public void deleteIngresoMallas(Long id) {
        ingresoMallasRepository.deleteById(id);
    }

    // --- Métodos Personalizados ---

    public List<IngresoMallas> getIngresosMallasByVariedadId(Long variedadId) {
        return ingresoMallasRepository.findByVariedadesIdVariedad(variedadId);
    }

    public List<IngresoMallas> getIngresosMallasByFechaHoraIngresoBetween(LocalDateTime fechaInicio,
            LocalDateTime fechaFin) {
        return ingresoMallasRepository.findByFechaHoraIngresoBetween(fechaInicio, fechaFin);
    }

    public List<IngresoMallas> getIngresosMallasByMaxCantidadMallasIngreso() {
        return ingresoMallasRepository.findByMaxCantidadMallasIngreso();
    }

    public Long getSumTotalTallosIngresadosByVariedad(Long variedadId) {
        return ingresoMallasRepository.sumTotalTallosIngresadosByVariedad(variedadId);
    }
}