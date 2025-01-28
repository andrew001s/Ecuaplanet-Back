package com.grupo3.ecuaplanet.service;

import com.grupo3.ecuaplanet.model.ProduccionBonches;
import com.grupo3.ecuaplanet.repository.ProduccionBonchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProduccionBonchesService {

    @Autowired
    private ProduccionBonchesRepository produccionBonchesRepository;

    // --- Métodos CRUD ---

    public ProduccionBonches saveProduccionBonche(ProduccionBonches produccionBonche) {
        return produccionBonchesRepository.save(produccionBonche);
    }

    public List<ProduccionBonches> getAllProduccionBonches() {
        return produccionBonchesRepository.findAll();
    }

    public Optional<ProduccionBonches> getProduccionBoncheById(Long id) {
        return produccionBonchesRepository.findById(id);
    }

    public ProduccionBonches updateProduccionBonche(ProduccionBonches produccionBonche) {
        return produccionBonchesRepository.save(produccionBonche);
    }

    public void deleteProduccionBonche(Long id) {
        produccionBonchesRepository.deleteById(id);
    }

    // --- Métodos Personalizados ---

    public List<ProduccionBonches> getProduccionBonchesByProductoId(Long productoId) {
        return produccionBonchesRepository.findByProductosBonchesIdProducto(productoId);
    }

    public List<ProduccionBonches> getProduccionBonchesByFechaIngresoBetween(LocalDateTime fechaInicio,
            LocalDateTime fechaFin) {
        return produccionBonchesRepository.findByFechaIngresoBetween(fechaInicio, fechaFin);
    }

    public List<ProduccionBonches> getProduccionBonchesByEstadoBonche(String estadoBonche) {
        return produccionBonchesRepository.findByEstadoBonche(estadoBonche);
    }

    public List<ProduccionBonches> getLatestProduccionBoncheByProducto(Long productoId) {
        return produccionBonchesRepository.findLatestByProducto(productoId);
    }
}