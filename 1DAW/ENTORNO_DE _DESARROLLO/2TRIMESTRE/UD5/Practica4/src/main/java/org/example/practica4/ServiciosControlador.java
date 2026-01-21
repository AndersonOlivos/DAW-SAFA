package org.example.practica4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;

import static java.lang.Math.abs;

public class ServiciosControlador {
    @FXML
    private ComboBox<String> combo_vehiculo;
    @FXML
    private ComboBox<String> combo_cliente;
    @FXML
    private TextField inp_descripcion;
    @FXML
    private TextField inp_marca;
    @FXML
    private TextField inp_km;
    @FXML
    private TextField inp_precio;
    @FXML
    private TextField inp_nif;
    @FXML
    private TextField inp_direccion;
    @FXML
    private TextField inp_poblacion;
    @FXML
    private DatePicker inp_fecha_alquiler;
    @FXML
    private DatePicker inp_fecha_entrega;
    @FXML
    private TextField inp_total_servicio;

    @FXML
    public void initialize() {
        cargarComboboxVehiculo();
        cargarComboboxCliente();
        detectarCambioComboboxVehiculo();
        detectarCambioComboboxCliente();
        detectarCambioDatePickers();
    }

    public void cargarComboboxVehiculo() {
        ObservableList<String> vehiculos = FXCollections.observableArrayList();

        Connection conn = Conexion.conectar();
        if (conn != null) {
            try {
                ResultSet rs = conn.createStatement().executeQuery("SELECT matricula FROM vehiculos");

                while (rs.next()) {
                    vehiculos.add(rs.getString("matricula"));
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        combo_vehiculo.setItems(vehiculos);
    }
    public void cargarComboboxCliente() {
        ObservableList<String> clientes = FXCollections.observableArrayList();

        Connection conn = Conexion.conectar();
        if (conn != null) {
            try {
                ResultSet rs = conn.createStatement().executeQuery("SELECT NyA FROM clientes");
                while (rs.next()) {
                    clientes.add(rs.getString("NyA"));
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        combo_cliente.setItems(clientes);
    }
    public void detectarCambioComboboxVehiculo(){
        combo_vehiculo.valueProperty().addListener((obs, oldValue, newValue) -> {

        Connection conn = Conexion.conectar();

            if (conn != null) {
                try {
                    // Usamos la matrícula seleccionada para filtrar
                    String sql = "SELECT * FROM vehiculos WHERE matricula = '" + newValue + "'";
                    ResultSet rs = conn.createStatement().executeQuery(sql);

                    if (rs.next()) {
                        inp_descripcion.setText(rs.getString("descripcion"));
                        inp_marca.setText(rs.getString("marca"));
                        inp_km.setText(String.valueOf(rs.getInt("kilometros")));
                        inp_precio.setText(String.valueOf(rs.getInt("precio")));
                    }

                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            calcularDiferenciaDias();

        });
    }
    public void detectarCambioComboboxCliente(){
        combo_cliente.valueProperty().addListener((obs, oldValue, newValue) -> {

            Connection conn = Conexion.conectar();

            if (conn != null) {
                try {
                    // Usamos la matrícula seleccionada para filtrar
                    String sql = "SELECT * FROM clientes WHERE NyA = '" + newValue + "'";
                    ResultSet rs = conn.createStatement().executeQuery(sql);

                    if (rs.next()) {
                        inp_nif.setText(rs.getString("NIF"));
                        inp_direccion.setText(rs.getString("Direcion"));
                        inp_poblacion.setText(rs.getString("Poblacion"));
                    }

                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            calcularDiferenciaDias();

        });
    }
    public void detectarCambioDatePickers(){
        inp_fecha_alquiler.valueProperty().addListener((obs, oldValue, newValue) -> {
            calcularDiferenciaDias();
        });
        inp_fecha_entrega.valueProperty().addListener((obs, oldValue, newValue) -> {
            calcularDiferenciaDias();
        });
    }
    public void calcularDiferenciaDias(){
        if(inp_fecha_alquiler.getValue() != null && inp_fecha_entrega.getValue() != null && inp_precio.getText() != null){
            inp_total_servicio.setText(String.valueOf(abs(ChronoUnit.DAYS.between(inp_fecha_alquiler.getValue(), inp_fecha_entrega.getValue())) * Integer.parseInt(inp_precio.getText())));
        }
    }
    public void grabarServicio(){
        if(combo_cliente.getValue() != null
                && combo_vehiculo.getValue() != null
                && inp_fecha_entrega.getValue() != null
                && inp_fecha_alquiler.getValue() != null
                && inp_total_servicio.getText() != null
                && !inp_total_servicio.getText().isEmpty()) {

            Connection conn = Conexion.conectar();
            if (conn != null) {
                try {
                    String sql = "INSERT INTO servicios (matricula_vehiculo, nif_cliente, fecha_alquiler, fecha_entrega, Total) " +
                            "VALUES (?, ?, ?, ?, ?)";

                    var pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, combo_vehiculo.getValue());
                    pstmt.setString(2, inp_nif.getText());
                    pstmt.setDate(3, java.sql.Date.valueOf(inp_fecha_alquiler.getValue()));
                    pstmt.setDate(4, java.sql.Date.valueOf(inp_fecha_entrega.getValue()));
                    pstmt.setDouble(5, Integer.parseInt(inp_total_servicio.getText()));

                    pstmt.executeUpdate();

                    conn.close();

                    System.out.println("Servicio guardado correctamente.");

                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Servicio guardado");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Servicio guardado correctamente.");
                    alerta.showAndWait();

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    System.err.println("Error: el total del servicio no es un número válido.");
                }
            }
        }
    }
}