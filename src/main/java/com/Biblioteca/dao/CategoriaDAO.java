package com.Biblioteca.dao;

import com.Biblioteca.conexion.DatabaseConnection;
import com.Biblioteca.model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que interactúa con la base de datos, para gestionar los datos las categoria
 * para la clasificación de los libros
 */

public class CategoriaDAO {
    //Se conecta a la base de datos y transforma cada registro en un objeto de tipo Categoria
    public List<Categoria> listarCategorias() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try (Connection con = DatabaseConnection.getInstance().getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Categoria(
                        rs.getInt("id"),
                        rs.getString("nombre")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
