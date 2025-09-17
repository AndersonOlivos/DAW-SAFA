import java.util.Scanner;

public class NumeroMayor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int num1 = sc.nextInt();
        System.out.println("Ingrese otro numero: ");
        int num2 = sc.nextInt();

        if (num1 > num2) {
            System.out.println("El numero " + num1 + " es mayor que el numero " + num2);
        } else if (num2 > num1) {
            System.out.println("El numero " + num2 + " es mayor que el numero " + num1);
        } else {
            System.out.println("El numero " + num1 + " es igual que el numero " + num2);
        }

    }
}
