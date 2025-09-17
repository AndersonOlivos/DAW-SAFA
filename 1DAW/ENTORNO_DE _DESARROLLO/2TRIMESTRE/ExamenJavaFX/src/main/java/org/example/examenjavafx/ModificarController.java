package org.example.examenjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class ModificarController {

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

    private Senuelo seleccionado;
    private TablaController tablaController;

    public Senuelo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Senuelo seleccionado) {
        this.seleccionado = seleccionado;
        cargarDatosSenuelo();
    }

    public TablaController getTablaController() {
        return tablaController;
    }

    public void setTablaController(TablaController tablaController) {
        this.tablaController = tablaController;
    }

    public void initialize() {
        cargarComboboxTamano();
    }

    public void cargarComboboxTamano() {
        ObservableList<String> tamanos = FXCollections.observableArrayList();

        for (TamanoSenuelo tamano : TamanoSenuelo.values()) {
            tamanos.add(tamano.toString());
        }

        combo_tamano.setItems(tamanos);
    }

    private void cargarDatosSenuelo() {
        inp_modelo.setText(seleccionado.getModelo());
        combo_tamano.setValue(seleccionado.getTamano());
        inp_color.setText(seleccionado.getColor());
        inp_navegabilidad.setText(seleccionado.getNavegabilidad());
        inp_ojos.setText(seleccionado.getOjos());
        inp_peso.setText(String.valueOf(seleccionado.getPeso()));
        inp_disponibilidad.setText(seleccionado.getDisponibilidad().toString());
        inp_pvp.setText(String.valueOf(seleccionado.getPvp()));
        inp_referencia.setText(seleccionado.getReferencia());
        inp_fecha_recepcion.setValue(seleccionado.getFecha_recepcion());
    }

    @FXML
    private void recogerDatosSenuelo(){
        seleccionado.setModelo(inp_modelo.getText());
        seleccionado.setTamano(combo_tamano.getValue());
        seleccionado.setColor(inp_color.getText());
        seleccionado.setOjos(inp_ojos.getText());
        seleccionado.setReferencia(inp_referencia.getText());
        seleccionado.setNavegabilidad(inp_navegabilidad.getText());
        seleccionado.setFecha_recepcion(inp_fecha_recepcion.getValue());
        seleccionado.setDisponibilidad(Boolean.valueOf(inp_disponibilidad.getText()));
        seleccionado.setPvp(Double.valueOf(inp_pvp.getText()));
        seleccionado.setPeso(Double.valueOf(inp_peso.getText()));
    }

    private void actualizarSenueloEnBD() {
        Connection conn = ConexionBD.conectar();
        if (conn != null) {
            try {
                String sql = "UPDATE senuelo SET modelo=?, color=?, ojos=?, referencia=?, " +
                        "tamano=?, navegabilidad=?, peso=?, disponibilidad=?, pvp=?, " +
                        "fecha_recepcion=? WHERE id=?";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, seleccionado.getModelo());
                pstmt.setString(2, seleccionado.getColor());
                pstmt.setString(3, seleccionado.getOjos());
                pstmt.setString(4, seleccionado.getReferencia());
                pstmt.setString(5, seleccionado.getTamano().toString());
                pstmt.setString(6, seleccionado.getNavegabilidad());
                pstmt.setDouble(7, seleccionado.getPeso());
                pstmt.setBoolean(8, seleccionado.getDisponibilidad());
                pstmt.setDouble(9, seleccionado.getPvp());
                pstmt.setDate(10, Date.valueOf(seleccionado.getFecha_recepcion()));
                pstmt.setInt(11, seleccionado.getId());

                pstmt.executeUpdate();
                conn.close();
                tablaController.recargarTablaSenuelo();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void modificar_senuelo(ActionEvent event) {
        if (seleccionado != null) {
            recogerDatosSenuelo();
            actualizarSenueloEnBD();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Senuelo modificado correctamente");
            alert.setTitle("Modificar Senuelo");
            alert.setHeaderText(null);
            alert.showAndWait();
            tablaController.recargarTablaSenuelo();
        } else {
            System.out.println("Seleccionado no encontrado");
        }
    }
}