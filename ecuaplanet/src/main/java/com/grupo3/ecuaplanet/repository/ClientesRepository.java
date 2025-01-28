package com.grupo3.ecuaplanet.repository;

import com.grupo3.ecuaplanet.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

    // 1. Buscar clientes por nombre
    Optional<Clientes> findByNombreCliente(String nombreCliente);

    // 2. Buscar clientes por país
    List<Clientes> findByPaisCliente(String paisCliente);

    // 3. Buscar clientes por tipo
    List<Clientes> findByTipoCliente(String tipoCliente);

    // 4. Ejemplo: Encontrar el cliente con el nombre más largo
    @Query("SELECT c FROM Clientes c WHERE LENGTH(c.nombreCliente) = (SELECT MAX(LENGTH(c2.nombreCliente)) FROM Clientes c2)")
    List<Clientes> findByLongestNombreCliente();

    // 5. Ejemplo: Contar cuántos clientes son de un determinado tipo
    @Query("SELECT COUNT(c) FROM Clientes c WHERE c.tipoCliente = :tipo")
    Long countByTipoCliente(@Param("tipo") String tipo);
}