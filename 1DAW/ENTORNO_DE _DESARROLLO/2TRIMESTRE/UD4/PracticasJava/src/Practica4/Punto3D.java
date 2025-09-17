package Practica4;

public interface Punto3D {
    public Double getX();
    public void setX(Double x);
    public Double getY();
    public void setY(Double y);
    public Double getZ();
    public void setZ(Double z);
    public Double calcularDistancia(Punto3D punto2);
}
