public class PuntoImpl implements Punto{
    private Double x;
    private Double y;

    public PuntoImpl(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
    public Double getX() {
        return x;
    }
    public Double getY() {
        return y;
    }
    public void setX(Double x) {
        this.x = x;
    }
    public void setY(Double y) {
        this.y = y;
    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
