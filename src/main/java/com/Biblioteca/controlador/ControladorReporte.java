package com.Biblioteca.controlador;

import com.Biblioteca.dao.PrestamoDAO;
import java.util.List;

/**
 * Clase encargada de gestionar los Reportes (informes del sistema),
 * siendo el intermediario entre la lógica y la interfaz Swing
 */

public class ControladorReporte {
    //Instancia de objeto que comunica mediante dao con la base de datos
    private PrestamoDAO dao = new PrestamoDAO();
    //Solicita al DAO el lsitado de los libros mas solicitados
    public List<String> getLibrosMasPrestados() {
        return dao.obtenerLibrosMasPrestados();
    }
    //Solicita mediante lista, los prestamos activos vigentes
    public List<String> getLibrosEnPrestamoActual() {
        return dao.obtenerLibrosEnPrestamo();
    }
}
