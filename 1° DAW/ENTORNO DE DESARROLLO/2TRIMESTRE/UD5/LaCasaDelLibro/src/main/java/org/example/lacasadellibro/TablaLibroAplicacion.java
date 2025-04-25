package org.example.lacasadellibro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import org.example.lacasadellibro.Conexion;

public class TablaLibroAplicacion extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TablaLibroControlador.class.getResource("tablaLibro.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Libros");
        stage.setScene(scene);
        stage.show();
        Conexion conexion = new Conexion();
        conexion.conectar();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
