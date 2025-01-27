package com.grupo3.ecuaplanet.repository;

import com.grupo3.ecuaplanet.model.IngresoMallas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IngresoMallasRepository extends JpaRepository<IngresoMallas, Long> {

    // 1. Buscar ingresos de mallas por ID de la variedad
    List<IngresoMallas> findByVariedadesIdVariedad(Long idVariedad);

    // 2. Buscar ingresos de mallas en un rango de fechas y horas
    List<IngresoMallas> findByFechaHoraIngresoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // 3. Encontrar la mayor cantidad de mallas ingresadas
    @Query("SELECT im FROM IngresoMallas im WHERE im.cantidadMallasIngreso = (SELECT MAX(im2.cantidadMallasIngreso) FROM IngresoMallas im2)")
    List<IngresoMallas> findByMaxCantidadMallasIngreso();

    // 4. Ejemplo: Contar el número total de tallos ingresados por variedad
    @Query("SELECT SUM(im.cantidadMallasIngreso * im.tallosPorMalla) FROM IngresoMallas im WHERE im.variedades.idVariedad = :idVariedad")
    Long sumTotalTallosIngresadosByVariedad(@Param("idVariedad") Long idVariedad);
}