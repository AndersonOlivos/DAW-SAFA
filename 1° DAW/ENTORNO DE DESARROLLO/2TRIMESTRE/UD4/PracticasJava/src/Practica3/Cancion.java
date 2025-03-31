package Practica3;

import Practica2.Fecha;

public interface Cancion {

    public String getNombre();
    public String getInterprete();
    public Integer getDuracion();
    public Fecha getFechaLanzamiento();
    public String getGenero();
    public Integer getNumeroDeReproducciones();
    public void setNumeroDeReproducciones(Integer numeroDeReproducciones);
    public Double getCalificacion();
    public void setCalificacion(Double calificacion);
    public Boolean getReproducir();
    public void setReproducir(Boolean reproducir);
}
