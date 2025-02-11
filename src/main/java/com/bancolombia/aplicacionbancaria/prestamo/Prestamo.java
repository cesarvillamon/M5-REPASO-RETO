package com.bancolombia.aplicacionbancaria.prestamo;

import com.bancolombia.aplicacionbancaria.cliente.Cliente;
import com.bancolombia.aplicacionbancaria.historialPrestamo.HistorialPrestamo;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
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

    @OneToMany(mappedBy = "prestamo", cascade = CascadeType.ALL)
    private List<HistorialPrestamo> historial;

    public Prestamo(Long id, BigDecimal monto, BigDecimal interes, int duracionMeses, String estado) {
        this.id = id;
        this.monto = monto;
        this.interes = interes;
        this.duracionMeses = duracionMeses;
        this.estado = estado;
    }

    public Prestamo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<HistorialPrestamo> getHistorial() {
        return historial;
    }

    public void setHistorial(List<HistorialPrestamo> historial) {
        this.historial = historial;
    }
}

