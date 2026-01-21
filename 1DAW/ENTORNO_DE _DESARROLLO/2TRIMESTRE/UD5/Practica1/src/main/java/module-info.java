module org.example.practica1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.practica1 to javafx.fxml;
    exports org.example.practica1;
}