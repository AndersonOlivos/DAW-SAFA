package utilidades;


import modelos.*;

import java.time.Duration;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilidadesCine {



    public static List<Cine> ejercicio1(List<Cine> cines){
        List<Cine> cinesAsientos = new ArrayList<>();
        for (Cine cine : cines){
            boolean minimo = false;
            for(Sala sala : cine.getSalas()){
                if(sala.getAsientos().size()>20) {
                    minimo = true;
                }
            }
            if(minimo){ cinesAsientos.add(cine); }
        }
        return cinesAsientos;
    }



    public static Map<Sala, Integer> ejercicio2(Cine cine){
        Map<Sala, Integer> salas = new HashMap<>();
        for(Sala sala : cine.getSalas()){
            salas.put(sala, sala.getAsientos().size());
        }
        return salas;
    }


    public static Pelicula ejercicio3(Cine cine){

        Pelicula mejorPelicula = new Pelicula();
        mejorPelicula.setRating(0.0);

        for( Sala sala: cine.getSalas()){
            for(Proyeccion proyeccion : sala.getFunciones()){
                if(proyeccion.getPelicula().getRating()>mejorPelicula.getRating()){
                    mejorPelicula = proyeccion.getPelicula();
                }
            }
        }

        if(mejorPelicula.getId()==null){
            return null;
        } else {
            return mejorPelicula;
        }
    }



    public static Map<Proyeccion,Long> ejercicio4(Sala sala){
        HashMap<Proyeccion,Long> proyectos = new HashMap<>();
        for (Proyeccion proyeccion : sala.getFunciones()){
            Long duracion = Math.abs(Duration.between(proyeccion.getFechaFin(), proyeccion.getFechaInicio()).toSeconds());
            proyectos.put(proyeccion, duracion);
        }
        return proyectos;
    }



    public static Double ejercicio5(Cine cine){
        Double recaudacion = 0.0;
        for(Sala sala : cine.getSalas()){
            for(Proyeccion proyeccion : sala.getFunciones()){
                for(Entrada entrada : proyeccion.getEntradas()){
                    recaudacion += entrada.getPrecio();
                }
            }
        }
        return recaudacion;
    }



    public static InformeProyeccion ejercicio6(Proyeccion proyeccion){
        Double recaudacionProyeccion = 0.0;
        for(Entrada entrada : proyeccion.getEntradas()){
            recaudacionProyeccion += entrada.getPrecio();
        }

        List<Entrada> entradasFraudulentas = new ArrayList<>();

        for(Entrada entrada : proyeccion.getEntradas()){
            Asiento posibleAsientoFraudulento = entrada.getAsiento();
            for(Asiento asiento : proyeccion.getSala().getAsientos()){
                if(asiento.equals(posibleAsientoFraudulento) && !asiento.isDisponible()){
                    entradasFraudulentas.add(entrada);
                }
            }
        }

        HashMap<Asiento, Boolean> asientosDisponibles = new HashMap<>();

        for(Entrada entrada : entradasFraudulentas){
            for(Asiento asiento : proyeccion.getSala().getAsientos()){
                if(asiento.isDisponible()){
                    asientosDisponibles.put(asiento, true);
                } else {
                    asientosDisponibles.put(asiento, false);
                }
            }
        }



        InformeProyeccion informeProyeccion = new InformeProyeccion();
        informeProyeccion.setPelicula(proyeccion.getPelicula());
        informeProyeccion.setAsientosOcupados(proyeccion.getEntradas().size());
        informeProyeccion.setAsientosDisponibles(proyeccion.getSala().getAsientos().size()-informeProyeccion.getAsientosOcupados());
        informeProyeccion.setRecaudacionSala(recaudacionProyeccion);
        informeProyeccion.setPorcentajeOcupacionSala(informeProyeccion.getAsientosOcupados() / (double) proyeccion.getSala().getAsientos().size());
        informeProyeccion.setEntradasFraudulentas(entradasFraudulentas);
        informeProyeccion.setDisponibilidadAsientos(asientosDisponibles);

        return informeProyeccion;
    }








}
