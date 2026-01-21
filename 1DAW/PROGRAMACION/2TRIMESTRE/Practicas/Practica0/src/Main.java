//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       int resultado = sumar(5,7);
        System.out.println("La suma es: " + resultado);
    }

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static boolean esPar(int a){
        if ( a%2 == 0 ) {
            return true;
        } else {
            return false;
        }
    }
}

