package Practica5;

import java.util.Objects;

public class PokemonImpl implements Pokemon {

    private Integer numero;
    private String nombre;
    private String descripcion;
    private Double altura;
    private Double peso;
    private Genero genero;
    private String tipo;

    public PokemonImpl() {
    }

    public PokemonImpl(Integer numero, String nombre, String descripcion, Double altura, Double peso, Genero genero, String tipo) {
        this.numero = numero;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PokemonImpl pokemon = (PokemonImpl) o;
        return Objects.equals(numero, pokemon.numero) && Objects.equals(nombre, pokemon.nombre) && Objects.equals(descripcion, pokemon.descripcion) && Objects.equals(altura, pokemon.altura) && Objects.equals(peso, pokemon.peso) && genero == pokemon.genero && Objects.equals(tipo, pokemon.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, nombre, descripcion, altura, peso, genero, tipo);
    }

    @Override
    public String toString() {
        return "Nº " + numero + " - " + nombre + " - " + descripcion +
                "\nAltura: " + altura + "m" +
                "\nPeso: " + peso + "kg" +
                "\nSexo: " + genero +
                "\nTipo: " + tipo ;
    }
}
