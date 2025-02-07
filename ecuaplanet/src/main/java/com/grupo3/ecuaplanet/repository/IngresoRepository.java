package com.grupo3.ecuaplanet.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class IngresoRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> obtenerPedidoMayorVenta(){
        String sql="SELECT cl.nombre_cliente,cl.tipo_cliente,cl.pais_cliente,p.id_pedido,p.monto_total_venta"+
        "FROM pedidos p JOIN clientes cl ON p.id_cliente = cl.id_cliente"+
        "WHERE p.monto_total_venta=(select MAX(monto_total_venta)FROM pedidos)";
        return entityManager.createNativeQuery(sql).getResultList();
    }
}