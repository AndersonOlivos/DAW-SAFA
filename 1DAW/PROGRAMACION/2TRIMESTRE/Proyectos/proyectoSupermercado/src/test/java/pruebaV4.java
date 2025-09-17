import modelos.*;

import java.util.ArrayList;
import java.util.List;

//import static utilidades.UtilidadesEmpleado.getEmpleadosPorEmpresa;
//import static utilidades.UtilidadesEmpleado.getEmpleadosPorLetraDNI;
import static utilidades.UtilidadesEmpresa.getEmpleadosPorTipoContrato;
import static utilidades.UtilidadesEmpresa.getEmpleadosPorTipoContratoEmpresas;

public class pruebaV4 {
    public static void main(String[] args) {
        Contrato contrato1 = new Contrato();
        Contrato contrato2 = new Contrato();
        Contrato contrato3 = new Contrato();
        Contrato contrato4 = new Contrato();

        contrato1.setTipoContrato(TipoContrato.PRACTICAS);
        contrato2.setTipoContrato(TipoContrato.TEMPORAL);
        contrato3.setTipoContrato(TipoContrato.INDEFINIDO);
        contrato4.setTipoContrato(TipoContrato.INDEFINIDO);

        contrato1.setSalarioBase(200.0);
        contrato2.setSalarioBase(300.0);
        contrato3.setSalarioBase(700.0);
        contrato4.setSalarioBase(900.0);

        List<Contrato> contratos = new ArrayList<>();
        contratos.add(contrato1);
        contratos.add(contrato2);
        contratos.add(contrato3);
        contratos.add(contrato4);

        //System.out.println(getSalarioMedioTipoContrato(contratos));
        //System.out.println(getListContratosPorTipo(contratos));

        Empresa empresa1 = new Empresa();
        Empresa empresa2 = new Empresa();

        empresa1.setCodigoEmpresa("AMAZON");
        empresa2.setCodigoEmpresa("GOOGLE");

        empresa1.setTipoEmpresa(TipoEmpresa.MULTINACIONAL);
        empresa2.setTipoEmpresa(TipoEmpresa.NACIONAL);

        List<Empresa> empresas1 = new ArrayList<>();
        empresas1.add(empresa1);

        List<Empresa> empresas2 = new ArrayList<>();
        empresas2.add(empresa2);

        Empleado empleado1 = new Empleado();
        Empleado empleado2 = new Empleado();
        Empleado empleado3 = new Empleado();

        empleado1.setDni("77934073E");
        empleado2.setDni("77934073A");
        empleado3.setDni("77934073I");

        empleado1.setEmpresa(empresa1);
        empleado2.setEmpresa(empresa1);
        empleado3.setEmpresa(empresa2);

        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);

        empresa1.setEmpleados(empleados);
        empresa2.setEmpleados(empleados);

        empleado1.setContrato(contrato1);
        empleado2.setContrato(contrato2);
        empleado3.setContrato(contrato3);



        //System.out.println(getEmpleadosPorLetraDNI(empleados));
        //System.out.println(getEmpleadosPorEmpresa(empleados));

        //System.out.println(getNumEmpresasPorTipo(empresas));
        //System.out.println(getNumEmpleadosPorTipoEmpresa(empresas));
        //System.out.println(getEmpleadosPorTipoContrato(empresa1));
        System.out.println(getEmpleadosPorTipoContratoEmpresas(empresas2));
    }
}
