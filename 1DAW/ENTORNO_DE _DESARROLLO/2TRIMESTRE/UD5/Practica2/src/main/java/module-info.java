module org.example.practica2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.practica2 to javafx.fxml;
    exports org.example.practica2;
}