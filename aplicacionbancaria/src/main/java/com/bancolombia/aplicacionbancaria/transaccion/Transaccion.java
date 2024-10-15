package com.bancolombia.aplicacionbancaria.transaccion;

import com.bancolombia.aplicacionbancaria.cuenta.Cuenta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private double monto;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

    public Transaccion() {}

    public Transaccion(String tipo, double monto, LocalDateTime fecha, Cuenta cuenta) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.cuenta = cuenta;
    }

    public void setCuenta(Cuenta cuenta){
        this.cuenta=cuenta;
    }
}
