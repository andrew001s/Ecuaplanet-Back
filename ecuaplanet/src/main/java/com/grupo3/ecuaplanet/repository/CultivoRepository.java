package com.grupo3.ecuaplanet.repository;

import com.grupo3.ecuaplanet.dto.CultivoDto;
import com.grupo3.ecuaplanet.model.IngresoMallas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CultivoRepository extends JpaRepository<IngresoMallas, Integer> {

    @Query(value = "SELECT "
            + "i.nombre_variedad AS nombreVariedad, "
            + "i.camas_variedad AS camasVariedad, "
            + "i.bloque AS bloque, "
            + "i.color_variedad AS colorVariedad, "
            + "o.cantidad_mallas_ingreso AS cantidadMallasIngreso, "
            + "o.fecha_hora_ingreso AS fechaHoraIngreso, "
            + "o.tallos_por_malla AS tallosPorMall, "
            + "1 - (i.embedding <=> CAST(:queryVector AS vector)) AS similarity "
            + "FROM variedades i "
            + "JOIN ingreso_mallas o ON i.id_variedad = o.id_variedad "
            + "WHERE 1 - (i.embedding <=> CAST(:queryVector AS vector)) > 0.5 "
            + "ORDER BY similarity DESC", nativeQuery = true)
    List<CultivoDto> obtenercultivo(@Param("queryVector") String queryVector);
}
