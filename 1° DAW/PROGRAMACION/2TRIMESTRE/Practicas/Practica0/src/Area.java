public class Area {
    public static void main(String[] args) {
        double radio = 4.0;
        System.out.println("Radio: " + radio);
        System.out.println("Area: " + calculaArea(radio));
    }

    public static double calculaArea(double radio){
        return (Math.PI * (radio*radio));

    }
}
