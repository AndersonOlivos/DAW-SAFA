package Utilidades;
import Modelos.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilidadesPokemon {
    public List<Pokemon> obtenerPokemonConTipos(List<Pokemon> pokemons, List<TipoPokemon> tipos){

        return pokemons
                .stream()
                .filter(pokemon -> pokemon.getTipos().retainAll(tipos))
                .collect(Collectors.toList());
    }

    public Map<TipoPokemon, List<Pokemon>> obtenerPokemonPurosPorTipo(List<Pokemon> pokemons){

        return pokemons.stream()
                .filter(p -> p.getTipos().size() == 1)
                .collect(Collectors.groupingBy(p -> p.getTipos().getFirst()));
    }

}