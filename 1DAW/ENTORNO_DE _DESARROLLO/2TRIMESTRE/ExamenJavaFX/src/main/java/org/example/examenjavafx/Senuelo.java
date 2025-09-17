package org.example.examenjavafx;

import java.time.LocalDate;
import java.util.Objects;

public class Senuelo {
    private Integer id;
    private String modelo;
    private String color;
    private String ojos;
    private String referencia;
    private String tamano;
    private String navegabilidad;
    private Double peso;
    private Boolean disponibilidad;
    private Double pvp;
    private LocalDate fecha_recepcion;

    public Senuelo() {
    }

    public Senuelo(Integer id, String modelo, String color, String ojos, String referencia, String tamano, String navegabilidad, Double peso, Boolean disponibilidad, Double pvp, LocalDate fecha_recepcion) {
        this.id = id;
        this.modelo = modelo;
        this.color = color;
        this.ojos = ojos;
        this.referencia = referencia;
        this.tamano = tamano;
        this.navegabilidad = navegabilidad;
        this.peso = peso;
        this.disponibilidad = disponibilidad;
        this.pvp = pvp;
        this.fecha_recepcion = fecha_recepcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOjos() {
        return ojos;
    }

    public void setOjos(String ojos) {
        this.ojos = ojos;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getNavegabilidad() {
        return navegabilidad;
    }

    public void setNavegabilidad(String navegabilidad) {
        this.navegabilidad = navegabilidad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Double getPvp() {
        return pvp;
    }

    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    public LocalDate getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(LocalDate fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Senuelo senuelo = (Senuelo) o;
        return Objects.equals(id, senuelo.id) && Objects.equals(modelo, senuelo.modelo) && Objects.equals(color, senuelo.color) && Objects.equals(ojos, senuelo.ojos) && Objects.equals(referencia, senuelo.referencia) && tamano == senuelo.tamano && Objects.equals(navegabilidad, senuelo.navegabilidad) && Objects.equals(peso, senuelo.peso) && Objects.equals(disponibilidad, senuelo.disponibilidad) && Objects.equals(pvp, senuelo.pvp) && Objects.equals(fecha_recepcion, senuelo.fecha_recepcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo, color, ojos, referencia, tamano, navegabilidad, peso, disponibilidad, pvp, fecha_recepcion);
    }

    @Override
    public String toString() {
        return "Senuelo{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", ojos='" + ojos + '\'' +
                '}';
    }
}
