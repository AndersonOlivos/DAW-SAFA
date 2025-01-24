package Practica2;

public class FechaImpl implements Fecha{
    private Integer dia, mes, anio;

    //CONSTRUCTOR

    public FechaImpl(Integer dia, Integer mes, Integer anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    //DIA: consultable

    public Integer getDia() {
        return dia;
    }

    //MES: consultable

    public Integer getMes() {
        return mes;
    }

    //ANIO: consultable

    public Integer getAnio() {
        return anio;
    }

    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }

}
