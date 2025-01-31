package com.grupo3.ecuaplanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo3.ecuaplanet.dto.VentasDto;
import com.grupo3.ecuaplanet.model.CajaDetalles;

@Repository
public interface VentasRepository extends JpaRepository<CajaDetalles, Integer> {

    @Query(value = "SELECT cd.id_caja_detalle AS idCajaDetalle, "
            + "cl.nombre_cliente AS nombreCliente, "
            + "cl.pais_cliente AS paisCliente, "
            + "cl.tipo_cliente AS tipoCliente, "
            + "v.nombre_variedad AS nombreVariedad, "
            + "v.color_variedad AS colorVariedad, "
            + "prod.largo_bonche AS largoBonche, "
            + "p.fecha_venta AS fechaVenta, "
            + "p.monto_total_venta AS montoTotal, "
            + "1 - (cd.embedding <=> CAST(:queryVector AS vector)) AS similarity "
            + "FROM caja_detalles cd "
            + "JOIN cajas c ON cd.id_caja = c.id_caja "
            + "JOIN pedidos p ON c.id_pedido = p.id_pedido "
            + "JOIN clientes cl ON p.id_cliente = cl.id_cliente "
            + "JOIN produccion_bonches pb ON cd.id_produccion_bonche = pb.id_produccion_bonche "
            + "JOIN productos_bonches prod ON pb.id_producto = prod.id_producto "
            + "JOIN variedades v ON prod.id_variedad = v.id_variedad "
            + "WHERE 1 - (cd.embedding <=> CAST(:queryVector AS vector)) > 0.5 "
            + "ORDER BY similarity DESC", nativeQuery = true)
    List<VentasDto> obtenerVentas(@Param("queryVector") String queryVector);
}
