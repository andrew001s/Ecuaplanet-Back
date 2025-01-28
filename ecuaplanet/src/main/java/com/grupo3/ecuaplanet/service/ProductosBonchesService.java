package com.grupo3.ecuaplanet.service;

import com.grupo3.ecuaplanet.model.ProductosBonches;
import com.grupo3.ecuaplanet.repository.ProductosBonchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosBonchesService {

    @Autowired
    private ProductosBonchesRepository productosBonchesRepository;

    // --- Métodos CRUD ---

    public ProductosBonches saveProductoBonche(ProductosBonches productoBonche) {
        return productosBonchesRepository.save(productoBonche);
    }

    public List<ProductosBonches> getAllProductosBonches() {
        return productosBonchesRepository.findAll();
    }

    public Optional<ProductosBonches> getProductoBoncheById(Long id) {
        return productosBonchesRepository.findById(id);
    }

    public ProductosBonches updateProductoBonche(ProductosBonches productoBonche) {
        return productosBonchesRepository.save(productoBonche);
    }

    public void deleteProductoBonche(Long id) {
        productosBonchesRepository.deleteById(id);
    }

    // --- Métodos Personalizados ---

    public List<ProductosBonches> getProductosBonchesByVariedadId(Long variedadId) {
        return productosBonchesRepository.findByVariedadesIdVariedad(variedadId);
    }

    public List<ProductosBonches> getProductosBonchesByLargoBoncheBetween(Integer largoMin, Integer largoMax) {
        return productosBonchesRepository.findByLargoBoncheBetween(largoMin, largoMax);
    }

    public List<ProductosBonches> getProductosBonchesByTallosPorBoncheBetween(Integer tallosMin, Integer tallosMax) {
        return productosBonchesRepository.findByTallosPorBoncheBetween(tallosMin, tallosMax);
    }

    public List<ProductosBonches> getProductosBonchesByMaxValue() {
        return productosBonchesRepository.findByMaxValue();
    }

    public List<ProductosBonches> getProductosBonchesByVariedad(Long variedadId) {
        return productosBonchesRepository.findByVariedad(variedadId);
    }
}