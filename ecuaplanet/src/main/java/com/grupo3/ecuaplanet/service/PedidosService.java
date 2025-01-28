package com.grupo3.ecuaplanet.service;

import com.grupo3.ecuaplanet.model.Pedidos;
import com.grupo3.ecuaplanet.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    // --- Métodos CRUD ---

    public Pedidos savePedido(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    public List<Pedidos> getAllPedidos() {
        return pedidosRepository.findAll();
    }

    public Optional<Pedidos> getPedidoById(Long id) {
        return pedidosRepository.findById(id);
    }

    public Pedidos updatePedido(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    public void deletePedido(Long id) {
        pedidosRepository.deleteById(id);
    }

    // --- Métodos Personalizados ---

    public List<Pedidos> getPedidosByClienteId(Long clienteId) {
        return pedidosRepository.findByClientesIdCliente(clienteId);
    }

    public List<Pedidos> getPedidosByFechaVentaBetween(LocalDate fechaInicio, LocalDate fechaFin) {
        return pedidosRepository.findByFechaVentaBetween(fechaInicio, fechaFin);
    }

    public List<Pedidos> getPedidosByMaxMontoTotalVenta() {
        return pedidosRepository.findByMaxMontoTotalVenta();
    }

    public Double getAverageMontoTotalVentaByCliente(Long clienteId) {
        return pedidosRepository.findAverageMontoTotalVentaByCliente(clienteId);
    }
}