package Ejercicio3Ref;

import java.util.ArrayList;
import java.util.List;

public class utilidades {
    public static void main(String[] args) {
        Festividad f1 = new FestividadImpl("Abril", "Feria de Sevilla");
        Poblacion p1 = new PoblacionImpl("Sevilla", 1945000, 140.8, 1000000, 152014, f1);
        datosEmpresa("Manuel", p1);
        datosEmpresa("Rocio", p1);
    }

    public static void datosEmpresa(String cliente, Poblacion pob) {
        System.out.println("Datos del cliente");
        System.out.println("================");
        System.out.println();
        List<String> lc = new ArrayList<>();
        lc.add(cliente);
        System.out.println("Cliente: ");
        System.out.println(lc);

        if (pob.getNombre().equals("Sevilla")) {
            System.out.println(pob.getNumHabitantes());
        }
    }
}
