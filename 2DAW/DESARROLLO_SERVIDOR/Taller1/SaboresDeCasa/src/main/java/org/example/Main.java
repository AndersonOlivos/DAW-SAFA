package org.example;

import io.javalin.Javalin;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        app.get("/usuarios", ctx -> {
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SaboresDeCasa", "root", "root123")) {

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Mesa");

                StringBuilder resultado = new StringBuilder();
                while (rs.next()) {
                    resultado.append(rs.getInt("ID_MESA"))
                            .append(" - ")
                            .append(rs.getString("ESTADO"))
                            .append("\n");
                }

                ctx.result(resultado.toString());

            } catch (SQLException e) {
                ctx.result("Error: " + e.getMessage());
            }
        });
    }
}
