package org.example.practica4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TablaControlador {
    @FXML
    private ComboBox<String> combo_tabla_clientes;
    @FXML
    private TableView tabla_servicios;
    @FXML
    private TableColumn col_matricula;
    @FXML
    private TableColumn col_marca;
    @FXML
    private TableColumn col_precio;
    @FXML
    private TableColumn col_fecha_alquiler;
    @FXML
    private TableColumn col_fecha_entrega;
    @FXML
    private TableColumn col_total;

    public void initialize() {
        cargarComboboxCliente();
    }

    @FXML
    private void abrirVentanaAnadirServicio(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("servicios.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Añadir Servicio");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarComboboxCliente() {
        ObservableList<String> clientes = FXCollections.observableArrayList();

        Connection conn = Conexion.conectar();
        if (conn != null) {
            try {
                ResultSet rs = conn.createStatement().executeQuery("SELECT DISTINCT clientes.NyA FROM clientes, servicios WHERE clientes.NIF = servicios.nif_cliente");
                while (rs.next()) {
                    clientes.add(rs.getString("NyA"));
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        combo_tabla_clientes.setItems(clientes);
    }

    public void cargarTablaServicios() {

        col_matricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        col_marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        col_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        col_fecha_alquiler.setCellValueFactory(new PropertyValueFactory<>("fechaAlquiler"));
        col_fecha_entrega.setCellValueFactory(new PropertyValueFactory<>("fechaEntrega"));
        col_total.setCellValueFactory(new PropertyValueFactory<>("total"));

        ObservableList<Servicio> listaServicios = FXCollections.observableArrayList();

        Connection conn = Conexion.conectar();
        if (conn != null) {
            try {
                ResultSet rs = conn.createStatement().executeQuery("SELECT servicios.matricula_vehiculo" +
                        ", vehiculos.marca" +
                        ", vehiculos.precio" +
                        ", servicios.Total" +
                        ", servicios.fecha_alquiler" +
                        ", servicios.fecha_entrega  " +
                        "FROM servicios, vehiculos " +
                        "WHERE servicios.");
                while (rs.next()) {
                    Servicio s = new Servicio(
                            rs.getString("matricula_vehiculo"),
                            rs.getString("marca_vehiculo"),
                            rs.getInt("precio_vehiculo"),
                            rs.getInt("total_servicios"),
                            rs.getDate("fecha_alquiler").toLocalDate(),
                            rs.getDate("fecha_entrega").toLocalDate()

                    );
                    listaServicios.add(s);
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        tabla_servicios.setItems(listaServicios);
    }
}
