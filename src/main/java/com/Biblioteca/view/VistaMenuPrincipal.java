package com.Biblioteca.view;

import com.Biblioteca.model.Usuario;
import javax.swing.*;

/**
 * Panel de navegación, varía según el usuario, limitando algunas funciones
 */

public class VistaMenuPrincipal extends JFrame {
    private Usuario usuarioActual;

    public VistaMenuPrincipal(Usuario usuario) {
        this.usuarioActual = usuario;
        setTitle("Menú Principal - Biblioteca Escolar (" + usuario.getRol() + ")");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Saludo y rol
        JLabel lblBienvenida = new JLabel("Bienvenido/a, " + usuario.getNombre() + " (" + usuario.getRol() + ")");
        lblBienvenida.setBounds(30, 20, 380, 25);
        add(lblBienvenida);

        // Botón Gestión de Libros
        JButton btnLibros = new JButton("Gestión de Libros");
        btnLibros.setBounds(30, 70, 200, 35);
        add(btnLibros);

        // Botón Gestión de Estudiantes
        JButton btnEstudiantes = new JButton("Gestión de Estudiantes");
        btnEstudiantes.setBounds(30, 120, 200, 35);
        add(btnEstudiantes);

        // Botón Préstamos y Devoluciones
        JButton btnPrestamos = new JButton("Realizar Préstamo");
        btnPrestamos.setBounds(30, 170, 200, 35);
        add(btnPrestamos);

        // Botón Reportes
        JButton btnReportes = new JButton("Ver Reportes");
        btnReportes.setBounds(30, 220, 200, 35);
        add(btnReportes);

        // Botón para cerrar sesión y volver al Login
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setBounds(30, 270, 200, 35); // Ajusta la posición según tu diseño
        add(btnCerrarSesion);

        // Restricciones según el rol
        if (usuario.getRol().equals("estudiante")) {
            // El estudiante solo tiene acceso a préstamo y consulta, no gestiona inventario total
            btnLibros.setEnabled(false);
            btnEstudiantes.setEnabled(false);
        }

        // --- ACCIONES DE LOS BOTONES (NAVEGACIÓN) ---

        btnLibros.addActionListener(e -> {
            new VistaLibro().setVisible(true);
        });

        btnEstudiantes.addActionListener(e -> {
            new VistaEstudiante().setVisible(true);
        });

        btnPrestamos.addActionListener(e -> {
            new VistaPrestamo().setVisible(true);
        });

        btnReportes.addActionListener(e -> {
            new VistaReportes().setVisible(true);
        });

        btnCerrarSesion.addActionListener(e -> {
            // 1. Mostrar la ventana de Login nuevamente
            new VistaLogin().setVisible(true);
            // 2. Cerrar y destruir la ventana actual del Menú Principal
            this.dispose();
        });
    }
}