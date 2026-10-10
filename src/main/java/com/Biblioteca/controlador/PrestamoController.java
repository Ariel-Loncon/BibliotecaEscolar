package com.Biblioteca.controlador;

import com.Biblioteca.hilos.PrestamoSincro;
import java.sql.Date;

public class PrestamoController {

    public void solicitarPrestamo(int idEstudiante, int idLibro, Date fPrestamo, Date fDevolucion, Runnable callbackRecargar) {
        PrestamoSincro tarea = new PrestamoSincro(idEstudiante, idLibro, fPrestamo, fDevolucion, callbackRecargar);
        Thread hiloPrestamo = new Thread(tarea);
        hiloPrestamo.start(); // Ejecución asíncrona sin congelar el JFrame
    }
}