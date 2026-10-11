package com.Biblioteca.view;

import com.Biblioteca.controlador.ControladorPrestamo;
import javax.swing.*;
import java.sql.Date;
import java.time.LocalDate;

public class VistaPrestamo extends JFrame {
    private JTextField txtIdEstudiante, txtIdLibro;
    private JButton btnPrestar;
    private ControladorPrestamo controller = new ControladorPrestamo();

    public VistaPrestamo() {
        setTitle("Registrar Préstamo (Concurrente)");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblEst = new JLabel("ID Estudiante:");
        lblEst.setBounds(30, 30, 100, 25);
        add(lblEst);

        txtIdEstudiante = new JTextField();
        txtIdEstudiante.setBounds(140, 30, 140, 25);
        add(txtIdEstudiante);

        JLabel lblLibro = new JLabel("ID Libro:");
        lblLibro.setBounds(30, 70, 100, 25);
        add(lblLibro);

        txtIdLibro = new JTextField();
        txtIdLibro.setBounds(140, 70, 140, 25);
        add(txtIdLibro);

        btnPrestar = new JButton("Realizar Préstamo");
        btnPrestar.setBounds(90, 130, 160, 30);
        add(btnPrestar);

        btnPrestar.addActionListener(e -> {
            try {
                int idEst = Integer.parseInt(txtIdEstudiante.getText());
                int idLib = Integer.parseInt(txtIdLibro.getText());
                Date fPrestamo = Date.valueOf(LocalDate.now());
                Date fDevolucion = Date.valueOf(LocalDate.now().plusDays(7));

                // Deshabilita el botón temporalmente para evidenciar la acción asíncrona
                btnPrestar.setEnabled(false);

                // Dispara el hilo en segundo plano (Requisito EFT)
                controller.solicitarPrestamo(idEst, idLib, fPrestamo, fDevolucion, () -> {
                    btnPrestar.setEnabled(true);
                });

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese IDs numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}