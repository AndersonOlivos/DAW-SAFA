package Practica4;

public class Punto3DImpl implements Punto3D {
    private Double x;
    private Double y;
    private Double z;

    public Punto3DImpl(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x +
                ", " + y +
                ", " + z +
                ')';
    }

    public Double distanciaA(Punto3D punto2) {
        return Math.sqrt(
                Math.pow(this.x - punto2.getX(), 2) +
                        Math.pow(this.y - punto2.getY(), 2) +
                        Math.pow(this.z - punto2.getZ(), 2)
        );
    }
}
