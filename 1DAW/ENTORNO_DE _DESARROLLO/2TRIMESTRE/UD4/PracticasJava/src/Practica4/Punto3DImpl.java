package Practica4;

import java.util.Objects;

public class Punto3DImpl implements Punto3D {

    private Double x,y,z;

    public Punto3DImpl(Double x, Double y, Double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        if (Objects.nonNull(x)) {
            this.x = x;
        } else {
            this.x = 0.0;
        }
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        if (Objects.nonNull(y)) {
            this.y = y;
        } else {
            this.y = 0.0;
        }    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        if (Objects.nonNull(z)) {
            this.z = z;
        } else {
            this.z = 0.0;
        }    }

    public Double calcularDistancia(Punto3D punto2) {
        return Math.sqrt(Math.pow((punto2.getX()-this.x),2) + Math.pow((punto2.getY()-this.y),2) + Math.pow((punto2.getZ()-this.z),2));
    }



    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }
}
