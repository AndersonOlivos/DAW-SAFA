public class Main {
    public static void main(String[] args) {
        Persona persona1 = new PersonaImpl("Ander","Olivos Gamarra", "77934073E",30);
        Fecha salida = new FechaImpl(10,11,2001);
        Vuelo vuelo = new VueloImpl("IB2349","Madrid",persona1,salida);
        System.out.println(vuelo);
    }
}
