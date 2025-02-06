package com.bancolombia.aplicacionbancaria.prestamo;

import java.math.BigDecimal;

public class PrestamoDTO {

    private Long id;
    private BigDecimal monto;
    private BigDecimal interes;
    private Integer duracionMeses;
    private String estado;

    public PrestamoDTO(Long id, BigDecimal monto, BigDecimal interes, Integer duracionMeses, String estado) {
        this.id = id;
        this.monto = monto;
        this.interes = interes;
        this.duracionMeses = duracionMeses;
        this.estado = estado;
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

    public Integer getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(Integer duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
