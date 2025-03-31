package Practica3;
import Practica2.Fecha;

public class CancionImpl implements Cancion {
    private String nombre;
    private String interprete;
    private Integer duracion;
    private Fecha fechaLanzamiento;
    private String genero;
    private Integer numeroDeReproducciones;
    private Double calificacion;
    private Boolean reproducir;

    public CancionImpl() {
    }

    public CancionImpl(String nombre, String interprete) {
        this.nombre = nombre;
        this.interprete = interprete;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInterprete() {
        return interprete;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public Fecha getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getNumeroDeReproducciones() {
        return numeroDeReproducciones;
    }

    public void setNumeroDeReproducciones(Integer numeroDeReproducciones) {
        this.numeroDeReproducciones = numeroDeReproducciones;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Boolean getReproducir() {
        return reproducir;
    }

    public void setReproducir(Boolean reproducir) {
        this.reproducir = reproducir;
    }

    @Override
    public String toString() {
        return "[" + nombre + ", " + interprete + ']';
    }
}
