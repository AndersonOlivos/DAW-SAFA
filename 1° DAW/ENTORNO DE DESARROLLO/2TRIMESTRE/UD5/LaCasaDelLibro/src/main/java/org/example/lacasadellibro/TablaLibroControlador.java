package org.example.lacasadellibro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TablaLibroControlador {

    @FXML
    private TableView<Libro> tabla_libros;
    @FXML
    private TableColumn<Libro, String> col_autor;
    @FXML
    private TableColumn<Libro, String> col_titulo;
    @FXML
    private TableColumn<Libro, String> col_numero_edicion;
    @FXML
    private TableColumn<Libro, String> col_editorial;
    @FXML
    private TableColumn<Libro, String> col_lugar_publicacion;
    @FXML
    private TableColumn<Libro, String> col_numero_paginas;
    @FXML
    private TableColumn<Libro, String> col_stock;
    @FXML
    private TableColumn<Libro, String> col_pvp;
    @FXML
    private TableColumn<Libro, String> col_anio_publicacion;
    @FXML
    private TableColumn<Libro, String> col_isbn;
    @FXML
    private TableColumn<Libro, String> col_anio_edicion;
    @FXML
    private TableColumn<Libro, String> col_pasillo;

    private ObservableList<Libro> listaOriginalLibros = FXCollections.observableArrayList();


    public void initialize() {
        cargarDatosBD();
    }

    @FXML
    private void abrirVentanaAnadirLibro(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("anadirLibro.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Añadir Libro");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDatosBD (){
        Connection conexion = Conexion.conectar();

        col_autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        col_titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        col_numero_edicion.setCellValueFactory(new PropertyValueFactory<>("numeroEdicion"));
        col_editorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        col_lugar_publicacion.setCellValueFactory(new PropertyValueFactory<>("lugarPublicacion"));
        col_numero_paginas.setCellValueFactory(new PropertyValueFactory<>("numeroPaginas"));
        col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        col_pvp.setCellValueFactory(new PropertyValueFactory<>("pvp"));
        col_anio_publicacion.setCellValueFactory(new PropertyValueFactory<>("anioPublicacion"));
        col_isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        col_anio_edicion.setCellValueFactory(new PropertyValueFactory<>("anioEdicion"));
        col_pasillo.setCellValueFactory(new PropertyValueFactory<>("pasillo"));


        ObservableList<Libro> listaLibros = FXCollections.observableArrayList();

        try{
            ResultSet rs = conexion.createStatement().executeQuery("SELECT id, autor, titulo, numero_edicion, editorial, lugar_publicacion, numero_paginas, stock, pvp, anio_publicacion, isbn, anio_edicion, pasillo FROM libro");
            while(rs.next()){
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setAutor(rs.getString("autor"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setNumeroEdicion(rs.getString("numero_edicion"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setLugarPublicacion(rs.getString("lugar_publicacion"));
                libro.setNumeroPaginas(rs.getInt("numero_paginas"));
                libro.setStock(rs.getInt("stock"));
                libro.setPvp(rs.getDouble("pvp"));
                libro.setAnioPublicacion(rs.getDate("anio_publicacion").toLocalDate());
                libro.setIsbn(rs.getString("isbn"));
                libro.setAnioEdicion(rs.getDate("anio_edicion").toLocalDate());
                libro.setPasillo(rs.getString("pasillo"));

                listaLibros.add(libro);
            }

            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tabla_libros.setItems(listaLibros);
        listaOriginalLibros.setAll(listaLibros);
    }

}
