package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Entrenador {

    private int id;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private List<TipoPokemon> tiposPreferidos;
    private List<Pokemon> equipoPokemon = new ArrayList<>();

    public Entrenador(int id, String nombre, String apellidos, LocalDate fechaNacimiento, List<TipoPokemon> tiposPreferidos, List<Pokemon> equipoPokemon) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.tiposPreferidos = tiposPreferidos;
        this.equipoPokemon = equipoPokemon;
    }

    public Entrenador() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<TipoPokemon> getTiposPreferidos() {
        return tiposPreferidos;
    }

    public void setTiposPreferidos(List<TipoPokemon> tiposPreferidos) {
        this.tiposPreferidos = tiposPreferidos;
    }

    public List<Pokemon> getEquipoPokemon() {
        return equipoPokemon;
    }

    public void setEquipoPokemon(List<Pokemon> equipoPokemon) {
        this.equipoPokemon = equipoPokemon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrenador that = (Entrenador) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(tiposPreferidos, that.tiposPreferidos) && Objects.equals(equipoPokemon, that.equipoPokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, fechaNacimiento, tiposPreferidos, equipoPokemon);
    }


    @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", tiposPreferidos=" + tiposPreferidos +
                ", equipoPokemon=" + equipoPokemon +
                '}';
    }
}
