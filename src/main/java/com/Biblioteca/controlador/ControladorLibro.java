package com.Biblioteca.controlador;

import com.Biblioteca.dao.LibroDAO;
import com.Biblioteca.model.Libro;
import java.util.List;


/**
 * Clase encargada de gestionar los libros,
 * siendo el intermediario entre la lógica y la interfaz Swing
 */

public class ControladorLibro {
    private LibroDAO dao = new LibroDAO();

    public List<Libro> obtenerLibros() {
        return dao.listarLibros();
    }

    public boolean registrarLibro(String titulo, String autor, String isbn, String editorial, int stock, int idCategoria) {
        Libro l = new Libro(0, titulo, autor, isbn, editorial, stock, idCategoria);
        return dao.insertar(l);
    }
}