package org.example.examenjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.SQLException;

public class AnadirController {

    @FXML
    private ComboBox<String> combo_tamano;
    @FXML
    private TextField inp_modelo;
    @FXML
    private TextField inp_color;
    @FXML
    private TextField inp_ojos;
    @FXML
    private TextField inp_referencia;
    @FXML
    private TextField inp_navegabilidad;
    @FXML
    private TextField inp_peso;
    @FXML
    private TextField inp_disponibilidad;
    @FXML
    private TextField inp_pvp;
    @FXML
    private DatePicker inp_fecha_recepcion;

    @FXML
    private TablaController tablaController;

    public TablaController getTablaController() {
        return tablaController;
    }

    public void setTablaController(TablaController tablaController) {
        this.tablaController = tablaController;
    }

    public void initialize() {
        cargarComboboxTamano();
    }

    public void guardar_senuelo(ActionEvent actionEvent) {

        Connection conn = ConexionBD.conectar();
        if (conn != null) {
            try {
                String sql = "INSERT INTO senuelo (modelo, tamano, color, navegabilidad, ojos, peso, disponibilidad, pvp, referencia, fecha_recepcion) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                var pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, inp_modelo.getText());
                pstmt.setString(2, combo_tamano.getValue());
                pstmt.setString(3, inp_color.getText());
                pstmt.setString(4, inp_navegabilidad.getText());
                pstmt.setString(5, inp_ojos.getText());
                pstmt.setDouble(6, Double.parseDouble(inp_peso.getText()));
                pstmt.setBoolean(7, Boolean.getBoolean(inp_disponibilidad.getText()));
                pstmt.setDouble(8, Double.parseDouble(inp_pvp.getText()));
                pstmt.setString(9, inp_referencia.getText());
                pstmt.setDate(10, java.sql.Date.valueOf(inp_fecha_recepcion.getValue()));

                pstmt.executeUpdate();

                conn.close();

                System.out.println("Senuelo guardado correctamente.");

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Senuelo guardado");
                alerta.setHeaderText(null);
                alerta.setContentText("Senuelo guardado correctamente.");
                alerta.showAndWait();

                tablaController.recargarTablaSenuelo();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public void cargarComboboxTamano() {
        ObservableList<String> tamanos = FXCollections.observableArrayList();

        for (TamanoSenuelo tamano : TamanoSenuelo.values()) {
            tamanos.add(tamano.toString());
        }

        combo_tamano.setItems(tamanos);
    }
}