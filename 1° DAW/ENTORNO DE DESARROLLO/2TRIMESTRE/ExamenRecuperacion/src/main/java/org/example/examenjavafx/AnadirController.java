package org.example.examenjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnadirController {

    @FXML
    private TextField autor;
    @FXML
    private TextField numeroEdicion;
    @FXML
    private TextField lugarPublicacion;
    @FXML
    private DatePicker anioPublicacion;
    @FXML
    private DatePicker anioEdicion;
    @FXML
    private TextField titulo;
    @FXML
    private TextField editorial;
    @FXML
    private TextField numeroPaginas;
    @FXML
    private TextField stock;
    @FXML
    private TextField pvp;
    @FXML
    private TextField isbn;
    @FXML
    private ComboBox pasillo;

    @FXML
    private TablaController tablaController;

    Holocron holocron = new Holocron();

    public TablaController getTablaController() {
        return tablaController;
    }

    public void setTablaController(TablaController tablaController) {
        this.tablaController = tablaController;
    }

    public void initialize() {
        cargarComboboxPasillo();
    }

    @FXML
    private void recogerDatosSenuelo(){
        holocron.setAutor(autor.getText());
        holocron.setNumeroEdicion(Integer.parseInt(numeroEdicion.getText()));
        holocron.setLugarPublicacion(lugarPublicacion.getText());
        holocron.setAnioPublicacion(anioPublicacion.getValue());
        holocron.setAnioEdicion(anioEdicion.getValue());
        holocron.setTitulo(titulo.getText());
        holocron.setEditorial(editorial.getText());
        holocron.setNumeroPaginas(Integer.parseInt(numeroPaginas.getText()));
        holocron.setStock(Integer.parseInt(stock.getText()));
        holocron.setPvp(Double.parseDouble(pvp.getText()));
        holocron.setIsbn(isbn.getText());
        holocron.setPasillo(pasillo.getValue().toString());
    }

    public void anadir(ActionEvent actionEvent) {
        recogerDatosSenuelo();
        Connection conn = ConexionBD.conectar();
        if (conn != null) {
            try {
                String sql = "INSERT INTO holocron (autor, numeroEdicion, lugarPublicacion, anioPublicacion, anioEdicion" +
                        ", titulo, editorial, numeroPaginas," +
                        " stock, pvp, isbn, pasillo) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                var pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, holocron.getAutor());
                pstmt.setInt(2, holocron.getNumeroEdicion());
                pstmt.setString(3, holocron.getLugarPublicacion());
                pstmt.setDate(4, Date.valueOf(holocron.getAnioPublicacion()));
                pstmt.setDate(5, Date.valueOf(holocron.getAnioEdicion()));
                pstmt.setString(6, holocron.getTitulo());
                pstmt.setString(7, holocron.getEditorial());
                pstmt.setInt(8, holocron.getNumeroPaginas());
                pstmt.setInt(9, holocron.getStock());
                pstmt.setDouble(10, holocron.getPvp());
                pstmt.setString(11, holocron.getIsbn());
                pstmt.setString(12, holocron.getPasillo());

                pstmt.executeUpdate();

                conn.close();

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Holocron guardado");
                alerta.setHeaderText(null);
                alerta.setContentText("Holocron guardado correctamente.");
                alerta.showAndWait();

                tablaController.recargarTabla();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public void cargarComboboxPasillo() {
        ObservableList<String> pasillos = FXCollections.observableArrayList();

        Connection conn = ConexionBD.conectar();
        if (conn != null) {
            try {
                ResultSet rs = conn.createStatement().executeQuery("SELECT DISTINCT pasillo from holocron");

                while (rs.next()) {
                    pasillos.add(rs.getString("pasillo"));
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        pasillo.setItems(pasillos);
    }
}