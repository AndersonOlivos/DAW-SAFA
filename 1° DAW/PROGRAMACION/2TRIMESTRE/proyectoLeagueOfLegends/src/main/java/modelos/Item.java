package modelos;

import java.util.Objects;

public class Item {
    private int id;
    private String nombre;
    private Double aumentoDanio;
    private Double aumentoDefensa;
    private Double aumentoSalud;
    private Double aumentoMana;

    public Item() {
    }

    public Item(int id, String nombre, Double aumentoDanio, Double aumentoDefensa, Double aumentoSalud, Double aumentoMana) {
        this.id = id;
        this.nombre = nombre;
        this.aumentoDanio = aumentoDanio;
        this.aumentoDefensa = aumentoDefensa;
        this.aumentoSalud = aumentoSalud;
        this.aumentoMana = aumentoMana;
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

    public Double getAumentoDanio() {
        return aumentoDanio;
    }

    public void setAumentoDanio(Double aumentoDanio) {
        this.aumentoDanio = aumentoDanio;
    }

    public Double getAumentoDefensa() {
        return aumentoDefensa;
    }

    public void setAumentoDefensa(Double aumentoDefensa) {
        this.aumentoDefensa = aumentoDefensa;
    }

    public Double getAumentoSalud() {
        return aumentoSalud;
    }

    public void setAumentoSalud(Double aumentoSalud) {
        this.aumentoSalud = aumentoSalud;
    }

    public Double getAumentoMana() {
        return aumentoMana;
    }

    public void setAumentoMana(Double aumentoMana) {
        this.aumentoMana = aumentoMana;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Objects.equals(nombre, item.nombre) && Objects.equals(aumentoDanio, item.aumentoDanio) && Objects.equals(aumentoDefensa, item.aumentoDefensa) && Objects.equals(aumentoSalud, item.aumentoSalud) && Objects.equals(aumentoMana, item.aumentoMana);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, aumentoDanio, aumentoDefensa, aumentoSalud, aumentoMana);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
