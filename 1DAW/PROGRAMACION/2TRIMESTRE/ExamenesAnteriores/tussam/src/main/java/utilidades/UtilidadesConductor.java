package utilidades;

import modelos.Autobus;
import modelos.Conductor;
import modelos.JornadaLaboral;
import modelos.Parada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UtilidadesConductor {

    public UtilidadesConductor() {
    }


    /**
     * Ejercicio 3A (3 puntos)
     *
     * Dado un conductor y los itinerarios recorridos en un día de trabajo devuelve el resumen de su jornada laboral
     *
     * @param
     * @return
     */
    public static JornadaLaboral terminarJornadaLaboral(Conductor conductor, Map<Autobus,Integer> autobuses_num_itinerarios){

        JornadaLaboral jornadaLaboral = new JornadaLaboral();

        jornadaLaboral.setId(1);
        jornadaLaboral.setFecha(LocalDate.now());
        jornadaLaboral.setConductor(conductor);
        jornadaLaboral.setAutobuses_num_itinerarios(autobuses_num_itinerarios);

        int paradas_totales = 0;
        double sumatorio_total = 0.0;


        for (Autobus autobus : autobuses_num_itinerarios.keySet()) {
            paradas_totales += autobus.getRecorrido().getParadas().size();

            double sumatorio_paradas = 0.0;

            for(Parada parada : autobus.getRecorrido().getParadas()){
                sumatorio_paradas += parada.getBonificacion_parada();
            }

            sumatorio_total += autobuses_num_itinerarios.get(autobus) * sumatorio_paradas;
        }

        jornadaLaboral.setNum_paradas_totales(paradas_totales);
        jornadaLaboral.setSalario(sumatorio_total);

        return jornadaLaboral;
    }


    /**
     * Ejercicio 3B (2 puntos)
     *
     * Dado un importe restante de un bono de autobús y una Lista de Autobuses, devuelve la parada en la que quedará sin
     * saldo un viajero de los itinerario de autobuses por orden
     *
     * @param
     * @return
     */
    public static Parada getParadaPosible(Double importe_restante, List<Autobus> autobuses){

        Parada paradaDisponible = new Parada();

        for(Autobus autobus : autobuses){
            for(Parada parada : autobus.getRecorrido().getParadas()){
                if(parada.getBonificacion_parada() <= importe_restante){
                    paradaDisponible = parada;
                    importe_restante -= parada.getBonificacion_parada();
                } else {
                    return paradaDisponible;
                }
            }
        }

       return paradaDisponible;

    }

}
