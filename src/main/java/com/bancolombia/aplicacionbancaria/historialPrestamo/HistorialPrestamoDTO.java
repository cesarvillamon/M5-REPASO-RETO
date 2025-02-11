package com.bancolombia.aplicacionbancaria.historialPrestamo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HistorialPrestamoDTO {

    private Long id;
    private BigDecimal monto;
    private String estado;
    private LocalDateTime fecha_creacion;
    private LocalDateTime fecha_actualizacion;

    public HistorialPrestamoDTO() {
    }

    public HistorialPrestamoDTO(Long id, BigDecimal monto, String estado, LocalDateTime fecha_creacion, LocalDateTime fecha_actualizacion) {
        this.id = id;
        this.monto = monto;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
        this.fecha_actualizacion = fecha_actualizacion;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDateTime getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(LocalDateTime fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }
}
