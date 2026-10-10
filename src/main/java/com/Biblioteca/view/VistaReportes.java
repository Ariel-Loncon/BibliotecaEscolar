package com.Biblioteca.view;

import com.Biblioteca.controlador.ReporteController;
import javax.swing.*;
import java.util.List;

public class VistaReportes extends JFrame {
    private JTextArea txtAreaReporte;
    private ReporteController controller = new ReporteController();

    public VistaReportes() {
        setTitle("Reportes del Sistema");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        txtAreaReporte = new JTextArea();
        txtAreaReporte.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtAreaReporte);
        scroll.setBounds(20, 60, 440, 280);
        add(scroll);

        JButton btnMasPrestados = new JButton("Top Libros Prestados");
        btnMasPrestados.setBounds(20, 20, 210, 30);
        add(btnMasPrestados);

        JButton btnEnCurso = new JButton("Préstamos Activos");
        btnEnCurso.setBounds(240, 20, 220, 30);
        add(btnEnCurso);

        btnMasPrestados.addActionListener(e -> {
            txtAreaReporte.setText("--- LIBROS MÁS PRESTADOS ---\n\n");
            List<String> reporte = controller.getLibrosMasPrestados();
            for (String linea : reporte) {
                txtAreaReporte.append(linea + "\n");
            }
        });

        btnEnCurso.addActionListener(e -> {
            txtAreaReporte.setText("--- LISTADO DE LIBROS EN PRÉSTAMO ---\n\n");
            List<String> reporte = controller.getLibrosEnPrestamoActual();
            for (String linea : reporte) {
                txtAreaReporte.append(linea + "\n");
            }
        });
    }
}