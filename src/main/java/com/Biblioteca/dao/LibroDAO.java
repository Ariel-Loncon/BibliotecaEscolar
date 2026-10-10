package com.Biblioteca.dao;

import com.Biblioteca.conexion.DatabaseConnection;
import com.Biblioteca.model.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public List<Libro> listarLibros() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try (Connection con = DatabaseConnection.getInstance().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("isbn"),
                        rs.getString("editorial"),
                        rs.getInt("stock"),
                        rs.getInt("id_categoria")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insertar(Libro l) {
        String sql = "INSERT INTO libros (titulo, autor, isbn, editorial, stock, id_categoria) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, l.getTitulo());
            pst.setString(2, l.getAutor());
            pst.setString(3, l.getIsbn());
            pst.setString(4, l.getEditorial());
            pst.setInt(5, l.getStock());
            pst.setInt(6, l.getIdCategoria());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método sincronizado para evitar condiciones de carrera en concurrencia (requisito EFT)
    public synchronized boolean actualizarStockYPrestar(int idLibro, int idEstudiante, Date fechaPrestamo, Date fechaDevolucion) {
        String sqlStock = "SELECT stock FROM libros WHERE id = ?";
        String sqlUpdateStock = "UPDATE libros SET stock = stock - 1 WHERE id = ? AND stock > 0";
        String sqlPrestamo = "INSERT INTO prestamos (id_estudiante, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES (?, ?, ?, ?, FALSE)";

        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            con.setAutoCommit(false); // Transacción segura

            // 1. Verificar stock actual
            try (PreparedStatement pstCheck = con.prepareStatement(sqlStock)) {
                pstCheck.setInt(1, idLibro);
                try (ResultSet rs = pstCheck.executeQuery()) {
                    if (rs.next() && rs.getInt("stock") <= 0) {
                        con.rollback();
                        return false; // Sin stock
                    }
                }
            }

            // 2. Descontar stock
            try (PreparedStatement pstUpdate = con.prepareStatement(sqlUpdateStock)) {
                pstUpdate.setInt(1, idLibro);
                int filas = pstUpdate.executeUpdate();
                if (filas == 0) {
                    con.rollback();
                    return false;
                }
            }

            // 3. Registrar préstamo
            try (PreparedStatement pstPrestamo = con.prepareStatement(sqlPrestamo)) {
                pstPrestamo.setInt(1, idEstudiante);
                pstPrestamo.setInt(2, idLibro);
                pstPrestamo.setDate(3, fechaPrestamo);
                pstPrestamo.setDate(4, fechaDevolucion);
                pstPrestamo.executeUpdate();
            }

            con.commit();
            return true;
        } catch (SQLException e) {
            if (con != null) {
                try { con.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            e.printStackTrace();
            return false;
        } finally {
            if (con != null) {
                try { con.setAutoCommit(true); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }
}