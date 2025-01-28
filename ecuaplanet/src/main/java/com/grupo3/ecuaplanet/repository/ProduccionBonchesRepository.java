package com.grupo3.ecuaplanet.repository;

import com.grupo3.ecuaplanet.model.ProduccionBonches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProduccionBonchesRepository extends JpaRepository<ProduccionBonches, Long> {

    // 1. Buscar producciones de bonches por ID de producto
    List<ProduccionBonches> findByProductosBonchesIdProducto(Long idProducto);

    // 2. Buscar producciones de bonches en un rango de fechas de ingreso
    List<ProduccionBonches> findByFechaIngresoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // 3. Buscar producciones de bonches por estado de bonche
    List<ProduccionBonches> findByEstadoBonche(String estadoBonche);

    // 4. Ejemplo: Encontrar la producción de bonche con la fecha de ingreso más
    // reciente para un producto específico
    @Query("SELECT pb FROM ProduccionBonches pb WHERE pb.productosBonches.idProducto = :idProducto ORDER BY pb.fechaIngreso DESC")
    List<ProduccionBonches> findLatestByProducto(@Param("idProducto") Long idProducto);
}