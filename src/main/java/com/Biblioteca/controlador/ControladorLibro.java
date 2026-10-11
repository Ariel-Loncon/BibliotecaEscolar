package com.Biblioteca.controlador;

import com.Biblioteca.dao.LibroDAO;
import com.Biblioteca.model.Libro;
import java.util.List;


/**
 * Clase encargada de gestionar los libros,
 * siendo el intermediario entre la lógica y la interfaz Swing
 */

public class ControladorLibro {
    //Instancia de objeto que comunica mediante dao con la base de datos
    private LibroDAO dao = new LibroDAO();
    //Metodo que ingresa a la lista todos lso datos almacenados de libro en el sistema
    public List<Libro> obtenerLibros() {
        return dao.listarLibros();
    }
    //Nueva instancia que recibe datos y las ingresa a base de datos
    public boolean registrarLibro(String titulo, String autor, String isbn, String editorial, int stock, int idCategoria) {
        Libro l = new Libro(0, titulo, autor, isbn, editorial, stock, idCategoria);
        return dao.insertar(l);
    }
}