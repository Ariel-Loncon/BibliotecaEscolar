package com.Biblioteca.controlador;

import com.Biblioteca.dao.PrestamoDAO;
import java.util.List;

public class ControladorReporte {
    private PrestamoDAO dao = new PrestamoDAO();

    public List<String> getLibrosMasPrestados() {
        return dao.obtenerLibrosMasPrestados();
    }

    public List<String> getLibrosEnPrestamoActual() {
        return dao.obtenerLibrosEnPrestamo();
    }
}
