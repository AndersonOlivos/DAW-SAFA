package utilidades;
import java.util.Random;

import modelos.Contrato;
import modelos.Empleado;
import modelos.Empresa;
import modelos.TipoContrato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesContrato {

    /**
     * Que devuelve un mapa con cada tipo de contrato y la media de salario
     * base que tienen los contratos de ese tipo.
     */

    public static Map<TipoContrato, Double> getSalarioMedioTipoContrato(List<Contrato> contratos){
        Map<TipoContrato, Double> salarioMedioTipoContrato = new HashMap<>();
        Map<TipoContrato, Integer> numeroTipoContrato = getNumContratosPorTipo(contratos);

        for( Contrato c : contratos ){
            TipoContrato tipoContrato = c.getTipoContrato();
            if(salarioMedioTipoContrato.containsKey(tipoContrato)){
                salarioMedioTipoContrato.put(tipoContrato, salarioMedioTipoContrato.get(tipoContrato) + c.getSalarioBase());
            } else {
                salarioMedioTipoContrato.put(tipoContrato, c.getSalarioBase());
            }
        }

        for( TipoContrato c : salarioMedioTipoContrato.keySet() ){
            salarioMedioTipoContrato.put(c, salarioMedioTipoContrato.get(c)/numeroTipoContrato.get(c));
        }

        return salarioMedioTipoContrato;
    }

    /**
     * Que devuelve un mapa con cada tipo de contrato y el número de
     * contratos que hay de este tipo.
     */

    public static Map<TipoContrato, Integer> getNumContratosPorTipo(List<Contrato> contratos){
        Map<TipoContrato, Integer> numContratosPorTipo = new HashMap<>();
        for (Contrato c : contratos){
           TipoContrato tipoContrato = c.getTipoContrato();
           if (numContratosPorTipo.containsKey(tipoContrato)){
               numContratosPorTipo.put(tipoContrato, numContratosPorTipo.get(tipoContrato) + 1);
           } else {
               numContratosPorTipo.put(tipoContrato, 1);
           }
        }
        return numContratosPorTipo;
    }

    /**
     * Que devuelve un mapa con los tipo de contrato y la lista con todos los
     * contratos que tienen dicho tipo.
     */

    public static Map<TipoContrato, List<Contrato>> getListContratosPorTipo(List<Contrato> contratos){
        Map<TipoContrato, List<Contrato>> listContratosPorTipo = new HashMap<>();

        for (Contrato c : contratos){
            if(listContratosPorTipo.containsKey(c.getTipoContrato())){
                listContratosPorTipo.get(c.getTipoContrato()).add(c);
            } else {
                listContratosPorTipo.put(c.getTipoContrato(), new ArrayList<>(List.of(c)));
            }
        }
        return listContratosPorTipo;
    }

    /**
     * Que a partir de los datos que se le pasan genera un empleado
     * asignándole empresa y contrato. EL método tiene que generar los
     * identificadores automáticamente, siendo cada identificador creado
     * diferente.
     */

    public Empleado contratarTrabajador(Empresa e, String dni, String nombre, String apellidos, String direccion, String telefono, TipoContrato tipo, Double salario){
        Random random = new Random();
        Integer idCliente = random.nextInt(1000) + 1;
        Integer idContrato = random.nextInt(1000) + 1;
        return new Empleado(idCliente, dni, nombre, apellidos, direccion, telefono, e, new Contrato(idContrato, salario, tipo));
    }
}
