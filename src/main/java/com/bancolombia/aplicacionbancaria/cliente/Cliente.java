package com.bancolombia.aplicacionbancaria.cliente;

import com.bancolombia.aplicacionbancaria.prestamo.Prestamo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<Prestamo> prestamos;

}

