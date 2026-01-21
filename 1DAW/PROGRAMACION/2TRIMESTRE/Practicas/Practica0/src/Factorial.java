import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int n = sc.nextInt();

        System.out.println("El factorial es: " + calculaFactorial(n));
    }

    public static int calculaFactorial(int n) {
        if (n == 0){
            return 1;
        } else {
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact = fact * i;
            }
            return fact;
        }
    }
}
