module org.example.practica4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.practica4 to javafx.fxml;
    exports org.example.practica4;
}