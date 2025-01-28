package com.grupo3.ecuaplanet.service;

import com.grupo3.ecuaplanet.model.Cajas;
import com.grupo3.ecuaplanet.repository.CajasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CajasService {

    @Autowired
    private CajasRepository cajasRepository;

    // --- Métodos CRUD ---

    // Crear (Create)
    public Cajas saveCaja(Cajas caja) {
        return cajasRepository.save(caja);
    }

    // Leer (Read)
    public List<Cajas> getAllCajas() {
        return cajasRepository.findAll();
    }

    public Optional<Cajas> getCajaById(Long id) {
        return cajasRepository.findById(id);
    }

    // Actualizar (Update)
    public Cajas updateCaja(Cajas caja) {
        return cajasRepository.save(caja);
    }

    // Eliminar (Delete)
    public void deleteCaja(Long id) {
        cajasRepository.deleteById(id);
    }

    // --- Métodos Personalizados ---

    public Optional<Cajas> getCajaByPedidoId(Long pedidoId) {
        return cajasRepository.findByPedidosIdPedido(pedidoId);
    }

    public Optional<Cajas> getCajaConMaxIdPedido() {
        return cajasRepository.findByMaxIdPedido();
    }
}