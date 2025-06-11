package org.example.examenjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
    private ComboBox<String> combo_filtrar_tamano;
    @FXML
    private TableView<Senuelo> tabla_senuelo;
    @FXML
    private TableColumn<Senuelo, String> col_modelo;
    @FXML
    private TableColumn<Senuelo, TamanoSenuelo> col_tamano;
    @FXML
    private TableColumn<Senuelo, String> col_color;
    @FXML
    private TableColumn<Senuelo, String> col_navegabilidad;
    @FXML
    private TableColumn<Senuelo, String> col_ojos;
    @FXML
    private TableColumn<Senuelo, Double> col_peso;
    @FXML
    private TableColumn<Senuelo, Boolean> col_disponibilidad;
    @FXML
    private TableColumn<Senuelo, Double> col_pvp;
    @FXML
    private TableColumn<Senuelo, String> col_referencia;
    @FXML
    private TableColumn<Senuelo, LocalDate> col_fecha_recepcion;
    @FXML
    private TextField inp_filtrar_modelo;

    private ObservableList<Senuelo> listaOriginalSenuelos = FXCollections.observableArrayList();

    public void initialize() {
        cargarComboboxTamano();
        cargarTablaSenuelo();
        inp_filtrar_modelo.textProperty().addListener((obs, old, nuevo) -> aplicarFiltros());
        combo_filtrar_tamano.valueProperty().addListener((obs, old, nuevo) -> aplicarFiltros());
    }

    @FXML
    private void abrirVentanaAnadirSenuelo(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("anadir.fxml"));
            Parent root = fxmlLoader.load();

            AnadirController anadirController = fxmlLoader.getController();
            anadirController.setTablaController(this);

            Stage stage = new Stage();
            stage.setTitle("Añadir Servicio");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarComboboxTamano() {
        ObservableList<String> tamanos = FXCollections.observableArrayList();

        for (TamanoSenuelo tamano : TamanoSenuelo.values()) {
            tamanos.add(tamano.toString());
        }

        tamanos.add("");
        combo_filtrar_tamano.setItems(tamanos);
    }

    public void cargarTablaSenuelo() {

        col_modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        col_peso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        col_pvp.setCellValueFactory(new PropertyValueFactory<>("pvp"));
        col_color.setCellValueFactory(new PropertyValueFactory<>("color"));
        col_disponibilidad.setCellValueFactory(new PropertyValueFactory<>("disponibilidad"));
        col_tamano.setCellValueFactory(new PropertyValueFactory<>("tamano"));
        col_navegabilidad.setCellValueFactory(new PropertyValueFactory<>("navegabilidad"));
        col_ojos.setCellValueFactory(new PropertyValueFactory<>("ojos"));
        col_referencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));
        col_fecha_recepcion.setCellValueFactory(new PropertyValueFactory<>("fecha_recepcion"));

        ObservableList<Senuelo> listaSenuelos = FXCollections.observableArrayList();

        Connection conn = ConexionBD.conectar();
        if (conn != null) {
            try {
                ResultSet rs = conn.createStatement().executeQuery("SELECT id" +
                        ", modelo" +
                        ", color" +
                        ", ojos" +
                        ", referencia  " +
                        ", tamano" +
                        ", navegabilidad" +
                        ", peso  " +
                        ", disponibilidad  " +
                        ", pvp  " +
                        ", fecha_recepcion  " +
                        "FROM senuelo ");
                while (rs.next()) {
                    Senuelo s = new Senuelo(
                            rs.getInt("id"),
                            rs.getString("modelo"),
                            rs.getString("color"),
                            rs.getString("ojos"),
                            rs.getString("referencia"),
                            rs.getString("tamano"),
                            rs.getString("navegabilidad"),
                            rs.getDouble("peso"),
                            rs.getBoolean("disponibilidad"),
                            rs.getDouble("pvp"),
                            rs.getDate("fecha_recepcion").toLocalDate()
                    );
                    listaSenuelos.add(s);
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        tabla_senuelo.setItems(listaSenuelos);
        listaOriginalSenuelos.setAll(listaSenuelos);
    }

    @FXML
    public void modificarSenuelo(ActionEvent event) {
        Senuelo seleccionado = tabla_senuelo.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("editar.fxml"));
                Parent root = loader.load();

                ModificarController modificarController = loader.getController();
                modificarController.setSeleccionado(seleccionado);
                modificarController.setTablaController(this);

                Stage stage = new Stage();
                stage.setTitle("Modificar Señuelo");
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

    public void recargarTablaSenuelo() {
        cargarTablaSenuelo();
    }

    @FXML
    public void aplicarFiltros() {
        String filtroModelo = inp_filtrar_modelo.getText().toLowerCase();
        String filtroTamano = combo_filtrar_tamano.getValue() != null ?
                combo_filtrar_tamano.getValue().toLowerCase() : "";

        // Filtramos primero por modelo
        List<Senuelo> filtradoParcial = listaOriginalSenuelos.stream()
                .filter(s -> filtroModelo.isEmpty() ||
                        s.getModelo().toLowerCase().contains(filtroModelo))
                .collect(Collectors.toList());

        // Luego filtramos por tamaño
        List<Senuelo> resultadoFinal = filtradoParcial.stream()
                .filter(s -> filtroTamano.isEmpty() ||
                        s.getTamano().toLowerCase().contains(filtroTamano))
                .collect(Collectors.toList());

        // Actualizamos la tabla
        tabla_senuelo.setItems(FXCollections.observableArrayList(resultadoFinal));
    }
}
