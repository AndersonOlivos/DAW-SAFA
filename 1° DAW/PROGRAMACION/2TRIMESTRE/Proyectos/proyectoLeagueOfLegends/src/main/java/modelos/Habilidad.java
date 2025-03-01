package modelos;

import java.util.Objects;

public class Habilidad {
    private int id;
    private String nombre;
    private Double danioBase;
    private Double danio;
    private Double costeMana;
    private TipoHabilidad tipoHabilidad;

    public Habilidad() {
    }

    public Habilidad(int id, String nombre, Double danioBase, Double danio, Double costeMana, TipoHabilidad tipoHabilidad) {
        this.id = id;
        this.nombre = nombre;
        this.danioBase = danioBase;
        this.danio = danio;
        this.costeMana = costeMana;
        this.tipoHabilidad = tipoHabilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDanioBase() {
        return danioBase;
    }

    public void setDanioBase(Double danioBase) {
        this.danioBase = danioBase;
    }

    public Double getDanio() {
        return danio;
    }

    public void setDanio(Double danio) {
        this.danio = danio;
    }

    public Double getCosteMana() {
        return costeMana;
    }

    public void setCosteMana(Double costeMana) {
        this.costeMana = costeMana;
    }

    public TipoHabilidad getTipoHabilidad() {
        return tipoHabilidad;
    }

    public void setTipoHabilidad(TipoHabilidad tipoHabilidad) {
        this.tipoHabilidad = tipoHabilidad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Habilidad habilidad = (Habilidad) o;
        return id == habilidad.id && Objects.equals(nombre, habilidad.nombre) && Objects.equals(danioBase, habilidad.danioBase) && Objects.equals(danio, habilidad.danio) && Objects.equals(costeMana, habilidad.costeMana) && tipoHabilidad == habilidad.tipoHabilidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, danioBase, danio, costeMana, tipoHabilidad);
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", danioBase=" + danioBase +
                ", danio=" + danio +
                ", costeMana=" + costeMana +
                ", tipoHabilidad=" + tipoHabilidad +
                '}';
    }
}
