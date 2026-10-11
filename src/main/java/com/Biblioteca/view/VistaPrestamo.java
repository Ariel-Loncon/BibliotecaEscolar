package com.Biblioteca.view;

import com.Biblioteca.controlador.ControladorPrestamo;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.dao.EstudianteDAO;
import com.Biblioteca.model.Estudiante;
import javax.swing.*;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Interfaz de préstamos, permite ingresar préstamos a los estudiantes
 */

public class VistaPrestamo extends JFrame {
    private JTextField txtIdEstudiante, txtIdLibro;
    private JButton btnPrestar, btnVerDisponibles;
    private ControladorPrestamo controller = new ControladorPrestamo();
    private Usuario usuarioActual;

    public VistaPrestamo(Usuario usuario) {
        this.usuarioActual = usuario;
        setTitle("Registrar Préstamo - Biblioteca Escolar");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblEst = new JLabel("ID Estudiante:");
        lblEst.setBounds(30, 30, 100, 25);
        add(lblEst);

        txtIdEstudiante = new JTextField();
        txtIdEstudiante.setBounds(140, 30, 160, 25);
        add(txtIdEstudiante);

        // LÓGICA AUTOMÁTICA: Si entra un estudiante, autocompletamos su ID buscando por correo y bloqueamos el campo
        if (usuarioActual.getRol().equals("estudiante")) {
            autocompletarIdEstudiante();
            txtIdEstudiante.setEditable(false); // No puede cambiarlo, se pone solo
        }

        JLabel lblLibro = new JLabel("ID Libro:");
        lblLibro.setBounds(30, 70, 100, 25);
        add(lblLibro);

        txtIdLibro = new JTextField();
        txtIdLibro.setBounds(140, 70, 160, 25);
        add(txtIdLibro);

        // Botón exclusivo para ver libros disponibles (IDs y Stock)
        btnVerDisponibles = new JButton("Ver Libros Disponibles");
        btnVerDisponibles.setBounds(140, 110, 160, 25);
        add(btnVerDisponibles);

        btnPrestar = new JButton("Realizar Préstamo");
        btnPrestar.setBounds(140, 150, 160, 30);
        add(btnPrestar);

        // Acción del botón para ver libros con stock
        btnVerDisponibles.addActionListener(e -> {
            new VistaLibrosDisponibles().setVisible(true);
        });

        // Acción del botón prestar
        btnPrestar.addActionListener(e -> {
            try {
                int idEst = Integer.parseInt(txtIdEstudiante.getText());
                int idLib = Integer.parseInt(txtIdLibro.getText());
                Date fPrestamo = Date.valueOf(LocalDate.now());
                Date fDevolucion = Date.valueOf(LocalDate.now().plusDays(7));

                btnPrestar.setEnabled(false);

                controller.solicitarPrestamo(idEst, idLib, fPrestamo, fDevolucion, () -> {
                    btnPrestar.setEnabled(true);
                });

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese IDs numéricos válidos o verifique su registro.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Método auxiliar para buscar el ID del estudiante basado en el correo del usuario logueado
    private void autocompletarIdEstudiante() {
        EstudianteDAO estDao = new EstudianteDAO();
        for (Estudiante est : estDao.listarEstudiantes()) {
            if (est.getCorreo().equalsIgnoreCase(usuarioActual.getCorreo())) {
                txtIdEstudiante.setText(String.valueOf(est.getId()));
                break;
            }
        }
    }
}