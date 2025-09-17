import java.util.Scanner;

public class SaludoPersonalizado {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("¡Hola, " + nombre + "! Bienvenido a Java.");
    }
}
