package modelos;

import java.util.List;
import java.util.Objects;

public class Empresa {
    private Integer idContrato;
    private String codigoEmpresa;
    private List<Empleado> empleados;
    private TipoEmpresa tipoEmpresa;

    public Empresa() {
    }

    public Empresa(Integer idContrato, String codigoEmpresa, List<Empleado> empleados, TipoEmpresa tipoEmpresa) {
        this.idContrato = idContrato;
        this.codigoEmpresa = codigoEmpresa;
        this.empleados = empleados;
        this.tipoEmpresa = tipoEmpresa;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(idContrato, empresa.idContrato) && Objects.equals(codigoEmpresa, empresa.codigoEmpresa) && Objects.equals(empleados, empresa.empleados) && tipoEmpresa == empresa.tipoEmpresa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContrato, codigoEmpresa, empleados, tipoEmpresa);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "codigoEmpresa='" + codigoEmpresa + '\'' +
                '}';
    }
}
