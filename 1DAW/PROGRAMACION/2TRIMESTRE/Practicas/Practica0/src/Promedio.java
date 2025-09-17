import java.util.ArrayList;
import java.util.Scanner;

public class Promedio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        int num1 = sc.nextInt();
        System.out.print("Ingrese el segundo numero: ");
        int num2 = sc.nextInt();
        System.out.print("Ingrese el tercer numero: ");
        int num3 = sc.nextInt();

        System.out.println("El promedio es: " + promedio(num1, num2, num3));

    }

    public static double promedio(int num1, int num2, int num3) {
        return ((num1 + num2 + num3)/3);
    }
}
