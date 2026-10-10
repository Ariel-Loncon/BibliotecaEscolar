package com.Biblioteca.hilos;

import com.Biblioteca.dao.LibroDAO;
import javax.swing.*;
import java.sql.Date;

public class PrestamoSincro implements Runnable {
    private int idEstudiante;
    private int idLibro;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Runnable onCompleteCallback;

    public PrestamoSincro(int idEstudiante, int idLibro, Date fechaPrestamo, Date fechaDevolucion, Runnable onCompleteCallback) {
        this.idEstudiante = idEstudiante;
        this.idLibro = idLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.onCompleteCallback = onCompleteCallback;
    }

    @Override
    public void run() {
        LibroDAO dao = new LibroDAO();
        boolean exito = dao.actualizarStockYPrestar(idLibro, idEstudiante, fechaPrestamo, fechaDevolucion);

        // Actualizar la interfaz gráfica de forma segura en el hilo de eventos de Swing (EDT)
        SwingUtilities.invokeLater(() -> {
            if (exito) {
                JOptionPane.showMessageDialog(null, "¡Préstamo registrado exitosamente en segundo plano!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: No hay stock disponible o falló la transacción.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (onCompleteCallback != null) {
                onCompleteCallback.run();
            }
        });
    }
}
