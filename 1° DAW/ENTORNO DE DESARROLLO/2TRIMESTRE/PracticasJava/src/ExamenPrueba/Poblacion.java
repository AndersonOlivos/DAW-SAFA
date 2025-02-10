package ExamenPrueba;

public interface Poblacion {
    public Integer getNumeroHabitantes();
    public void setNumeroHabitantes(Integer numeroHabitantes);
    public Double getSuperficie();
    public Integer getPersonasTrabajando();
    public void setPersonasTrabajando(Integer personasTrabajando);
    public Integer getNumPersonasEmpleadas();
    public void setNumPersonasEmpleadas(Integer numPersonasEmpleadas);
    public Festivo getFestividades();
    public void setFestividades(Festivo festividades);
    public Double calcularPorcentajeDesempleo();
    public Double calcularDensidadPoblacion();
}
