package org.example.practica2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlPersonasController {
    @FXML
    public TextField inp_agregar_apellidos;
    @FXML
    private TextField inp_agregar_nombre;
    @FXML
    private TextField inp_agregar_edad;
    private TablaPersonasController tablaPersonasController;

    public void setTablaPersonasController(TablaPersonasController controller) {
        this.tablaPersonasController = controller;
    }

    public void onHandleAgregarPersona(ActionEvent actionEvent) {
        if (tablaPersonasController != null) {
            tablaPersonasController.onHandleAgregarPersona(
                    inp_agregar_nombre.getText(),
                    inp_agregar_apellidos.getText(),
                    inp_agregar_edad.getText()
            );

            // Limpiar los campos del modal
            inp_agregar_nombre.clear();
            inp_agregar_apellidos.clear();
            inp_agregar_edad.clear();

            // Cerrar el modal después de agregar
            Stage stage = (Stage) inp_agregar_nombre.getScene().getWindow();
            stage.close();
        }
    }

    public void cerrarModalAnadirPersona(ActionEvent actionEvent) {
        Stage stage = (Stage) inp_agregar_nombre.getScene().getWindow();
        stage.close();
    }
}
