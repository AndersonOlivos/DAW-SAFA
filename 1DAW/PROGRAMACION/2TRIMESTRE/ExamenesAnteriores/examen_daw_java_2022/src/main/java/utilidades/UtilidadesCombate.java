package utilidades;

import modelos.*;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesCombate {

private  static  Integer getPuntosEntrenador(Entrenador e){

        int puntos = 0;
        return puntos;
    }

    public static Map<Entrenador, Integer>   repartirPokemon(List<Entrenador> entrenadores, List<Pokemon> pokemon){


        Map<Entrenador, Integer>  puntosEntrenadores = new HashMap<>();
        return puntosEntrenadores;
    }






    public static void subirAlNivel(Pokemon pokemon , Integer nivel){
    }


    /**
     *
     * 1- Que en su linea evolutiva haya un pokemon con un orden superior
     * 2- Que alguno de esos tenga el nivel menor o igual al nivel de mi pokemon
     *
     * @param pokemon
     * @return
     */
    public static boolean puedeEvolucionar1(Pokemon pokemon){

  
        boolean puedeEvolucionar = false;

        return puedeEvolucionar;

    }


    /**
     *
     * 1- Que en su linea evolutiva haya un pokemon con un orden superior
     * 2- Que alguno de esos tenga el nivel menor o igual al nivel de mi pokemon
     *
     * @param pokemon
     * @return
     */
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


    /**
     *
     * @param pokemons
     * @param entrenadores
     * @return
     */
    public static Map<Entrenador, Integer> asignarEquipoPorTipos(List<Pokemon> pokemons, List<Entrenador> entrenadores) {
     
        Map<Entrenador, Integer> mapa = new HashMap<>();

        return mapa;



    }


    private  static  Integer getPuntosEntrenador(Entrenador e, Pokemon pokemon){
      
 
        return 0;
    }



    private  static  Entrenador dameElQueMenosTenga(List<Entrenador> entrenadors){
        return null;
    }


    public List<Movimiento> movimientosQuePuedeAprender1(Pokemon pokemon, List<Movimiento> movimientos){
            return new ArrayList<>();
    }

    public List<Movimiento> movimientosQuePuedeAprender(Pokemon pokemon, List<Movimiento> movimientos){

        List<Movimiento> movimientosFinales = new ArrayList<>();

        return movimientosFinales;

    }

    public static Pokemon obtenerEvolucionPosible(Pokemon pokemon){

            return  null;

    }




    public  static Map<Entrenador, Integer> coincidencias(List<Entrenador> entrenadors, List<TipoPokemon> tipos){

        Map<Entrenador, Integer > mapa = new HashMap<>();
      

        return mapa;

    }




}
