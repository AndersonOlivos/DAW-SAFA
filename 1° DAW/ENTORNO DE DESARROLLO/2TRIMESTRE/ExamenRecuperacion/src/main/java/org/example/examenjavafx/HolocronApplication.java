package org.example.examenjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HolocronApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HolocronApplication.class.getResource("tabla.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Mi Tienda De Pesca");
        stage.setScene(scene);
        stage.show();
        ConexionBD conexion = new ConexionBD();
        try {
            conexion.conectar();
            System.out.println("conectado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}