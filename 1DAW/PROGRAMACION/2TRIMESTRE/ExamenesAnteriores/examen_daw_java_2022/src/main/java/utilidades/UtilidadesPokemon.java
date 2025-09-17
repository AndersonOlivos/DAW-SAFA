package utilidades;

import modelos.Pokemon;
import modelos.TipoPokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilidadesPokemon {
 public UtilidadesPokemon() {
    }

    public static List<Pokemon> obtenerPokemonConTipos(List<Pokemon> pokemons, List<TipoPokemon> tipos){


        return pokemons
                .stream()
                .filter(pokemon -> pokemon.getTipos().retainAll(tipos))
                .collect(Collectors.toList());

    }

    public static List<Pokemon> obtenerPokemonConTipos1(List<Pokemon> pokemons, List<TipoPokemon> tipos){

        return new ArrayList<>();
    }



    public static Map<TipoPokemon, List<Pokemon>> obtenerPokemonPurosPorTipo(List<Pokemon> pokemons){

        return pokemons.stream()
                .filter(p -> p.getTipos().size() == 1)
                .collect(Collectors.groupingBy(p -> p.getTipos().get(0)));

    }

    public static Map<TipoPokemon, List<Pokemon>> obtenerPokemonPurosPorTipo1(List<Pokemon> pokemons){

        return new HashMap<>();

    }

}
