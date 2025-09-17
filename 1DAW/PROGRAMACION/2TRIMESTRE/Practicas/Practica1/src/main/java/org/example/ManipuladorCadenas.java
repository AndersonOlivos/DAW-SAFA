package org.example;

public class ManipuladorCadenas {

    public static String pasarAMinusculas(String cadena) {
        return cadena.toLowerCase();
    }

    public static String pasarAMayuscula(String cadena) {
        return cadena.toUpperCase();
    }

    public static String invertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int i = cadena.length()-1; i >= 0; i--) {
            cadenaInvertida += cadena.charAt(i);
        }
        return cadenaInvertida;
    }

    public static Integer contarVocales(String cadena) {
        Integer num_vocales = 0;
        cadena = pasarAMinusculas(cadena);
        String vocales = "aeiou";
        for (int i = 0; i < cadena.length(); i++) {
            for (int j = 0; j < vocales.length(); j++) {
                if (cadena.charAt(i) == vocales.charAt(j)) {
                    num_vocales++;
                }
            }
        }
        return num_vocales;
    }

    public static Integer contarVocal(String cadena, String vocal) {
        Integer num_vocal = 0;
        cadena = pasarAMinusculas(cadena);
        vocal = pasarAMinusculas(vocal);
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == vocal.charAt(0)) {
                num_vocal++;
            }
        }
        return num_vocal;
    }

    public static Integer contarConsonantes(String cadena) {
        Integer num_consonantes = 0;
        cadena = pasarAMinusculas(cadena);
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != 'a' && cadena.charAt(i) != 'e' && cadena.charAt(i) != 'i' && cadena.charAt(i) != 'o' && cadena.charAt(i) != 'u'){
                num_consonantes++;
            }
        }
        return num_consonantes;
    }

    public static String concatenarConSeparador(String cadena1, String separador, String cadena2) {
        return cadena1+separador+cadena2;
    }

    public static Boolean esPalindromo(String cadena) {
        cadena = cadena.trim();
        String cadena_invertida = invertirCadena( cadena );

        return cadena.equalsIgnoreCase(cadena_invertida);
    }

}
