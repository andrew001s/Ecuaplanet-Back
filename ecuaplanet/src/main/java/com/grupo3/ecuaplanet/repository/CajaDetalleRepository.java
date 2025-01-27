package com.grupo3.ecuaplanet.repository;

import com.grupo3.ecuaplanet.model.CajaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Repository
public interface CajaDetalleRepository extends JpaRepository<CajaDetalle, Long> {

    // 1. Buscar detalles de caja por ID de caja
    List<CajaDetalle> findByCajasIdCaja(Long idCaja);

    // 2. Buscar detalles de caja por rango de fechas de registro
    List<CajaDetalle> findByFechaRegistroBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // 3. Obtener todos los detalles de caja de un determinado producto (usando
    // id_produccion_bonche)
    List<CajaDetalle> findByIdProduccionBonche(Long idProduccionBonche);

    // 4. Contar la cantidad de detalles de caja registrados en un día específico
    @Query("SELECT COUNT(cd) FROM CajaDetalle cd WHERE DATE(cd.fechaRegistro) = :fecha")
    Long countByFechaRegistro(@Param("fecha") LocalDate fecha);

    // 5. Ejemplo: Encontrar los detalles de caja con el mayor valor de
    // id_produccion_bonche
    @Query("SELECT cd FROM CajaDetalle cd WHERE cd.idProduccionBonche = (SELECT MAX(cd2.idProduccionBonche) FROM CajaDetalle cd2)")
    List<CajaDetalle> findByMaxIdProduccionBonche();

    // 6. Ejemplo: Obtener la suma de id_produccion_bonche para un rango de fechas
    @Query("SELECT SUM(cd.idProduccionBonche) FROM CajaDetalle cd WHERE cd.fechaRegistro BETWEEN :fechaInicio AND :fechaFin")
    Long sumIdProduccionBoncheByFechaRegistroBetween(@Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin);
}