package com.grupo3.ecuaplanet.repository;

import com.grupo3.ecuaplanet.dto.ProduccionDto;
import com.grupo3.ecuaplanet.model.ProduccionBonches;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduccionBonchesRepository extends JpaRepository<ProduccionBonches, Integer> {

    @Query(value = "SELECT v.nombre_variedad AS nombreVariedad, v.color_variedad AS colorVariedad, " +
            "pb.largo_bonche AS largoBonche, pb.tallos_por_bonche AS tallosPorBonche, " +
            "p.fecha_ingreso AS fechaIngreso, " +
            "pb.valor AS valor, " +
            "p.estado_bonche AS estadoBonche " +
            "FROM produccion_bonches p " +
            "JOIN productos_bonches pb ON pb.id_producto = p.id_producto " +
            "JOIN variedades v ON v.id_variedad = pb.id_variedad", 
            nativeQuery = true)
    List<ProduccionDto> obtenerProduccion();

}
