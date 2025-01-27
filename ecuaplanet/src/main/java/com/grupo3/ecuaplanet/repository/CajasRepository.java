package com.grupo3.ecuaplanet.repository;

import com.grupo3.ecuaplanet.model.Cajas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CajasRepository extends JpaRepository<Cajas, Long> {

    // 1. Buscar una caja por el ID del pedido asociado
    Optional<Cajas> findByPedidosIdPedido(Long idPedido);

    // 2. Ejemplo: Encontrar la caja con el id_pedido más alto
    @Query("SELECT c FROM Cajas c WHERE c.pedidos.idPedido = (SELECT MAX(c2.pedidos.idPedido) FROM Cajas c2)")
    Optional<Cajas> findByMaxIdPedido();

}
