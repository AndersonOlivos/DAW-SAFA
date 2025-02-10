package Practica5;

import java.util.Map;
import java.util.Objects;

public class PokedexImpl implements Pokedex {

    private Pokemon pokemon;
    private Map<String,String> debilidad;
    private Ataque ataque;
    private Pokemon comparador;

    public PokedexImpl() {
    }

    public PokedexImpl(Pokemon pokemon, Map<String, String> debilidad, Ataque ataque) {
        this.pokemon = pokemon;
        this.debilidad = debilidad;
        this.ataque = ataque;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public Map<String, String> getDebilidad() {
        return debilidad;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public Pokemon getComparador() {
        return comparador;
    }

    public void setComparador(Pokemon pokemon1, Pokemon pokemon2) {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PokedexImpl pokedex = (PokedexImpl) o;
        return Objects.equals(pokemon, pokedex.pokemon) && Objects.equals(debilidad, pokedex.debilidad) && Objects.equals(ataque, pokedex.ataque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemon, debilidad, ataque);
    }

    @Override
    public String toString() {
        return pokemon + "\nAtaque: " + ataque;
    }
}
