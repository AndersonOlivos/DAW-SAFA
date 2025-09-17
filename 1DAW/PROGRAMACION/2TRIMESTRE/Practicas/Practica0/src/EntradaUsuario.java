import java.util.Scanner;

public class EntradaUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su edad: ");
        int edad = scanner.nextInt();

        System.out.println("Ingrese un numero: ");
        int num1 = scanner.nextInt();

        System.out.println("Ingrese otro numero: ");
        int num2 = scanner.nextInt();

        System.out.println("Hola, " + nombre + ". Tienes , " + edad + " años. La suma de los números es "+ Main.sumar(num1, num2));
    }
}
