package Utilidades;

import static Utilidades.UtilidadesCombate.*;

import Modelos.Entrenador;
import Modelos.LineaEvolutiva;
import Modelos.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        Pokemon pokemon1 = new Pokemon();
        pokemon1.setNombre("Pokemon 1");
        pokemon1.setNivel(8);
        Pokemon pokemon2 = new Pokemon();
        pokemon2.setNombre("Pokemon 2");
        pokemon2.setNivel(12);
        Pokemon pokemon3 = new Pokemon();
        pokemon3.setNombre("Pokemon 3");
        pokemon3.setNivel(22);
        Pokemon pokemon4 = new Pokemon();
        pokemon4.setNombre("Pokemon 4");
        pokemon4.setNivel(20);
        Pokemon pokemon5 = new Pokemon();
        pokemon5.setNombre("Pokemon 5");
        pokemon5.setNivel(10);
        Pokemon pokemon6 = new Pokemon();
        pokemon6.setNombre("Pokemon 6");
        pokemon6.setNivel(12);
        Pokemon pokemon7 = new Pokemon();
        pokemon7.setNombre("Pokemon 7");
        pokemon7.setNivel(20);
        Pokemon pokemon8 = new Pokemon();
        pokemon8.setNombre("Pokemon 8");
        pokemon8.setNivel(20);

        List<Pokemon> listaPokemon1 = new ArrayList<>();
        listaPokemon1.add(pokemon1);
        listaPokemon1.add(pokemon2);

        List<Pokemon> listaPokemon2 = new ArrayList<>();
        listaPokemon2.add(pokemon3);

        List<Pokemon> listaPokemon3 = new ArrayList<>();
        listaPokemon3.add(pokemon4);
        listaPokemon3.add(pokemon5);
        listaPokemon3.add(pokemon6);
        listaPokemon3.add(pokemon7);


        Entrenador entrenador1 = new Entrenador();
        entrenador1.setNombre("Entrenador 1");
        entrenador1.setEquipoPokemon(listaPokemon1);
        Entrenador entrenador2 = new Entrenador();
        entrenador2.setNombre("Entrenador 2");
        entrenador2.setEquipoPokemon(listaPokemon2);

        List<Entrenador> listaEntrenador = new ArrayList<>();
        listaEntrenador.add(entrenador1);
        listaEntrenador.add(entrenador2);

        //System.out.println(repartirPokemon(listaEntrenador, listaPokemon3));



        LineaEvolutiva linea1= new LineaEvolutiva(pokemon1, 0, 1);
        LineaEvolutiva linea2= new LineaEvolutiva(pokemon2, 10, 2);
        LineaEvolutiva linea3= new LineaEvolutiva(pokemon3, 20, 3);

        List<LineaEvolutiva> listaLineaEvolutiva = new ArrayList<>();
        listaLineaEvolutiva.add(linea1);
        listaLineaEvolutiva.add(linea2);
        listaLineaEvolutiva.add(linea3);

        pokemon1.setLineaEvolutiva(listaLineaEvolutiva);
        pokemon2.setLineaEvolutiva(listaLineaEvolutiva);
        pokemon3.setLineaEvolutiva(listaLineaEvolutiva);



        System.out.println(puedeEvolucionar(pokemon1));

    }
}
