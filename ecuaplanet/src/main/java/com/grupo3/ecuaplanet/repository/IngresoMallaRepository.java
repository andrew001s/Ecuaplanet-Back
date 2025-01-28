package com.grupo3.ecuaplanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo3.ecuaplanet.dto.CultivoDto;
import com.grupo3.ecuaplanet.model.IngresoMallas;

@Repository
public interface IngresoMallaRepository extends JpaRepository<IngresoMallas, Integer> {

    @Query(value = "SELECT v.nombre_variedad AS nombreVariedad, v.color_variedad AS colorVariedad, " +
                   "v.bloque AS bloque, v.camas_variedad AS camasVariedad, " +
                   "i.cantidad_mallas_ingreso AS cantidadMallasIngreso, "  +
                   "i.fecha_hora_ingreso AS fechaHoraIngreso, " +
                    "i.tallos_por_malla AS tallosPorMalla " +
                   "FROM variedades v " +
                   "JOIN ingreso_mallas i ON i.id_variedad = v.id_variedad",
           nativeQuery = true)
    List<CultivoDto> obtenercultivo();
}
