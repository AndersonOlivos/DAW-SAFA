package org.example.examenjavafx;

import java.time.LocalDate;
import java.util.Objects;

public class Holocron {
    private Integer id;
    private String autor;
    private String titulo;
    private Integer numeroEdicion;
    private String editorial;
    private String lugarPublicacion;
    private Integer numeroPaginas;
    private Integer stock;
    private Double pvp;
    private LocalDate anioPublicacion;
    private String isbn;
    private LocalDate AnioEdicion;
    private String pasillo;


    public Holocron() {
    }

    public Holocron(Integer id, String autor, String titulo, Integer numeroEdicion, String editorial, String lugarPublicacion, Integer numeroPaginas, Integer stock, Double pvp, LocalDate anioPublicacion, String isbn, LocalDate anioEdicion, String pasillo) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.numeroEdicion = numeroEdicion;
        this.editorial = editorial;
        this.lugarPublicacion = lugarPublicacion;
        this.numeroPaginas = numeroPaginas;
        this.stock = stock;
        this.pvp = pvp;
        this.anioPublicacion = anioPublicacion;
        this.isbn = isbn;
        AnioEdicion = anioEdicion;
        this.pasillo = pasillo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(Integer numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getLugarPublicacion() {
        return lugarPublicacion;
    }

    public void setLugarPublicacion(String lugarPublicacion) {
        this.lugarPublicacion = lugarPublicacion;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPvp() {
        return pvp;
    }

    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPasillo() {
        return pasillo;
    }

    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }

    public LocalDate getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(LocalDate anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public LocalDate getAnioEdicion() {
        return AnioEdicion;
    }

    public void setAnioEdicion(LocalDate anioEdicion) {
        AnioEdicion = anioEdicion;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Holocron holocron = (Holocron) o;
        return Objects.equals(id, holocron.id) && Objects.equals(autor, holocron.autor) && Objects.equals(titulo, holocron.titulo) && Objects.equals(numeroEdicion, holocron.numeroEdicion) && Objects.equals(editorial, holocron.editorial) && Objects.equals(lugarPublicacion, holocron.lugarPublicacion) && Objects.equals(numeroPaginas, holocron.numeroPaginas) && Objects.equals(stock, holocron.stock) && Objects.equals(pvp, holocron.pvp) && Objects.equals(anioPublicacion, holocron.anioPublicacion) && Objects.equals(isbn, holocron.isbn) && Objects.equals(AnioEdicion, holocron.AnioEdicion) && Objects.equals(pasillo, holocron.pasillo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autor, titulo, numeroEdicion, editorial, lugarPublicacion, numeroPaginas, stock, pvp, anioPublicacion, isbn, AnioEdicion, pasillo);
    }

    @Override
    public String toString() {
        return "Holocron{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", numeroEdicion=" + numeroEdicion +
                ", editorial='" + editorial + '\'' +
                ", lugarPublicacion='" + lugarPublicacion + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", stock=" + stock +
                ", pvp=" + pvp +
                ", anioPublicacion=" + anioPublicacion +
                ", ISBN='" + isbn + '\'' +
                ", AnioEdicion=" + AnioEdicion +
                ", pasillo='" + pasillo + '\'' +
                '}';
    }
}
