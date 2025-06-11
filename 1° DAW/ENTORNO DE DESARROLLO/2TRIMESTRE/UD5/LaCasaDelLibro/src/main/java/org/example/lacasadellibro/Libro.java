package org.example.lacasadellibro;

import java.time.LocalDate;
import java.util.Objects;

public class Libro {
    private int id;
    private String autor;
    private String titulo;
    private String numeroEdicion;
    private String editorial;
    private String lugarPublicacion;
    private int numeroPaginas;
    private int stock;
    private Double pvp;
    private LocalDate anioPublicacion;
    private String isbn;
    private LocalDate anioEdicion;
    private String pasillo;

    public Libro() {
    }

    public Libro(int id, String autor, String titulo, String numeroEdicion, String editorial, String lugarPublicacion, int numeroPaginas, int stock, Double pvp, LocalDate anioPublicacion, String isbn, LocalDate anioEdicion, String pasillo) {
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
        this.anioEdicion = anioEdicion;
        this.pasillo = pasillo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(String numeroEdicion) {
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

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPvp() {
        return pvp;
    }

    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    public LocalDate getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(LocalDate anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(LocalDate anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public String getPasillo() {
        return pasillo;
    }

    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return id == libro.id && numeroPaginas == libro.numeroPaginas && stock == libro.stock && Objects.equals(autor, libro.autor) && Objects.equals(titulo, libro.titulo) && Objects.equals(numeroEdicion, libro.numeroEdicion) && Objects.equals(editorial, libro.editorial) && Objects.equals(lugarPublicacion, libro.lugarPublicacion) && Objects.equals(pvp, libro.pvp) && Objects.equals(anioPublicacion, libro.anioPublicacion) && Objects.equals(isbn, libro.isbn) && Objects.equals(anioEdicion, libro.anioEdicion) && Objects.equals(pasillo, libro.pasillo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autor, titulo, numeroEdicion, editorial, lugarPublicacion, numeroPaginas, stock, pvp, anioPublicacion, isbn, anioEdicion, pasillo);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
