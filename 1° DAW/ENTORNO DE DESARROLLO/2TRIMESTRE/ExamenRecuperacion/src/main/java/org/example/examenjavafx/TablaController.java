package org.example.examenjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TablaController {

    @FXML
    private TextField filtrarAutor;
    @FXML
    private TextField filtrarNombre;
    @FXML
    private TableView<Holocron> tabla;
    @FXML
    private TableColumn<Holocron, String> autor;
    @FXML
    private TableColumn<Holocron, String> titulo;
    @FXML
    private TableColumn<Holocron, Integer> numeroEdicion;
    @FXML
    private TableColumn<Holocron, String> editorial;
    @FXML
    private TableColumn<Holocron, String> lugarPublicacion;
    @FXML
    private TableColumn<Holocron, Integer> numeroPaginas;
    @FXML
    private TableColumn<Holocron, Integer> stock;
    @FXML
    private TableColumn<Holocron, Double> pvp;
    @FXML
    private TableColumn<Holocron, LocalDate> anioPublicacion;
    @FXML
    private TableColumn<Holocron, String> isbn;
    @FXML
    private TableColumn<Holocron, LocalDate> anioEdicion;
    @FXML
    private TableColumn<Holocron, String> pasillo;

    private ObservableList<Holocron> listaOriginalHolocrons = FXCollections.observableArrayList();

    public void initialize() {
        cargarTabla();
        filtrarAutor.textProperty().addListener((obs, old, nuevo) -> aplicarFiltros());
        filtrarNombre.textProperty().addListener((obs, old, nuevo) -> aplicarFiltros());
    }

    @FXML
    private void abrirVentanaAnadir(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("anadir.fxml"));
            Parent root = fxmlLoader.load();

            AnadirController anadirController = fxmlLoader.getController();
            anadirController.setTablaController(this);

            Stage stage = new Stage();
            stage.setTitle("Añadir Holocron");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarTabla() {

        autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        numeroEdicion.setCellValueFactory(new PropertyValueFactory<>("numeroEdicion"));
        editorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        lugarPublicacion.setCellValueFactory(new PropertyValueFactory<>("lugarPublicacion"));
        numeroPaginas.setCellValueFactory(new PropertyValueFactory<>("numeroPaginas"));
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        pvp.setCellValueFactory(new PropertyValueFactory<>("pvp"));
        anioPublicacion.setCellValueFactory(new PropertyValueFactory<>("anioPublicacion"));
        isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        anioEdicion.setCellValueFactory(new PropertyValueFactory<>("anioEdicion"));
        pasillo.setCellValueFactory(new PropertyValueFactory<>("pasillo"));

        ObservableList<Holocron> listaHolocrons = FXCollections.observableArrayList();

        Connection conn = ConexionBD.conectar();
        if (conn != null) {
            try {
                ResultSet rs = conn.createStatement().executeQuery("SELECT id" +
                        ", autor" +
                        ", titulo" +
                        ", numeroEdicion" +
                        ", editorial  " +
                        ", lugarPublicacion" +
                        ", numeroPaginas" +
                        ", stock  " +
                        ", pvp  " +
                        ", anioPublicacion  " +
                        ", isbn  " +
                        ", anioEdicion  " +
                        ", pasillo  " +
                        "FROM holocron ");
                while (rs.next()) {
                    Holocron s = new Holocron(
                            rs.getInt("id"),
                            rs.getString("autor"),
                            rs.getString("titulo"),
                            rs.getInt("numeroEdicion"),
                            rs.getString("editorial"),
                            rs.getString("lugarPublicacion"),
                            rs.getInt("numeroPaginas"),
                            rs.getInt("stock"),
                            rs.getDouble("pvp"),
                            rs.getDate("anioPublicacion").toLocalDate(),
                            rs.getString("isbn"),
                            rs.getDate("anioEdicion").toLocalDate(),
                            rs.getString("pasillo")
                    );
                    listaHolocrons.add(s);
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        tabla.setItems(listaHolocrons);
        tabla.refresh();
        listaOriginalHolocrons.setAll(listaHolocrons);
    }

    @FXML
    public void abrirVentanaEditar(ActionEvent event) {
        Holocron seleccionado = tabla.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("editar.fxml"));
                Parent root = loader.load();

                ModificarController modificarController = loader.getController();
                modificarController.setSeleccionado(seleccionado);
                modificarController.setTablaController(this);

                Stage stage = new Stage();
                stage.setTitle("Modificar Holocron");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Seleccione un registro");
            alert.showAndWait();
        }
    }

    public void recargarTabla() {
        cargarTabla();
    }

    @FXML
    public void aplicarFiltros() {
        String filtroAutor = filtrarAutor.getText().toLowerCase();
        String filtroNombre = filtrarNombre.getText().toLowerCase();

        // Filtramos primero por modelo
        List<Holocron> filtradoParcial = listaOriginalHolocrons.stream()
                .filter(holocron -> filtroAutor.isEmpty() ||
                        holocron.getAutor().toLowerCase().contains(filtroAutor))
                .collect(Collectors.toList());

        // Luego filtramos por tamaño
        List<Holocron> filtradoFinal = filtradoParcial.stream()
                .filter(holocron -> filtroNombre.isEmpty() ||
                        holocron.getTitulo().toLowerCase().contains(filtroNombre))
                .collect(Collectors.toList());

        // Actualizamos la tabla
        tabla.setItems(FXCollections.observableArrayList(filtradoFinal));
    }
}
