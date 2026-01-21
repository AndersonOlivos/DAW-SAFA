package org.example.practica2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TablaPersonasController {
    @FXML
    private TextField inp_nombre;
    @FXML
    private TextField inp_apellidos;
    @FXML
    private TextField inp_edad;
    @FXML
    private TableView<Persona> tabla_personas;
    @FXML
    private TableColumn<Persona, String> col_nombre;
    @FXML
    private TableColumn<Persona, String> col_apellidos;
    @FXML
    private TableColumn<Persona, Integer> col_edad;
    @FXML
    private Button btn_eliminar;
    @FXML
    private Button btn_modificar;
    @FXML
    private TextField inp_filtro_nombre; // Asegúrate de agregar este campo en tu FXML

    // Lista observable para almacenar personas
    private ObservableList<Persona> personas = FXCollections.observableArrayList(
            new Persona("Juan", "Fernandez", 25),
            new Persona("María", "Gilgado", 30)
    );

    private FilteredList<Persona> filteredPersonas;
    private SortedList<Persona> sortedPersonas;

    @FXML
    public void initialize() {
        // Configurar las columnas de la tabla (como ya tienes)
        col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col_apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        col_edad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        // Crear la lista filtrable
        filteredPersonas = new FilteredList<>(personas, p -> true);

        // Añadir esta parte para el ordenamiento
        sortedPersonas = new SortedList<>(filteredPersonas);
        sortedPersonas.comparatorProperty().bind(tabla_personas.comparatorProperty());

        // Enlazar la lista ordenada a la tabla (en lugar de la filtrada)
        tabla_personas.setItems(sortedPersonas);

        // Habilitar el ordenamiento en las columnas
        col_nombre.setSortable(true);
        col_apellidos.setSortable(true);
        col_edad.setSortable(true);
    }

    @FXML
    protected void filtrar_por_nombre() {
        String filtro = inp_filtro_nombre.getText().toLowerCase();

        filteredPersonas.setPredicate(persona -> {
            // Si el filtro está vacío, mostrar todas las personas
            if (filtro == null || filtro.isEmpty()) {
                return true;
            }
            // Comparar el nombre de la persona con el filtro
            return persona.getNombre().toLowerCase().contains(filtro);
        });
    }

    @FXML
    protected void onHandleAgregarPersona(String nombre, String apellidos, String edadTexto) {
        // Validar campos vacíos
        if (nombre.isEmpty() || apellidos.isEmpty() || edadTexto.isEmpty()) {
            mostrarAlertaError("Complete todos los campos, por favor.");
            return;
        }

        // Validar formato de edad
        int edad;
        try {
            edad = Integer.parseInt(edadTexto);
        } catch (NumberFormatException e) {
            mostrarAlertaError("La edad debe ser un número válido.");
            return;
        }

        // Validar si la persona ya existe
        if (existePersona(nombre)) {
            mostrarAlertaError("Ya existe una persona con ese nombre.");
            return;
        }

        // Agregar nueva persona a la lista observable
        personas.add(new Persona(nombre, apellidos, edad));
        mostrarAlertaInformacion("Se ha añadido correctamente.");
    }

    private boolean existePersona(String nombre) {
        return personas.stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    // Métodos auxiliares para mostrar alertas
    private void mostrarAlertaError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }

    private void mostrarAlertaInformacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }

    @FXML
    protected void eliminarPersona(ActionEvent event) {
        Persona selectedPersona = tabla_personas.getSelectionModel().getSelectedItem();
        if (selectedPersona != null) {
            personas.remove(selectedPersona);
            mostrarAlertaInformacion("Se ha eliminado correctamente");
        } else {
            mostrarAlertaError("Seleccione una persona para eliminar.");
        }
    }

    @FXML
    protected void onHandleModificarPersona() {
        Persona selectedPersona = tabla_personas.getSelectionModel().getSelectedItem();
        if (selectedPersona != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(ControlPersonasApplication.class.getResource("modificarPersona.fxml"));
                Parent root = fxmlLoader.load();

                ModificarPersonaController modificarController = fxmlLoader.getController();
                modificarController.setTablaPersonasController(this);
                modificarController.setPersonaSeleccionada(selectedPersona);

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
                mostrarAlertaError("No se pudo abrir la ventana de modificación");
            }
        } else {
            mostrarAlertaError("Seleccione una persona para modificar.");
        }
    }

    public void actualizarTabla() {
        tabla_personas.refresh();
    }

    public void modalAgregarPersona(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ControlPersonasApplication.class.getResource("controlPersonas.fxml"));
        Parent root = fxmlLoader.load();
        ControlPersonasController controlPersonasController = fxmlLoader.getController();
        controlPersonasController.setTablaPersonasController(this);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }
}