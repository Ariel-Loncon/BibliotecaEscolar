package com.Biblioteca.controlador;

import com.Biblioteca.dao.PrestamoDAO;
import java.util.List;

public class ReporteController {
    private PrestamoDAO dao = new PrestamoDAO();

    public List<String> getLibrosMasPrestados() {
        return dao.obtenerLibrosMasPrestados();
    }

    public List<String> getLibrosEnPrestamoActual() {
        return dao.obtenerLibrosEnPrestamo();
    }
}
