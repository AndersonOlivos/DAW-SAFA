package Practica5;

import java.util.Objects;

public class AtaqueImpl implements Ataque {

    private String nombre;
    private Integer dano;

    public AtaqueImpl() {
    }

    public AtaqueImpl(String nombre, Integer dano) {
        this.nombre = nombre;
        this.dano = dano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDano() {
        return dano;
    }

    public void setDano(Integer dano) {
        this.dano = dano;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AtaqueImpl ataque = (AtaqueImpl) o;
        return Objects.equals(nombre, ataque.nombre) && Objects.equals(dano, ataque.dano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dano);
    }

    @Override
    public String toString() {
        return nombre + ", " + dano;
    }
}
