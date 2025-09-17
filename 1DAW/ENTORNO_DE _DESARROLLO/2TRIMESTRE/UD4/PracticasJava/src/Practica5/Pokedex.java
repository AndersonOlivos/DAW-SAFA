package Practica5;

import java.util.Map;

public interface Pokedex {
    public Pokemon getPokemon();
    public Map<String, String> getDebilidad();
    public Ataque getAtaque();
    public Pokemon getComparador();
}
