import modelos.Jugador;
import modelos.Partida;
import modelos.Personaje;

import java.util.*;

import static utilidades.UtilidadesPartida.*;

public class TestV7 {
    public static void main(String[] args) {

        Jugador j1 = new Jugador();
        j1.setId(1);
        j1.setPartidasGanadas(new HashMap<>());
        Jugador j2 = new Jugador();
        j2.setId(2);
        j2.setPartidasGanadas(new HashMap<>());

        Personaje p1 = new Personaje();
        p1.setNombre("Tristana");
        Personaje p2 = new Personaje();
        p2.setNombre("Garen");
        Personaje p3 = new Personaje();
        p3.setNombre("Zed");
        Personaje p4 = new Personaje();
        p4.setNombre("Urgot");

        Personaje p5 = new Personaje();
        p5.setNombre("Ashe");
        Personaje p6 = new Personaje();
        p6.setNombre("Fizz");

        Set<Personaje> personajesFavoritos1 = new HashSet<>();
        personajesFavoritos1.add(p1);
        personajesFavoritos1.add(p2);
        Set<Personaje> personajesFavoritos2 = new HashSet<>();
        personajesFavoritos2.add(p3);
        personajesFavoritos2.add(p4);

        j1.setPersonajesFavoritos(personajesFavoritos1);
        j2.setPersonajesFavoritos(personajesFavoritos2);

        List<Personaje> personajesDisponibles = new ArrayList<>();
        personajesDisponibles.add(p1);
        personajesDisponibles.add(p5);
        personajesDisponibles.add(p6);

        List<Jugador> listaJugadores = new ArrayList<>();
        listaJugadores.add(j1);
        listaJugadores.add(j2);

        Partida partida1 = new Partida();
        partida1.setId(100);
        partida1.setCodigo("PartidaAnder");

        inicializarPartida(partida1, listaJugadores, personajesDisponibles);

        System.out.println(partida1);

        //Timeout de 3segundos para comprobar el tiempo de partida
        try{Thread.sleep(3000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }

        finalizarPartida(partida1, 1);

        System.out.println(partida1);
    }
}
