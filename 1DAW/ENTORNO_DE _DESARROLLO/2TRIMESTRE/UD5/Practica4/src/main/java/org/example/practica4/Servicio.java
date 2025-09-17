package org.example.practica4;

import java.time.LocalDate;
import java.util.Objects;

public class Servicio {
    private String matricula_vehiculo;
    private String marca_vehiculo;
    private Integer precio_vehiculo;
    private Integer total_servicios;
    private LocalDate fecha_alquiler;
    private LocalDate fecha_entrega;

    public Servicio(String matricula_vehiculo, String marca_vehiculo, Integer precio_vehiculo, Integer total_servicios, LocalDate fecha_alquiler, LocalDate fecha_entrega) {
        this.matricula_vehiculo = matricula_vehiculo;
        this.marca_vehiculo = marca_vehiculo;
        this.precio_vehiculo = precio_vehiculo;
        this.total_servicios = total_servicios;
        this.fecha_alquiler = fecha_alquiler;
        this.fecha_entrega = fecha_entrega;
    }

    public String getMatricula_vehiculo() {
        return matricula_vehiculo;
    }

    public void setMatricula_vehiculo(String matricula_vehiculo) {
        this.matricula_vehiculo = matricula_vehiculo;
    }

    public String getMarca_vehiculo() {
        return marca_vehiculo;
    }

    public void setMarca_vehiculo(String marca_vehiculo) {
        this.marca_vehiculo = marca_vehiculo;
    }

    public Integer getPrecio_vehiculo() {
        return precio_vehiculo;
    }

    public void setPrecio_vehiculo(Integer precio_vehiculo) {
        this.precio_vehiculo = precio_vehiculo;
    }

    public Integer getTotal_servicios() {
        return total_servicios;
    }

    public void setTotal_servicios(Integer total_servicios) {
        this.total_servicios = total_servicios;
    }

    public LocalDate getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(LocalDate fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    public LocalDate getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(LocalDate fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "matricula_vehiculo='" + matricula_vehiculo + '\'' +
                ", marca_vehiculo='" + marca_vehiculo + '\'' +
                ", precio_vehiculo=" + precio_vehiculo +
                ", total_servicios=" + total_servicios +
                ", fecha_alquiler=" + fecha_alquiler +
                ", fecha_entrega=" + fecha_entrega +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Servicio servicio = (Servicio) o;
        return Objects.equals(matricula_vehiculo, servicio.matricula_vehiculo) && Objects.equals(marca_vehiculo, servicio.marca_vehiculo) && Objects.equals(precio_vehiculo, servicio.precio_vehiculo) && Objects.equals(total_servicios, servicio.total_servicios) && Objects.equals(fecha_alquiler, servicio.fecha_alquiler) && Objects.equals(fecha_entrega, servicio.fecha_entrega);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula_vehiculo, marca_vehiculo, precio_vehiculo, total_servicios, fecha_alquiler, fecha_entrega);
    }
}
