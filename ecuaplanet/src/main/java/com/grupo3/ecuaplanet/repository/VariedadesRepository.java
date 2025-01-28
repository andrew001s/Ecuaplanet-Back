package com.grupo3.ecuaplanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo3.ecuaplanet.model.Variedades;

@Repository
public interface VariedadesRepository extends JpaRepository<Variedades, Integer> {


}
