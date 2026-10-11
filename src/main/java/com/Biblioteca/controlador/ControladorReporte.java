package com.Biblioteca.controlador;

import com.Biblioteca.dao.PrestamoDAO;
import java.util.List;

/**
 * Clase encargada de gestionar los Reportes (informes del sistema),
 * siendo el intermediario entre la lógica y la interfaz Swing
 */

public class ControladorReporte {
    private PrestamoDAO dao = new PrestamoDAO();

    public List<String> getLibrosMasPrestados() {
        return dao.obtenerLibrosMasPrestados();
    }

    public List<String> getLibrosEnPrestamoActual() {
        return dao.obtenerLibrosEnPrestamo();
    }
}
