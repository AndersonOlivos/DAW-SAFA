package Practica5;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Ataque ataque = new AtaqueImpl("Latigo Cepa",10);

        Pokemon pokemon = new PokemonImpl(1, "Bulbasaur", "Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo.", 0.7, 6.9, Genero.MASCULINO, "Planta");

        Map<String, String> debilidad = new HashMap();
        debilidad.put("FUEGO", "ASCUAS");

        Pokedex pokedex = new PokedexImpl(pokemon, debilidad, ataque);
        System.out.println(pokedex);


    }
}
