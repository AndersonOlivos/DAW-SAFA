package Modelos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Entrenador {
    private int id;
    private String nombre;
    private String apellidos;
    private LocalDate nacimiento;
    private List<TipoPokemon> tiposPreferidos;
    private List<Pokemon> equipoPokemon;

    public Entrenador() {
    }

    public Entrenador(int id, String nombre, String apellidos, LocalDate nacimiento, List<TipoPokemon> tiposPreferidos, List<Pokemon> equipoPokemon) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.tiposPreferidos = tiposPreferidos;
        this.equipoPokemon = equipoPokemon;
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

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
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
        if (o == null || getClass() != o.getClass()) return false;
        Entrenador that = (Entrenador) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(nacimiento, that.nacimiento) && Objects.equals(tiposPreferidos, that.tiposPreferidos) && Objects.equals(equipoPokemon, that.equipoPokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, nacimiento, tiposPreferidos, equipoPokemon);
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
