import modelos.*;
import org.junit.Before;
import org.junit.Test;
import utilidades.UtilidadesCombate;
import utilidades.UtilidadesFichero;
import utilidades.UtilidadesPokemon;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class pruebaMetodos {

    List<Pokemon> pokemons = new ArrayList<>();
    List<Entrenador> entrenadores = new ArrayList<>();
    List<Movimiento> movimientos = new ArrayList<>();


    @Before
    public void inicializadoDeDatos() throws Exception {

        //----------------------- POKEMON -------------------------------------
        Pokemon p1 = new Pokemon(1, 2,"Treecko", 5,
                new ArrayList<>(List.of(TipoPokemon.PLANTA)),null,
         null, new ArrayList<>());
        Pokemon p2 = new Pokemon(2, 2,"Grovyle", 16,
                new ArrayList<>(List.of(TipoPokemon.PLANTA)),null,
                null, new ArrayList<>());
        Pokemon p3 = new Pokemon(3, 2,"Sceptile", 32,
                new ArrayList<>(List.of(TipoPokemon.PLANTA)),null,
                null, new ArrayList<>());
        Pokemon p4 = new Pokemon(7, 2,"Mudkid", 5,
                new ArrayList<>(List.of(TipoPokemon.AGUA)),null,
                null, new ArrayList<>());
        Pokemon p5 = new Pokemon(8, 2,"Marshtomp", 16,
                new ArrayList<>(List.of(TipoPokemon.AGUA)),null,
                null, new ArrayList<>());
        Pokemon p6 = new Pokemon(9, 2,"Swampert", 32,
                new ArrayList<>(List.of(TipoPokemon.AGUA, TipoPokemon.TIERRA)),null,
                null, new ArrayList<>());
        Pokemon p7 = new Pokemon(4, 2,"Torchic", 5,
                new ArrayList<>(List.of(TipoPokemon.FUEGO)),null,
                null, new ArrayList<>());
        Pokemon p8 = new Pokemon(15, 2,"Capturne", 20,
                new ArrayList<>(List.of(TipoPokemon.PLANTA, TipoPokemon.SINIESTRO)),null,
                null, new ArrayList<>());




        //---------------------- JUGADORES -----------------------------------------
        Entrenador e1 = new Entrenador(1,"Ash", "Kepchut", LocalDate.now()
                ,new ArrayList<>(List.of(TipoPokemon.ELECTRICO, TipoPokemon.PLANTA)) , new ArrayList<>());
        Entrenador e2 = new Entrenador(1,"Misty", "", LocalDate.now()
                ,new ArrayList<>(List.of(TipoPokemon.AGUA)) , new ArrayList<>());
        Entrenador e3 = new Entrenador(1,"Polo", "", LocalDate.now()
                ,new ArrayList<>(List.of(TipoPokemon.FUEGO,TipoPokemon.AGUA)) , new ArrayList<>());

        //---------------------- MOVIMIENTO -----------------------------------------
        Movimiento m1 = new Movimiento(1,"Lanzallamas", TipoPokemon.FUEGO, TipoAtaque.ESPECIAL, 80 );
        Movimiento m2 = new Movimiento(1,"Bola Sombra", TipoPokemon.FANTASMA, TipoAtaque.ESPECIAL, 90 );
        Movimiento m3 = new Movimiento(1,"Pistola Agua", TipoPokemon.AGUA, TipoAtaque.ESPECIAL, 40 );
        Movimiento m4 = new Movimiento(1,"Terremoto", TipoPokemon.TIERRA, TipoAtaque.ESPECIAL, 100 );





        LineaEvolutiva l1 = new LineaEvolutiva(p4,5,1);
        LineaEvolutiva l2 = new LineaEvolutiva(p5,16,2);
        LineaEvolutiva l3 = new LineaEvolutiva(p6,32,3);

        List<LineaEvolutiva> lineaEvolutivasMudkid = new ArrayList<>();
        lineaEvolutivasMudkid.add(l1);
        lineaEvolutivasMudkid.add(l2);
        lineaEvolutivasMudkid.add(l3);
        p4.setLineaEvolutiva(lineaEvolutivasMudkid);

        entrenadores.addAll(List.of(e1,e2,e3));
        pokemons.addAll(List.of(p1,p2,p3,p4,p5,p6,p7,p8));
        movimientos.addAll(List.of(m1,m2,m3,m4));







    }




    //---------------------------------------------- TEST UTILIDADESPOKEMON -----------------------------------------------------//

    @Test
    public void testObtenerPokemonConTipos() {
        List<TipoPokemon> tipos = new ArrayList<>(List.of(TipoPokemon.PLANTA,TipoPokemon.TIERRA));
        List<Pokemon> esperados = UtilidadesPokemon.obtenerPokemonConTipos(pokemons,tipos);
        Integer tamanyoListaEsperado = 5;
        Integer tamanyoListaObtenido = esperados.size();
        assertEquals(tamanyoListaEsperado,tamanyoListaObtenido);
    }

    @Test
    public void testObtenerPokemonPurosPorTipo() {

        Map<TipoPokemon, List<Pokemon>> purosObtenidos  =  UtilidadesPokemon.obtenerPokemonPurosPorTipo(pokemons);

        Set<TipoPokemon> clavesEsperadas = new HashSet<>(Set.of(TipoPokemon.PLANTA,TipoPokemon.AGUA,TipoPokemon.FUEGO));
        Set<TipoPokemon> clavesObtenidas = purosObtenidos.keySet();

        List<Pokemon> valuesEsperados = new ArrayList<>(List.of(pokemons.get(0),pokemons.get(1),
                pokemons.get(2),pokemons.get(3),pokemons.get(4),pokemons.get(6)));
        valuesEsperados.sort(Comparator.comparing(Pokemon::getNumPokedex));
        List<Pokemon> valoresObtenidos = new ArrayList<>();
        purosObtenidos.values().forEach(valoresObtenidos::addAll);
        valoresObtenidos.sort(Comparator.comparing(Pokemon::getNumPokedex));

        assertEquals(clavesEsperadas, clavesObtenidas);
        assertEquals(valuesEsperados,valoresObtenidos);
    }


    //---------------------------------------------- TEST UTILIDADESFICHERO -----------------------------------------------------//

//    @Test
//    public void testLeerPersonajesFicheroConHabilidad() {
//
//        List<Pokemon> pokemonLeidos = UtilidadesFichero.leerPokemonConAtaques();
//        Integer tamanyoLista = pokemonLeidos.size();
//        Integer tamanyoListaEsperado = 6;
//        List<Movimiento> movimientos = new ArrayList<>();
//        pokemonLeidos.stream().filter(p->p.getMovimientos()!= null).forEach(p->movimientos.addAll(p.getMovimientos()));
//        Integer tamanyoListaMovimientos = movimientos.size();
//        Integer tamanyoListaEsperadomovimientos = 4;
//
//        //Comprobacion de pokemons
//        assertEquals(tamanyoLista, tamanyoListaEsperado);
//        pokemonLeidos.forEach(p->{
//            assertNotNull(p.getNombre());
//            assertNotNull(p.getNumPokedex());
//            assertNotNull(p.getGeneracion());
//            assertNotNull(p.getNivel());
//
//        });
//
//        //Comprobacion de habilidades
//        assertEquals(tamanyoListaEsperadomovimientos,tamanyoListaMovimientos);
//        List <Integer> numPokedexsConHabilidades = new ArrayList<>(Arrays.asList(1,4));
//        Integer tamanyoListamovimientosPokemon = 2;
//        List<Pokemon> pokemonConMovimientos = pokemonLeidos.stream().filter(p-> numPokedexsConHabilidades.contains(p.getNumPokedex()))
//                .collect(Collectors.toList());
//        pokemonConMovimientos.stream().map(Pokemon::getMovimientos).forEach(h->{
//            Integer tamanyohabilidades = h.size();
//            assertEquals(tamanyohabilidades,tamanyoListamovimientosPokemon);
//        });
//
//    }


    //---------------------------------------------- TEST UTILIDADESCOMBATE -----------------------------------------------------//


    @Test
    public void testrepartirPokemon() {
        List<Entrenador> entrenadors = entrenadores.subList(0,2);
        Map<Entrenador,Integer> puntuacion = UtilidadesCombate.repartirPokemon(entrenadors, pokemons);
        Integer puntuacionEsperadaEntrenador1 = 3;
        Integer puntuacionObtenidaEntrenador1 = puntuacion.get(entrenadors.stream().filter(e-> e.getNombre().equals("Ash")).findFirst().get());
        Integer puntuacionEsperadaEntrenador2 = 2;
        Integer puntuacionObtenidaEntrenador2 = puntuacion.get(entrenadors.stream().filter(e-> e.getNombre().equals("Misty")).findFirst().get());
        assertEquals(puntuacionEsperadaEntrenador1,puntuacionObtenidaEntrenador1);
        assertEquals(puntuacionEsperadaEntrenador2,puntuacionObtenidaEntrenador2);
    }


    @Test
    public void testsubirAlNivel() {
        Pokemon pokemon = pokemons.get(0);
        Integer nivelDeseado = 10;
        Stats s = new Stats(1,10,10,10,10,10,10);
        Integer sumStatsEsperada = 180;
        pokemon.setStats(s);

        UtilidadesCombate.subirAlNivel(pokemon,nivelDeseado);

        Integer nivelObtenido = pokemon.getNivel();
        Integer sumStatsObtenida = pokemon.getStats().getAt() + pokemon.getStats().getDf() +
                pokemon.getStats().getSpa() + pokemon.getStats().getSpd() + pokemon.getStats().getSpdf() +
                pokemon.getStats().getPs();

        assertEquals(nivelDeseado,nivelObtenido);
        assertEquals(sumStatsEsperada,sumStatsObtenida);
    }


    @Test
    public void testPuedeEvolucionar() {
        Pokemon pokemon = pokemons.get(3);//Mudkid1
        pokemon.setNivel(5);
        assertFalse(UtilidadesCombate.puedeEvolucionar(pokemon));
        Pokemon pokemon2 = pokemons.get(3); //Mudkid2
        pokemon2.setNivel(16);
        assertTrue(UtilidadesCombate.puedeEvolucionar(pokemon2));
        Pokemon pokemon3 = pokemons.get(3); //Mudkid3
        pokemon3.setNivel(38);
        assertTrue(UtilidadesCombate.puedeEvolucionar(pokemon3));
    }

//    @Test
//    public void testMovimientosQuePuedeAprender(){
//        Pokemon pokemon = pokemons.get(5);
//        List<Movimiento> movimientosAprender = UtilidadesPokemon.movimientosQuePuedeAprender(pokemon, movimientos);
//        Integer cantidadEsperada = 2;
//        Integer cantidadObtenida = movimientosAprender.size();
//        assertEquals(cantidadEsperada,cantidadObtenida);
//    }
//
    @Test
    public void testEvolucionPosible() {
        Pokemon pokemon = pokemons.get(3);//Mudkid1
        pokemon.setNivel(5);
        Pokemon pokemonEsperado1 = null;
        Pokemon pokemonObtenido1 = UtilidadesCombate.obtenerEvolucionPosible(pokemon);
        assertEquals(pokemonEsperado1,pokemonObtenido1);
        pokemon.setNivel(16);
        Pokemon pokemonObtenido2 = UtilidadesCombate.obtenerEvolucionPosible(pokemon);
        Pokemon pokemonEsperado2 = pokemons.get(4);//Marshtomp
        assertEquals(pokemonEsperado2,pokemonObtenido2);
    }


    @Test
    public void testAsignarEquipoPorTipos(){
        List<Entrenador> entrenadors = entrenadores;
        Map<Entrenador,Integer> tamanyos = UtilidadesCombate.asignarEquipoPorTipos(pokemons, entrenadors);
        Integer puntuacionEsperadaEntrenador1 = 4;
        Integer puntuacionObtenidaEntrenador1 = tamanyos.get(entrenadors.stream().filter(e-> e.getNombre().equals("Ash")).findFirst().get());
        Integer puntuacionEsperadaEntrenador2 = 2;
        Integer puntuacionObtenidaEntrenador2 = tamanyos.get(entrenadors.stream().filter(e-> e.getNombre().equals("Misty")).findFirst().get());
        Integer puntuacionEsperadaEntrenador3 = 2;
        Integer puntuacionObtenidaEntrenador3 = tamanyos.get(entrenadors.stream().filter(e-> e.getNombre().equals("Polo")).findFirst().get());
        assertEquals(puntuacionEsperadaEntrenador1,puntuacionObtenidaEntrenador1);
        assertEquals(puntuacionEsperadaEntrenador2,puntuacionObtenidaEntrenador2);
        assertEquals(puntuacionEsperadaEntrenador3,puntuacionObtenidaEntrenador3);
    }

    @Test
    public void testCoincidencias(){
        Map<Entrenador, Integer> mapa = UtilidadesCombate.coincidencias(entrenadores, List.of(TipoPokemon.PLANTA, TipoPokemon.ELECTRICO, TipoPokemon.AGUA));

        //Probar que en el mapa hay tres entrenadores
        assertEquals(3, mapa.size());

        assertTrue(mapa.containsValue(2));

        List<Integer> auxiliar = new ArrayList<>(mapa.values());
        auxiliar.retainAll(List.of(1));

        assertEquals(2, auxiliar.size());

        assertEquals(2, (int) mapa.get(entrenadores.get(0)));

    }





}
