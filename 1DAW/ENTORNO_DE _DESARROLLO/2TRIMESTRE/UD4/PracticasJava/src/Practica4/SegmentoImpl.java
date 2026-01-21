package Practica4;

import java.util.Objects;

public class SegmentoImpl implements Segmento {
    private Punto3D extremo1, extremo2;

    public SegmentoImpl() {
    }

    public SegmentoImpl(Punto3D extremo1, Punto3D extremo2) {
        this.extremo1 = extremo1;
        this.extremo2 = extremo2;
    }

    public Punto3D getExtremo1() {
        return extremo1;
    }

    public void setExtremo1(Punto3D extremo1) {
        this.extremo1 = extremo1;
    }

    public Punto3D getExtremo2() {
        return extremo2;
    }

    public void setExtremo2(Punto3D extremo2) {
        this.extremo2 = extremo2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SegmentoImpl segmento = (SegmentoImpl) o;
        return Objects.equals(extremo1, segmento.extremo1) && Objects.equals(extremo2, segmento.extremo2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extremo1, extremo2);
    }

    public Double calcularDistanciaSegmento() {
        return extremo1.calcularDistancia(extremo2);
    }

    @Override
    public String toString() {
        return "["+ extremo1 + ", " + extremo2 + "]";
    }
}
