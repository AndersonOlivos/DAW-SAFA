package Practica4;

public class Test4 {
    public static void main(String[] args) {
        Punto3D punto1 = new Punto3DImpl(10.0, 20.0, 10.0);
        Punto3D punto2 = new Punto3DImpl(50.0, 80.0, 100.0);
        Segmento seg1 = new SegmentoImpl(punto1, punto2);
        System.out.println(punto1.calcularDistancia(punto2));
        System.out.println(punto1);
        System.out.println(seg1.calcularDistanciaSegmento());
        System.out.println(seg1);
    }
}
