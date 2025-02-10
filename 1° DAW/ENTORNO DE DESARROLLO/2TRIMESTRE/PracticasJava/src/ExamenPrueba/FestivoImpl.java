package ExamenPrueba;

import java.util.Objects;

public class FestivoImpl implements Festivo {
    private String nombreFiesta;
    private String mes;

    public FestivoImpl() {
    }

    public FestivoImpl(String nombreFiesta, String mes) {
        this.nombreFiesta = nombreFiesta;
        this.mes = mes;
    }

    public String getNombreFiesta() {
        return nombreFiesta;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FestivoImpl festivo = (FestivoImpl) o;
        return Objects.equals(nombreFiesta, festivo.nombreFiesta) && Objects.equals(mes, festivo.mes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreFiesta, mes);
    }

    public String toString() {
        return nombreFiesta + ", en " + mes + ".";
    }
}
