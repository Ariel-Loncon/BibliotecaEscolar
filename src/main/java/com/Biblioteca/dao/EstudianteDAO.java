package com.Biblioteca.dao;

import com.Biblioteca.conexion.DatabaseConnection;
import com.Biblioteca.model.Estudiante;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que interactúa con la base de datos, para gestionar los datos de los estudiantes
 */

public class EstudianteDAO {
    //Se ejecuta una consulta SQL SELECT Y FROM mapeandolo en un objeto "Estudiante" dentro de una lista
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";
        try (Connection con = DatabaseConnection.getInstance().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Estudiante(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("rut"),
                        rs.getString("curso"),
                        rs.getString("correo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    //Inserta los datos de nuevos estudiantes
    public boolean insertar(Estudiante e) {
        String sql = "INSERT INTO estudiantes (nombre, rut, curso, correo) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, e.getNombre());
            pst.setString(2, e.getRut());
            pst.setString(3, e.getCurso());
            pst.setString(4, e.getCorreo());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}