package com.Biblioteca.dao;

import com.Biblioteca.conexion.DatabaseConnection;
import com.Biblioteca.model.Usuario;
import java.sql.*;

/**
 * Clase que interactúa con la base de datos, para gestionar los datos de los usuarios
 */
//Ejecuta consulta filtrando por correo y contraseña
public class UsuarioDAO {
    public Usuario validarLogin(String correo, String contraseña) {
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contraseña = ?";
        try (Connection con = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, correo); //Usuario en login
            pst.setString(2, contraseña); //Contraseña en login
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("rut"),
                            rs.getString("correo"),
                            rs.getString("contraseña"),
                            rs.getString("rol")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
