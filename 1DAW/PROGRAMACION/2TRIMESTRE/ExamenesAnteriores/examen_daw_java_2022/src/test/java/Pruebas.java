import java.util.ArrayList;
import java.util.List;

public class Pruebas {

    public static  int factorial(int numero){
        if(numero == 0){
            return 1;
        }else{
            return numero * factorial(numero-1);
        }
    }


    public static void main(String[] args) {

        int numero = 3;

        List<String> alumnos = new ArrayList<>();

        try{
            alumnos.add("Sebas");
            alumnos.get(5);
        }catch (Exception error){
            System.out.println(error.getMessage());
            System.out.println("Bucle infinito");
        }finally {
            System.out.println(alumnos);
        }
    }

}
