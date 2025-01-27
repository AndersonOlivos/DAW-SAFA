package utilidades;

import modelos.Empleado;
import modelos.Empresa;
import modelos.TipoContrato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UtilidadesEmpresa {

    /**
     * Que devuelve la lista de empleados pertenecientes a la empresa y que
     * tienen un contrato del tipo que se le pasa.
     */

    public List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato){
        List<Empleado> empleados = new ArrayList<>();
        for (Empleado empleado : empresa.getEmpleados()){
            if (empleado.getContrato().getTipoContrato().equals(tipoContrato)){
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    /**
     * Que devuelve todos los empleados de la empresa cuyo salario es mayor
     * o igual que 1000 € ordenados de mayor a menor salario.
     */

    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa){

        List<Empleado> empleados = new ArrayList<>();
        for (Empleado empleado : empresa.getEmpleados()){
            if(empleado.getContrato().getSalarioBase() >= 1000){
                empleados.add(empleado);
            }
        }

        Collections.sort(empleados, (e1, e2) -> Double.compare(e2.getContrato().getSalarioBase(), e1.getContrato().getSalarioBase()));

        return empleados;
    }

    /**
     * Que devuelve la suma de los salarios de todos los empleados de la
     * empresa.
     */

    public Double fondoSalarialEmpresa(Empresa empresa){
        Double salarioTotal = 0.0;
        for (Empleado empleado : empresa.getEmpleados()){
            salarioTotal += empleado.getContrato().getSalarioBase();
        }
        return salarioTotal;
    }

    /**
     * Que devuelve el empleado que más cobra de todos los empleados de las
     * empresas que se pasan como parámetros
     */

    public Empleado getMejorPagado(List<Empresa> empresas){
        Empleado mejorEmpleado = new Empleado();
        for (Empresa empresa : empresas){
            for (Empleado empleado : empresa.getEmpleados()){
                if (empleado.getContrato().getSalarioBase() > mejorEmpleado.getContrato().getSalarioBase()){
                    mejorEmpleado = empleado;
                }
            }
        }
        return mejorEmpleado;
    }

}
