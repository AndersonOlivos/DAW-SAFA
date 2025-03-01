package utilidades;

import modelos.Personaje;
import modelos.Region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesPersonaje {

    public static Personaje levelUp(Personaje personaje){
        personaje.setNivel(personaje.getNivel()+1);
        personaje.setAtaque(personaje.getAtaqueBase() + personaje.getEscalabilidad().getIncrementoDanioNivel() * personaje.getNivel());
        personaje.setDefensa(personaje.getDefensaBase() + personaje.getEscalabilidad().getIncrementoDefensaNivel() * personaje.getNivel());
        personaje.setMana(personaje.getManaBase() + personaje.getEscalabilidad().getIncrementoManaNivel() * personaje.getNivel());
        personaje.setVida(personaje.getVidaBase() + personaje.getEscalabilidad().getIncrementoSaludNivel() * personaje.getNivel());
        return personaje;
    }

    public static void maxearPersonaje(Personaje personaje){
        do {
            levelUp(personaje);
        } while( personaje.getNivel() < 18);
    }

    public static Map<Region, List<Personaje>> getPersonajesPorRegion(List<Personaje> personajes){
        Map<Region, List<Personaje>> personajesPorRegion = new HashMap<Region, List<Personaje>>();
        for(Personaje personaje : personajes){
            if(personajesPorRegion.containsKey(personaje.getRegion())){
                personajesPorRegion.get(personaje.getRegion()).add(personaje);
            } else {
                personajesPorRegion.put(personaje.getRegion(), new ArrayList<>(List.of(personaje)));
            }
        }
        return personajesPorRegion;
    }

    public static Personaje getMasPoderoso (List<Personaje> personajes){

        List<Personaje> copiaPersonajes = new ArrayList<>(personajes);

        Map< Personaje, Double> personajeEstadisticas = new HashMap<>();

        for(Personaje personaje : copiaPersonajes){
            maxearPersonaje(personaje);
        }

        for(Personaje personaje : copiaPersonajes){
            Double estadistica = personaje.getAtaque() + personaje.getDefensa() + personaje.getMana() + personaje.getVida();
            personajeEstadisticas.put(personaje, estadistica);
        }

        return personajeEstadisticas.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public static Map<Region, List<Personaje>> getMasPoderosoPorRegion(List<Personaje> personajes){

        List<Personaje> copiaPersonajes = new ArrayList<>(personajes);

        Map<Region, List<Personaje>> personajesPorRegion = new HashMap<>();
        Map<Region, List<Personaje>> personajesPorRegionMasPoderoso = new HashMap<>();

        //CREAMOS UN MAPA CON LOS PERSONAJES POR REGIONES

        for(Personaje personaje : copiaPersonajes){
            if(personajesPorRegion.containsKey(personaje.getRegion())){
                personajesPorRegion.get(personaje.getRegion()).add(personaje);
            } else {
                personajesPorRegion.put(personaje.getRegion(), new ArrayList<>(List.of(personaje)));
            }
        }

        //SELECCIONAMOS LOS MAS PODEROSOS DE CADA REGION

        for(Region region : personajesPorRegion.keySet()){
            personajesPorRegionMasPoderoso.put(region, List.of(getMasPoderoso(personajesPorRegion.get(region))));
        }

        return personajesPorRegionMasPoderoso;
    }
}
