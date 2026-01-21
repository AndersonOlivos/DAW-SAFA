package utilidades;

import modelos.Jugador;
import modelos.Partida;
import modelos.Personaje;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

public class UtilidadesPartida {

    public static void inicializarPartida(Partida partida, List<Jugador> participantes, List<Personaje> personajesDisponibles){

        if(participantes.size() % 2 != 0 && participantes.isEmpty() ) return;

        List<Personaje> listaPersonajesDisponibles = personajesDisponibles;

        //Mezclamos aleatoriamente la lista de personajes disponibles para realizar las elecciones
        Collections.shuffle(listaPersonajesDisponibles);

        List<Jugador> listaJugadores = participantes;

        //Mezclamos aleatoriamente la lista de jugadores para formar los equipos
        Collections.shuffle(listaJugadores);

        Map<Jugador, Personaje> mapaEleccion = new HashMap();

        /*
          Inicializa el mapa de elecciones de la partida, asignando a cada
          jugador un personaje de entre los personajesDisponibles,
          eligiendo preferentemente uno de entre sus favoritos y si no uno
          aleatorio de los disponibles.
        */

        for(Jugador j: participantes){

            /*
            Comprobar si hay un personaje favorito del jugador en la lista disponible
            Si lo hay:
             1. Le asignamos el primer personaje favorito encontrado
             2. Borramos el personaje favorito de la lista de los disponbiles
             3. Cerramos el bucle

            Si no lo hay:
             1. Le asignamos uno aleatorio
             2. Borramos ese personaje de la lista de disponibles
            */

            Boolean existePersonajeFavorito = false;

            for(Personaje pFavorito : j.getPersonajesFavoritos()){
                if(listaPersonajesDisponibles.contains(pFavorito)){
                    mapaEleccion.put(j, pFavorito);
                    listaPersonajesDisponibles.remove(pFavorito);
                    existePersonajeFavorito = true;
                    break;
                }
            }

            if(!existePersonajeFavorito){
                mapaEleccion.put(j, listaPersonajesDisponibles.getFirst());
                listaPersonajesDisponibles.removeFirst();
            }
        }

        partida.setElecciones(mapaEleccion);

        /*
          Inicializa el mapa de jugadoresPorEquipo, asignando
          aleatoriamente cada jugador a uno de los equipos, sabiendo que el
          número de jugadores siempre es par y que siempre hay dos
          equipos.
        */

        Map<Integer, Set<Jugador>> mapaEquipos = new HashMap();
        Set<Jugador> equipo1 = new HashSet();
        Set<Jugador> equipo2 = new HashSet();

        int numeroJugadores = listaJugadores.size();

        for(int i=0; i<numeroJugadores; i++){
            if (i < (numeroJugadores / 2)) {
                equipo1.add(listaJugadores.get(i));
            } else {
                equipo2.add(listaJugadores.get(i));
            }
        }

        mapaEquipos.put(1, equipo1);
        mapaEquipos.put(2, equipo2);

        partida.setJugadoresPorEquipo(mapaEquipos);

        partida.setInicioPartida(LocalDateTime.now());
    }

    public static void finalizarPartida(Partida partida, Integer equipoVencedor){

        partida.setFinPartida(LocalDateTime.now());

        //Calculamos el tiempo de la partida
        Integer segundosPartida = (int) Duration.between(partida.getInicioPartida(), partida.getFinPartida()).getSeconds();

        partida.setDuracionPartida(segundosPartida);
        partida.setEquipoVencedor(equipoVencedor);

        for(Jugador jugadorVencedor : partida.getJugadoresPorEquipo().get(equipoVencedor)){

            Personaje personajeJugado = partida.getElecciones().get(jugadorVencedor);

            if(jugadorVencedor.getPartidasGanadas().containsKey(personajeJugado)){
                jugadorVencedor.getPartidasGanadas().put(personajeJugado, jugadorVencedor.getPartidasGanadas().get(personajeJugado) + 1);
            } else {
                jugadorVencedor.getPartidasGanadas().put(personajeJugado, 1);
            }

        }
    }

}
