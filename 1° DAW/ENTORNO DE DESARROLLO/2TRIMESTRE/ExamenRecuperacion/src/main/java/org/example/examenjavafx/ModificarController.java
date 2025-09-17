package org.example.examenjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

public class ModificarController {

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


    private Holocron seleccionado;
    private TablaController tablaController;

    public Holocron getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Holocron seleccionado) {
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
        cargarComboboxPasillo();
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

    private void cargarDatosSenuelo() {
        autor.setText(seleccionado.getAutor());
        numeroEdicion.setText(seleccionado.getNumeroEdicion().toString());
        lugarPublicacion.setText(seleccionado.getLugarPublicacion().toString());
        anioPublicacion.setValue(seleccionado.getAnioPublicacion());
        anioEdicion.setValue(seleccionado.getAnioEdicion());
        titulo.setText(seleccionado.getTitulo());
        editorial.setText(seleccionado.getEditorial());
        numeroPaginas.setText(seleccionado.getNumeroEdicion().toString());
        stock.setText(seleccionado.getStock().toString());
        pvp.setText(seleccionado.getPvp().toString());
        isbn.setText(seleccionado.getIsbn());
        pasillo.setValue(seleccionado.getPasillo());
    }

    @FXML
    private void recogerDatosSenuelo(){
        seleccionado.setAutor(autor.getText());
        seleccionado.setNumeroEdicion(Integer.parseInt(numeroEdicion.getText()));
        seleccionado.setLugarPublicacion(lugarPublicacion.getText());
        seleccionado.setAnioPublicacion(anioPublicacion.getValue());
        seleccionado.setAnioEdicion(anioEdicion.getValue());
        seleccionado.setTitulo(titulo.getText());
        seleccionado.setEditorial(editorial.getText());
        seleccionado.setNumeroPaginas(Integer.parseInt(numeroPaginas.getText()));
        seleccionado.setStock(Integer.parseInt(stock.getText()));
        seleccionado.setPvp(Double.parseDouble(pvp.getText()));
        seleccionado.setIsbn(isbn.getText());
        seleccionado.setPasillo(pasillo.getValue().toString());
    }

    private void actualizarHolocronBD() {
        Connection conn = ConexionBD.conectar();
        if (conn != null) {
            try {
                String sql = "UPDATE holocron SET autor=?, numeroEdicion=?, lugarPublicacion=?, anioPublicacion=?, " +
                        "anioEdicion=?, titulo=?, editorial=?, numeroPaginas=?, stock=?, " +
                        "pvp=?, isbn=?, pasillo=? WHERE id=?";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, seleccionado.getAutor());
                pstmt.setInt(2, seleccionado.getNumeroEdicion());
                pstmt.setString(3, seleccionado.getLugarPublicacion());
                pstmt.setDate(4, Date.valueOf(seleccionado.getAnioPublicacion()));
                pstmt.setDate(5, Date.valueOf(seleccionado.getAnioEdicion()));
                pstmt.setString(6, seleccionado.getTitulo());
                pstmt.setString(7, seleccionado.getEditorial());
                pstmt.setInt(8, seleccionado.getNumeroPaginas());
                pstmt.setInt(9, seleccionado.getStock());
                pstmt.setDouble(10, seleccionado.getPvp());
                pstmt.setString(11, seleccionado.getIsbn());
                pstmt.setString(12, seleccionado.getPasillo());
                pstmt.setInt(13, seleccionado.getId());

                pstmt.executeUpdate();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void modificar(ActionEvent event) {
        if (seleccionado != null) {
            recogerDatosSenuelo();
            actualizarHolocronBD();
            tablaController.recargarTabla();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Holocron modificado correctamente");
            alert.setTitle("Modificar Holocron");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            System.out.println("Seleccionado no encontrado");
        }
    }
}