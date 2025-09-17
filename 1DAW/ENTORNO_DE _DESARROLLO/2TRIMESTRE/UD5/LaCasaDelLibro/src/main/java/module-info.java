module org.example.lacasadellibro {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.lacasadellibro to javafx.fxml;
    exports org.example.lacasadellibro;
}