package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Metodo minusculas

        System.out.println("Metodo minusculas: " + ManipuladorCadenas.pasarAMinusculas("HOLA BUENAS TARDES"));

        //Metodo mayusculas

        System.out.println("Metodo mayusculas: " + ManipuladorCadenas.pasarAMayuscula("hola buenas tardes"));

        //Metodo invertir cadena

        System.out.println("Metodo invertir cadena: " + ManipuladorCadenas.invertirCadena("palabra"));

        //Metodo contar vocales

        System.out.println("Metodo contar vocales: " + ManipuladorCadenas.contarVocales("HOLA BUENAS TARDES"));

        //Metodo concatenar con separador

        System.out.println("Metodo concatenar con separador: " + ManipuladorCadenas.concatenarConSeparador("HOLA","-","BUENAS TARDES"));

        //Metodo palindromo

        System.out.println("Metodo palindromo: " + ManipuladorCadenas.esPalindromo("ATA"));

        //Metodo contador vocal

        System.out.println("Metodo contador vocal: " + ManipuladorCadenas.contarVocal("HOLA BUENAS TARDES", "a"));

        //Metodo contador consonantes

        System.out.println("Metodo contador consonantes: " + ManipuladorCadenas.contarConsonantes("HOLA BUENAS TARDES"));

    }
}