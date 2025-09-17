import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>(List.of(1,2,3,4));
        List<Integer> otrosNumeros = new ArrayList<>(List.of(6,4));
        numeros.retainAll(otrosNumeros);
        System.out.println(numeros);
    }
}
