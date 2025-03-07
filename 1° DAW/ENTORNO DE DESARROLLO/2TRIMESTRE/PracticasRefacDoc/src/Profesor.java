import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona {
    List<Prestamo> prestamos;

    public Profesor(String nombre, int edad, String numeroDeTelefono, List<Prestamo> prestamos) {
        super(nombre, edad, numeroDeTelefono);
        this.prestamos = prestamos;
    }

    public void printInformacionPersonal() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Teléfono: " + numeroTelefono);
    }

    public void printTodaLaInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Teléfono: " + numeroTelefono);
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }
}