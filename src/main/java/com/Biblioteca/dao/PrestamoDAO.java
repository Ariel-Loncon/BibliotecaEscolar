package com.Biblioteca.dao;

import com.Biblioteca.conexion.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    public List<String> obtenerLibrosMasPrestados() {
        List<String> reporte = new ArrayList<>();
        String sql = "SELECT l.titulo, COUNT(p.id_libro) AS total " +
                "FROM prestamos p JOIN libros l ON p.id_libro = l.id " +
                "GROUP BY l.id, l.titulo ORDER BY total DESC LIMIT 5";
        try (Connection con = DatabaseConnection.getInstance().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                reporte.add(rs.getString("titulo") + " - Préstamos: " + rs.getInt("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reporte;
    }

    public List<String> obtenerLibrosEnPrestamo() {
        List<String> reporte = new ArrayList<>();
        String sql = "SELECT e.nombre AS estudiante, l.titulo, p.fecha_prestamo, p.fecha_devolucion " +
                "FROM prestamos p " +
                "JOIN estudiantes e ON p.id_estudiante = e.id " +
                "JOIN libros l ON p.id_libro = l.id " +
                "WHERE p.devuelto = FALSE";
        try (Connection con = DatabaseConnection.getInstance().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                reporte.add("Estudiante: " + rs.getString("estudiante") +
                        " | Libro: " + rs.getString("titulo") +
                        " | Vence: " + rs.getDate("fecha_devolucion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reporte;
    }
}
