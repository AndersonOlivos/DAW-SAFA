package Practica4;

public interface Segmento {
    public Punto3D getExtremo1();
    public void setExtremo1(Punto3D extremo1);
    public Punto3D getExtremo2();
    public void setExtremo2(Punto3D extremo2);
    public Double calcularDistanciaSegmento();
}
