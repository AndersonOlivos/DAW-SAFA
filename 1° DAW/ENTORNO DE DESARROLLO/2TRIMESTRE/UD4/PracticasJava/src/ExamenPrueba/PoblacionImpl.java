package ExamenPrueba;

import java.util.Objects;

public class PoblacionImpl implements Poblacion {
    private String nombre;
    private Integer numeroHabitantes;
    private Double superficie;
    private Integer personasTrabajando;
    private Integer numPersonasEmpleadas;
    private Festivo festividades;

    public PoblacionImpl() {
    }

    public PoblacionImpl(String nombre, Integer numeroHabitantes, Double superficie, Integer personasTrabajando, Integer numPersonasEmpleadas, Festivo festividades) {
        this.nombre = nombre;
        this.numeroHabitantes = numeroHabitantes;
        this.superficie = superficie;
        this.personasTrabajando = personasTrabajando;
        this.numPersonasEmpleadas = numPersonasEmpleadas;
        this.festividades = festividades;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNumeroHabitantes(Integer numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public Integer getPersonasTrabajando() {
        return personasTrabajando;
    }

    public void setPersonasTrabajando(Integer personasTrabajando) {
        this.personasTrabajando = personasTrabajando;
    }

    public Integer getNumPersonasEmpleadas() {
        return numPersonasEmpleadas;
    }

    public void setNumPersonasEmpleadas(Integer numPersonasEmpleadas) {
        this.numPersonasEmpleadas = numPersonasEmpleadas;
    }

    public Festivo getFestividades() {
        return festividades;
    }

    public void setFestividades(Festivo festividades) {
        this.festividades = festividades;
    }

    public Double calcularPorcentajeDesempleo(){
        return (numeroHabitantes - personasTrabajando)/100.0;
    }

    public Double calcularDensidadPoblacion(){
        return numeroHabitantes/superficie;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PoblacionImpl poblacion = (PoblacionImpl) o;
        return Objects.equals(nombre, poblacion.nombre) && Objects.equals(numeroHabitantes, poblacion.numeroHabitantes) && Objects.equals(superficie, poblacion.superficie) && Objects.equals(personasTrabajando, poblacion.personasTrabajando) && Objects.equals(numPersonasEmpleadas, poblacion.numPersonasEmpleadas) && Objects.equals(festividades, poblacion.festividades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, numeroHabitantes, superficie, personasTrabajando, numPersonasEmpleadas, festividades);
    }

    public String toString(){
        return nombre + " posee una densidad de población de " + String.format("%.2f", calcularDensidadPoblacion()) +
                " hab/km2. Una de sus fiestas más famosas es " +
                festividades;
    }
}
