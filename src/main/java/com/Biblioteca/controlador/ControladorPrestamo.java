package com.Biblioteca.controlador;

import com.Biblioteca.hilos.PrestamoSincro;
import java.sql.Date;

/**
 * Clase encargada de gestionar los préstamos,
 * siendo el intermediario entre la lógica y la interfaz Swing
 */

public class ControladorPrestamo {

    public void solicitarPrestamo(int idEstudiante, int idLibro, Date fPrestamo, Date fDevolucion, Runnable callbackRecargar) {
        PrestamoSincro tarea = new PrestamoSincro(idEstudiante, idLibro, fPrestamo, fDevolucion, callbackRecargar);
        Thread hiloPrestamo = new Thread(tarea);
        hiloPrestamo.start(); // Ejecución asíncrona sin congelar el JFrame
    }
}