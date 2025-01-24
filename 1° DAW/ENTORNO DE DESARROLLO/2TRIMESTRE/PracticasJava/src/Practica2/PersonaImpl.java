package Practica2;

public class PersonaImpl implements Persona{

    private String nombre;
    private String apellidos;
    private String dni;
    private Integer edad;

    //CONSTRUCTOR

    public PersonaImpl(String nombre, String apellidos, String dni, Integer edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
    }

    //NOMBRE: consultable y modificable

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //APELLIDOS: consultable y modificable

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    //DNI: consultable

    public String getDni() {
        return dni;
    }

    //EDAD: consultable y modificable

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String toString() {
        return nombre + " " + apellidos + ", " + dni + ", " + edad + " años";
    }

}
