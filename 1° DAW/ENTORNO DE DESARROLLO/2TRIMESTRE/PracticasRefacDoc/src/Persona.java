/**
 * Clase persona utilizada en profesores
 * @author Anderson
 * @version 1.0
 */

public class Persona {
    String nombre;
    int edad;
    String numeroTelefono;

    public Persona(String nombre, int edad, String numeroTelefono) {
        super();
        this.nombre = nombre;
        this.edad = edad;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * metodo getter numeroTelefono
     * @return devuelve el num de tel, cuidado, en string
     */

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroDeTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}