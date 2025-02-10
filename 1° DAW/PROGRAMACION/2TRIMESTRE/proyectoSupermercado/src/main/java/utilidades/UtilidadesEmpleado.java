package utilidades;

import modelos.Empleado;
import modelos.Empresa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesEmpleado {

    /**
     * Que devuelve un mapa con las letras del DNI y los empleados cuyo dni
     * contiene esa letra.
     */

    public static Map<String, List<Empleado>> getEmpleadosPorLetraDNI(List<Empleado> empleados){
        Map<String, List<Empleado>> empleadosPorLetraDNI = new HashMap<>();
        for (Empleado empleado : empleados){
            String ultimaLetraDni = Character.toString(empleado.getDni().charAt(empleado.getDni().length()-1));

            if(empleadosPorLetraDNI.containsKey(ultimaLetraDni)){
                empleadosPorLetraDNI.get(ultimaLetraDni).add(empleado);
            } else {
                empleadosPorLetraDNI.put(ultimaLetraDni, new ArrayList<>(List.of(empleado)));
            }

        }
        return empleadosPorLetraDNI;
    }

    /**
     * Que devuelve un mapa los empleados agrupados por la empresa a la que pertenecen.
     */

    public static Map<Empresa, List<Empleado>> getEmpleadosPorEmpresa(List<Empleado> empleados){
        Map<Empresa, List<Empleado>> empleadosPorEmpresa = new HashMap<>();
        for (Empleado empleado : empleados){
            if (empleadosPorEmpresa.containsKey(empleado.getEmpresa())) {
                empleadosPorEmpresa.get(empleado.getEmpresa()).add(empleado);
            } else {
                empleadosPorEmpresa.put(empleado.getEmpresa(), new ArrayList<>(List.of(empleado)));
            }
        }
        return empleadosPorEmpresa;
    }

}
