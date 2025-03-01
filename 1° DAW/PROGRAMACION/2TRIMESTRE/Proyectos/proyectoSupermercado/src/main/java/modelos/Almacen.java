package modelos;

import java.util.Objects;

public class Almacen {

    private Integer id;
    private String nombre;
    private Integer capacidad;

    public Almacen() {
    }

    public Almacen(Integer id, String nombre, Integer capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }

    //El 'equals' sirve para comparar 2 objetos y saber si son el mismo

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Almacen almacen = (Almacen) o;
        return Objects.equals(id, almacen.id) && Objects.equals(nombre, almacen.nombre) && Objects.equals(capacidad, almacen.capacidad);
    }

    //El hashCode sirve para saber la posición en ram

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, capacidad);
    }
}
