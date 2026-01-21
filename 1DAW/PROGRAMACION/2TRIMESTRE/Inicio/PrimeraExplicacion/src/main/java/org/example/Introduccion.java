package org.example;

public class Introduccion {

    //main -> abreviatura para correr el fichero
    public static void main(String[] args) {

        //sout -> abreviatura para imprimir por consola
        System.out.println("Hola Mundo!");

        // TIPOS DE DATOS EN JAVA //
        // Java es tipado


        //Variables numéricas

        //Enteros
        int num1 = 1;
        System.out.println(num1);

        //int vs Integer: Integer es un tipo creado por Java con el que se puede usar funciones
        Integer num2 = 2;

        //También existe short y long pero no son tan usadas, la diferencia es el tamaño de byts

        //Decimales

        double numDecimal = 3.14;

        System.out.println(numDecimal);

        //También existe float

        // TEXTO //
        //Tenemos que utilizar el tipado String para trabajar con cadenas
        
        String texto = "Hola Mundo!";
        char letra = 'h';
        System.out.println(letra);

        // BOOL //

        Boolean afirmacion = true;
        boolean negacion = false;

    }
}
