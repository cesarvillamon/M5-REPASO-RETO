package com.bancolombia.aplicacionbancaria.prestamo;

import com.bancolombia.aplicacionbancaria.cliente.Cliente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal monto;
    private BigDecimal interes;
    private int duracionMeses;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}

