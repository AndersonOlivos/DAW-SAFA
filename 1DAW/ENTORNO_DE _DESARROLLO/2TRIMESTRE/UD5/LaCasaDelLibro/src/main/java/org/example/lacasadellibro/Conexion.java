package org.example.lacasadellibro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/libros";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "usuario";

    public static Connection conectar() {
        try {
            System.out.println("Conectado a la base de datos");
            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}