package Utilidades;

import Modelos.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesCombate {

    public static Map<Entrenador, Integer> repartirPokemon(List<Entrenador> entrenadores, List<Pokemon> pokemon){

        if(entrenadores.size() % 2 == 0 && pokemon.size() % 2 == 0 && pokemon.size() % entrenadores.size() == 0){
            Map<Entrenador, Integer> entrenadoresPokemon = new HashMap<>();
            Integer numPokemonsPorEntrenador = pokemon.size() / entrenadores.size();

            for (Entrenador entrenador : entrenadores) {
                entrenador.getEquipoPokemon().addAll(pokemon.subList(0, numPokemonsPorEntrenador));
                pokemon.removeAll(pokemon.subList(0, numPokemonsPorEntrenador));
            }



        return entrenadoresPokemon;
        } else return null;
    }

    public static void subirAlNivel(Pokemon pokemon, Integer nivel){
        pokemon.setNivel(nivel);
        pokemon.getStats().setPs(pokemon.getStats().getPs() + (2 * nivel));
        pokemon.getStats().setAt(pokemon.getStats().getAt() + (2 * nivel));
        pokemon.getStats().setDf(pokemon.getStats().getDf() + (2 * nivel));
        pokemon.getStats().setSpa(pokemon.getStats().getSpa() + (2 * nivel));
        pokemon.getStats().setSpdf(pokemon.getStats().getSpdf() + (2 * nivel));
        pokemon.getStats().setSpd(pokemon.getStats().getSpd() + (2 * nivel));
    }

    public static boolean puedeEvolucionar(Pokemon pokemon){

        boolean porEncima = false;
        boolean porNivel = false;

        Integer numeroEvoluciones = pokemon.getLineaEvolutiva().size();
        Integer posicionLineaEvolutiva = 0;

        //Comprobar si hay una evolución superior

        for(int i=0; i<numeroEvoluciones; i++){
            if(pokemon.getLineaEvolutiva().get(i).getPokemon().equals(pokemon)){
                posicionLineaEvolutiva = i+1;
            }
        }

        if(posicionLineaEvolutiva<numeroEvoluciones) porEncima = true;

        //Comprobar que tiene el nivel para evolucionar

        if(porEncima){
            if(pokemon.getNivel()>=pokemon.getLineaEvolutiva().get(posicionLineaEvolutiva).getNivelParaEvolucionar()) porNivel = true;
        }

        return porEncima && porNivel;

    }

}
