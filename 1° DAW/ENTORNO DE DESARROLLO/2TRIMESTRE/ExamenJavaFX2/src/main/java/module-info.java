module org.example.examenjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.examenjavafx to javafx.fxml;
    exports org.example.examenjavafx;
}