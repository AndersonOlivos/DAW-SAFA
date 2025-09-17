package com.sl.utilidades;

import com.sl.modelos.*;

import java.util.*;
import java.util.function.DoubleToLongFunction;
import java.util.stream.Collectors;

public class UtilidadesGeografia {



    public static List<Pais> ejercicio1(List<Pais> paises) {

        return paises.stream()
                .filter(pais -> pais.getPaisesVecinos().size()>0 && pais.getComunidadesAutonomas().size()>2)
                .collect(Collectors.toList());
    }


    public static Map<Continente, Integer> ejercicio2(List<Continente> continentes) {

        HashMap<Continente, Integer> mapaContinentes = new HashMap<>();

        for (Continente continente : continentes) {
            if(mapaContinentes.containsKey(continente)) {
                mapaContinentes.put(continente, mapaContinentes.get(continente.getPaises().size())+continente.getPaises().size());
            } else {
                mapaContinentes.put(continente, continente.getPaises().size());
            }
        }
        return mapaContinentes;
    }


    public List<Ciudad> ejercicio3(List<Ciudad> ciudades, List<Pais> paises) {

        List<Ciudad> ciudadesCapital = new ArrayList<>();

        for (Ciudad ciudad : ciudades) {
            for (Pais pais : paises) {
                if(pais.getCapital().equals(ciudad) && !ciudadesCapital.contains(ciudad)) {
                    ciudadesCapital.add(ciudad);
                }
            }
        }

        return ciudadesCapital;
    }



    public static Map<Pais, Long> ejercicio4(List<Pais> paises) {

        HashMap<Pais, Long> mapaPaises = new HashMap<>();

        for (Pais pais : paises) {

            Long poblacionTotal = 0L;

            for(ComunidadAutonoma comunidad : pais.getComunidadesAutonomas()){
                for(Ciudad ciudad : comunidad.getCiudades()){
                    poblacionTotal += ciudad.getPoblacion();
                }
            }

            if(mapaPaises.containsKey(pais)) {
                mapaPaises.put(pais, mapaPaises.get(pais) + poblacionTotal);
            } else {
                mapaPaises.put(pais, poblacionTotal);
            }

        }

        return mapaPaises;

    }



    public static boolean ejercicio5(InformePais informePais, Pais pais) {

        Boolean paisInforme = false;
        Boolean totalHabitantes = false;
        Boolean totalComunidades = false;
        Boolean totalCiudades = false;

        if(informePais.getPais() != null){
            paisInforme = informePais.getPais().equals(pais);
        }


        Long poblacionTotal = 0L;

        for(ComunidadAutonoma comunidad : pais.getComunidadesAutonomas()){
            for(Ciudad ciudad : comunidad.getCiudades()){
                poblacionTotal += ciudad.getPoblacion();
            }
        }

        totalHabitantes = informePais.getTotalHabitantesPais().equals(poblacionTotal);

        totalComunidades = informePais.getTotalComunidadesAutonomasPais().equals(pais.getComunidadesAutonomas().size());

        Integer ciudadesPais = 0;

        for(ComunidadAutonoma comunidad : pais.getComunidadesAutonomas()){
            ciudadesPais+= comunidad.getCiudades().size();
        }

        totalCiudades = informePais.getTotalCiudadesPais().equals(ciudadesPais);

        return paisInforme && totalHabitantes && totalComunidades && totalCiudades;
    }



    public static InformeDetalladoPais ejercicio6(Pais pais) {

        InformeDetalladoPais nuevoInforme = new InformeDetalladoPais();

        HashMap<ComunidadAutonoma, Long> extensionComunidades = new HashMap<>();
        HashMap<ComunidadAutonoma, Long> poblacionComunidades = new HashMap<>();

        for(ComunidadAutonoma comunidad : pais.getComunidadesAutonomas()){

            Long extensionPorComunidad = 0L;
            Long poblacionPorComunidad = 0L;

            for(Ciudad ciudad : comunidad.getCiudades()){
                extensionPorComunidad += ciudad.getExtension();
                poblacionPorComunidad += ciudad.getPoblacion();
            }

            if(extensionComunidades.containsKey(comunidad)){
                extensionComunidades.put(comunidad, extensionComunidades.get(comunidad) + extensionPorComunidad);
            } else {
                extensionComunidades.put(comunidad, extensionPorComunidad);
            }

            if(poblacionComunidades.containsKey(comunidad)){
                poblacionComunidades.put(comunidad, poblacionComunidades.get(comunidad) + poblacionPorComunidad);
            } else {
                poblacionComunidades.put(comunidad, poblacionPorComunidad);
            }
        }

        Long comunidadMasGrandeValue = 0L;

        for(ComunidadAutonoma comunidad : extensionComunidades.keySet()){
            if(extensionComunidades.get(comunidad) > comunidadMasGrandeValue ){
                comunidadMasGrandeValue = extensionComunidades.get(comunidad);
            }
        }

        ComunidadAutonoma comunidadMasGrande = new ComunidadAutonoma();

        for(ComunidadAutonoma comunidad : extensionComunidades.keySet()){
            if(extensionComunidades.get(comunidad) == comunidadMasGrandeValue){
                comunidadMasGrande = comunidad;
            }
        }

        Long comunidadMasPobladaValue = 0L;

        for(ComunidadAutonoma comunidad : poblacionComunidades.keySet()){
            if(poblacionComunidades.get(comunidad) > comunidadMasPobladaValue ){
                comunidadMasPobladaValue = poblacionComunidades.get(comunidad);
            }
        }

        ComunidadAutonoma comunidadMasPoblada = new ComunidadAutonoma();

        for(ComunidadAutonoma comunidad : poblacionComunidades.keySet()){
            if(poblacionComunidades.get(comunidad) == comunidadMasPobladaValue){
                comunidadMasPoblada = comunidad;
            }
        }

        ComunidadAutonoma comunidadDeLaCapital = pais.getComunidadesAutonomas().stream()
                .filter(comunidadAutonoma -> comunidadAutonoma.equals(pais.getCapital().getComunidadAutonoma()))
                .toList().getFirst();


        nuevoInforme.setExtensionComunidades(extensionComunidades);
        nuevoInforme.setPoblacionComunidades(poblacionComunidades);
        nuevoInforme.setComunidadDeLaCapital(comunidadDeLaCapital);
        nuevoInforme.setComunidadMasGrande(comunidadMasGrande);
        nuevoInforme.setComunidadMasPoblada(comunidadMasPoblada);

        return nuevoInforme;

    }


}
