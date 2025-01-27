package com.grupo3.ecuaplanet.repository;

import com.grupo3.ecuaplanet.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {

    // 1. Buscar pedidos por ID de cliente
    List<Pedidos> findByClientesIdCliente(Long idCliente);

    // 2. Buscar pedidos en un rango de fechas de venta
    List<Pedidos> findByFechaVentaBetween(LocalDate fechaInicio, LocalDate fechaFin);

    // 3. Encontrar el pedido con el monto total de venta más alto
    @Query("SELECT p FROM Pedidos p WHERE p.montoTotalVenta = (SELECT MAX(p2.montoTotalVenta) FROM Pedidos p2)")
    List<Pedidos> findByMaxMontoTotalVenta();

    // 4. Ejemplo: Obtener el promedio del monto total de venta para un cliente
    // específico
    @Query("SELECT AVG(p.montoTotalVenta) FROM Pedidos p WHERE p.clientes.idCliente = :idCliente")
    Double findAverageMontoTotalVentaByCliente(@Param("idCliente") Long idCliente);
}