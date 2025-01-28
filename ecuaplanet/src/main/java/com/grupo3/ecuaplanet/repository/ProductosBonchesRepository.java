package com.grupo3.ecuaplanet.repository;

import com.grupo3.ecuaplanet.model.ProductosBonches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosBonchesRepository extends JpaRepository<ProductosBonches, Long> {

    // 1. Buscar productos por ID de variedad
    List<ProductosBonches> findByVariedadesIdVariedad(Long idVariedad);

    // 2. Buscar productos por rango de largo de bonche
    List<ProductosBonches> findByLargoBoncheBetween(Integer largoMin, Integer largoMax);

    // 3. Buscar productos por rango de tallos por bonche
    List<ProductosBonches> findByTallosPorBoncheBetween(Integer tallosMin, Integer tallosMax);

    // 4. Encontrar el producto con el mayor valor
    @Query("SELECT pb FROM ProductosBonches pb WHERE pb.valor = (SELECT MAX(pb2.valor) FROM ProductosBonches pb2)")
    List<ProductosBonches> findByMaxValue();

    // 5. Ejemplo: Obtener todos los productos de una variedad específica
    @Query("SELECT pb FROM ProductosBonches pb WHERE pb.variedades.idVariedad = :idVariedad")
    List<ProductosBonches> findByVariedad(@Param("idVariedad") Long idVariedad);

}