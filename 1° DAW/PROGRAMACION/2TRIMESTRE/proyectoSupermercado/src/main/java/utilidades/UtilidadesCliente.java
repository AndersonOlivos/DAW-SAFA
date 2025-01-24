package utilidades;
import modelos.Cliente;



public class UtilidadesCliente {

    public boolean esDniValido(Cliente cliente){
        String dni = cliente.getDni();
        boolean totalCaracteres;
        boolean numeros = true;
        boolean letra;

        totalCaracteres = dni.length() == 9;

        for (Integer i = 0; i < dni.length()-1; i++) {
            if( !(Character.isDigit(dni.charAt(i))) ){
                numeros = false;
                break;
            }
        }

        letra = Character.isLetter(dni.charAt(dni.length()-1));

        return totalCaracteres && numeros && letra;
    }

}
