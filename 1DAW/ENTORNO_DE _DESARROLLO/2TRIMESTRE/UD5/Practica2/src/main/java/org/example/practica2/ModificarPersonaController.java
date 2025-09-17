package org.example.practica2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificarPersonaController {
    @FXML
    private TextField inp_modificar_nombre;
    @FXML
    private TextField inp_modificar_apellidos;
    @FXML
    private TextField inp_modificar_edad;

    private TablaPersonasController tablaPersonasController;
    private Persona personaSeleccionada;

    public void setTablaPersonasController(TablaPersonasController controller) {
        this.tablaPersonasController = controller;
    }

    public void setPersonaSeleccionada(Persona persona) {
        this.personaSeleccionada = persona;
        inp_modificar_nombre.setText(persona.getNombre());
        inp_modificar_apellidos.setText(persona.getApellidos());
        inp_modificar_edad.setText(String.valueOf(persona.getEdad()));
    }

    @FXML
    public void onHandleGuardarCambios(ActionEvent event) {
        if (personaSeleccionada != null && tablaPersonasController != null) {
            personaSeleccionada.setNombre(inp_modificar_nombre.getText());
            personaSeleccionada.setApellidos(inp_modificar_apellidos.getText());
            personaSeleccionada.setEdad(Integer.parseInt(inp_modificar_edad.getText()));

            tablaPersonasController.actualizarTabla();

            cerrarModal(event);
        }
    }

    @FXML
    public void cerrarModal(ActionEvent event) {
        Stage stage = (Stage) inp_modificar_nombre.getScene().getWindow();
        stage.close();
    }
}