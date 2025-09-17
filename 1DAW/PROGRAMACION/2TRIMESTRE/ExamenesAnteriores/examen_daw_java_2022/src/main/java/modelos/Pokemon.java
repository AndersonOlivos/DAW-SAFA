package modelos;

import java.util.List;
import java.util.Objects;

public class Pokemon {

    private int numPokedex;
    private Integer generacion;
    private String nombre;
    private Integer nivel;
    private List<TipoPokemon> tipos;
    private Stats stats;
    private List<LineaEvolutiva> lineaEvolutiva;
    private List<Movimiento> movimientos;

    public Pokemon(int numPokedex, Integer generacion, String nombre, Integer nivel, List<TipoPokemon> tipos, Stats stats, List<LineaEvolutiva> lineaEvolutiva, List<Movimiento> movimientos) {
        this.numPokedex = numPokedex;
        this.generacion = generacion;
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipos = tipos;
        this.stats = stats;
        this.lineaEvolutiva = lineaEvolutiva;
        this.movimientos = movimientos;
    }

    public Pokemon() {
    }

    public int getNumPokedex() {
        return numPokedex;
    }

    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }

    public Integer getGeneracion() {
        return generacion;
    }

    public void setGeneracion(Integer generacion) {
        this.generacion = generacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public List<TipoPokemon> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoPokemon> tipos) {
        this.tipos = tipos;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<LineaEvolutiva> getLineaEvolutiva() {
        return lineaEvolutiva;
    }

    public void setLineaEvolutiva(List<LineaEvolutiva> lineaEvolutiva) {
        this.lineaEvolutiva = lineaEvolutiva;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return numPokedex == pokemon.numPokedex && Objects.equals(generacion, pokemon.generacion) && Objects.equals(nombre, pokemon.nombre) && Objects.equals(nivel, pokemon.nivel) && Objects.equals(tipos, pokemon.tipos) && Objects.equals(stats, pokemon.stats) && Objects.equals(lineaEvolutiva, pokemon.lineaEvolutiva) && Objects.equals(movimientos, pokemon.movimientos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numPokedex, generacion, nombre, nivel, tipos, stats, movimientos);
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "numPokedex=" + numPokedex +
                ", generacion=" + generacion +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", tipos=" + tipos +
                ", stats=" + stats +
                ", movimientos=" + movimientos +
                '}';
    }



}
