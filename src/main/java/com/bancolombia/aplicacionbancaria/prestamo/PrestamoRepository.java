package com.bancolombia.aplicacionbancaria.prestamo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByClienteId(Long clienteId);

    List<Prestamo> findTop3ByClienteIdOrderByIdDesc(Long clienteId);
}

