package org.example;

import io.javalin.Javalin;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        app.get("/mesas", ctx -> {
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SaboresDeCasa", "root", "root123")) {

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Mesa");

                StringBuilder resultado = new StringBuilder();
                while (rs.next()) {
                    resultado.append(rs.getInt("ID_MESA"))
                            .append(" - ").append(rs.getString("ESTADO"))
                            .append("\n");
                }

                ctx.result(resultado.toString());

            } catch (SQLException e) {
                ctx.result("Error: " + e.getMessage());
            }
        });

        app.get("/pedidos", ctx -> {
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SaboresDeCasa", "root", "root123")) {

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Pedido");

                StringBuilder resultado = new StringBuilder();
                while (rs.next()) {
                    resultado.append("PEDIDO ").append(rs.getInt("ID_PEDIDO"))
                            .append(" - CLIENTE ").append(rs.getString("CLIENTE"))
                            .append(" - ").append("MESA ").append(rs.getString("ID_MESA"))
                            .append("\n");
                }

                ctx.result(resultado.toString());

            } catch (SQLException e) {
                ctx.result("Error: " + e.getMessage());
            }
        });

        app.get("/pedido/{id}", ctx -> {

            String idPedido = ctx.pathParam("id");

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SaboresDeCasa", "root", "root123")) {

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT SUM(CANTIDAD* PRECIO) AS TOTAL_PEDIDO" +
                        " FROM Linea_Pedido lp, Pedido p, Producto pr WHERE lp.ID_PEDIDO = p.ID_PEDIDO AND lp.ID_PRODUCTO = pr.ID_PRODUCTO" +
                        " AND p.ID_PEDIDO =" + idPedido + ";");

                StringBuilder resultado = new StringBuilder();
                while (rs.next()) {
                    resultado.append("TOTAL PEDIDO: ").append(rs.getDouble("TOTAL_PEDIDO")).append("€");
                }

                ctx.result(resultado.toString());

            } catch (SQLException e) {
                ctx.result("Error: " + e.getMessage());
            }
        });

        app.get("/platos_vendidos", ctx -> {
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SaboresDeCasa", "root", "root123")) {

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT DESCRIPCION, CANTIDAD AS VENDIDO FROM Linea_Pedido lp , Producto p WHERE lp.ID_PRODUCTO = p.ID_PRODUCTO GROUP BY DESCRIPCION ORDER BY VENDIDO DESC;");

                StringBuilder resultado = new StringBuilder();
                while (rs.next()) {
                    resultado.append(rs.getString("DESCRIPCION"))
                            .append(" - ").append(rs.getString("VENDIDO"))
                            .append("\n");
                }

                ctx.result(resultado.toString());

            } catch (SQLException e) {
                ctx.result("Error: " + e.getMessage());
            }
        });

        app.get("/cliente_oferta", ctx -> {
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SaboresDeCasa", "root", "root123")) {

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT p.CLIENTE, pr.DESCRIPCION  , lp.CANTIDAD " +
                        "FROM Pedido p " +
                        "JOIN Linea_Pedido lp ON lp.ID_PEDIDO = p.ID_PEDIDO " +
                        "JOIN Producto pr ON lp.ID_PRODUCTO = pr.ID_PRODUCTO " +
                        "WHERE lp.CANTIDAD = (" +
                        "    SELECT MIN(lp2.CANTIDAD)" +
                        "    FROM Pedido p2" +
                        "    JOIN Linea_Pedido lp2 ON lp2.ID_PEDIDO = p2.ID_PEDIDO" +
                        "    WHERE p2.CLIENTE = p.CLIENTE" +
                        ") GROUP BY CLIENTE;");

                StringBuilder resultado = new StringBuilder();
                while (rs.next()) {
                    resultado.append(rs.getString("CLIENTE"))
                            .append(" - ").append(rs.getString("DESCRIPCION"))
                            .append(" - ").append(rs.getString("CANTIDAD"))
                            .append("\n");
                }

                ctx.result(resultado.toString());

            } catch (SQLException e) {
                ctx.result("Error: " + e.getMessage());
            }
        });

    }
}
