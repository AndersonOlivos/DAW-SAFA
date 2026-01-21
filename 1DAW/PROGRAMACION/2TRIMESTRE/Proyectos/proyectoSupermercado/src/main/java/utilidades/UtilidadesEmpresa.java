package utilidades;

import modelos.Empleado;
import modelos.Empresa;
import modelos.TipoContrato;
import modelos.TipoEmpresa;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesEmpresa {

    /**
     * Que devuelve la lista de empleados pertenecientes a la empresa y que
     * tienen un contrato del tipo que se le pasa.
     */

    public List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato) {
        List<Empleado> empleados = new ArrayList<>();
        for (Empleado empleado : empresa.getEmpleados()) {
            if (empleado.getContrato().getTipoContrato().equals(tipoContrato)) {
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    /**
     * Que devuelve todos los empleados de la empresa cuyo salario es mayor
     * o igual que 1000 € ordenados de mayor a menor salario.
     */

    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa) {

        List<Empleado> empleados = new ArrayList<>();
        for (Empleado empleado : empresa.getEmpleados()) {
            if (empleado.getContrato().getSalarioBase() >= 1000) {
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

    public Double fondoSalarialEmpresa(Empresa empresa) {
        Double salarioTotal = 0.0;
        for (Empleado empleado : empresa.getEmpleados()) {
            salarioTotal += empleado.getContrato().getSalarioBase();
        }
        return salarioTotal;
    }

    /**
     * Que devuelve el empleado que más cobra de todos los empleados de las
     * empresas que se pasan como parámetros
     */

    public Empleado getMejorPagado(List<Empresa> empresas) {
        Empleado mejorEmpleado = new Empleado();
        for (Empresa empresa : empresas) {
            for (Empleado empleado : empresa.getEmpleados()) {
                if (empleado.getContrato().getSalarioBase() > mejorEmpleado.getContrato().getSalarioBase()) {
                    mejorEmpleado = empleado;
                }
            }
        }
        return mejorEmpleado;
    }

    /**
     * Que devuelve un mapa con el número de empresas que hay para cada tipo.
     */

    public static Map<TipoEmpresa, Integer> getNumEmpresasPorTipo(List<Empresa> empresas) {
        Map<TipoEmpresa, Integer> numEmpresas = new HashMap<>();

        for (Empresa empresa : empresas) {
            if (numEmpresas.containsKey(empresa.getTipoEmpresa())) {
                numEmpresas.put(empresa.getTipoEmpresa(), numEmpresas.get(empresa.getTipoEmpresa()) + 1);
            } else {
                numEmpresas.put(empresa.getTipoEmpresa(), 1);
            }
        }

        return numEmpresas;
    }

    public static Map<TipoEmpresa, Integer> getNumEmpleadosPorTipoEmpresa(List<Empresa> empresas) {
        Map<TipoEmpresa, Integer> numEmpleados = new HashMap<>();
        for (Empresa empresa : empresas) {
            if (numEmpleados.containsKey(empresa.getTipoEmpresa())) {
                numEmpleados.put(empresa.getTipoEmpresa(), numEmpleados.get(empresa.getTipoEmpresa()) + empresa.getEmpleados().size());
            } else {
                numEmpleados.put(empresa.getTipoEmpresa(), empresa.getEmpleados().size());
            }
        }
        return numEmpleados;
    }

    /**
     * Que devuelve un mapa de los empleados de la empresa agrupados por su
     * tipo de contrato.
     */

    public static Map<TipoContrato, List<Empleado>> getEmpleadosPorTipoContrato(Empresa empresa) {
        if (empresa == null || empresa.getEmpleados() == null) {
            return new HashMap<>();
        }
        return empresa.getEmpleados().stream().collect(Collectors.groupingBy(empleado -> empleado.getContrato().getTipoContrato()));
    }

    public static Map<Empresa, Map<TipoContrato, List<Empleado>>> getEmpleadosPorTipoContratoEmpresas(List<Empresa> empresas) {
        Map<Empresa, Map<TipoContrato, List<Empleado>>> resultado = new HashMap<>();
        for (Empresa empresa : empresas) {
            if (empresa != null && empresa.getEmpleados() != null) {
                resultado.put(empresa, getEmpleadosPorTipoContrato(empresa));
            }
        }
        return resultado;
    }

    /**
    * Que devuelve la lista de empleados pertenecientes de las empresas
    * PYMES que se pasan cuyo contrato es del tipo PRACTICAS.
    **/

    public List<Empleado> getEmpleadosPymePracticas(List<Empresa>empresas){
        List<Empleado> empleados = new ArrayList<>();
        for (Empresa empresa : empresas) {
            for(Empleado empleado : empresa.getEmpleados()) {
                if (empresa.getTipoEmpresa().equals(TipoEmpresa.PYME) && empleado.getContrato().equals(TipoContrato.PRACTICAS)) {
                    empleados.add(empleado);
                }
            }
        }
        return empleados;
    }

    /**
     * Que devuelva un mapa con el empleado que más cobra de cada empresa.
     **/

    public Map<Empresa,Empleado> getLosMejorPagadosPorEmpresa(List<Empresa> empresas){
        Map<Empresa, Empleado> losMejorPagados = new HashMap<>();
        for (Empresa empresa : empresas) {
            losMejorPagados.put(empresa, getMejorPagado(List.of(empresa)));
        }
        return losMejorPagados;
    }

}
