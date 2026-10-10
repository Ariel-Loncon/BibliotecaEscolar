package com.Biblioteca.view;

import com.Biblioteca.controlador.EstudianteController;
import com.Biblioteca.model.Estudiante;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VistaEstudiante extends JFrame {
    private JTable tablaEstudiantes;
    private DefaultTableModel modeloTabla;
    private EstudianteController controller = new EstudianteController();

    public VistaEstudiante() {
        setTitle("Gestión de Estudiantes");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "RUT", "Curso", "Correo"}, 0);
        tablaEstudiantes = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaEstudiantes);
        scroll.setBounds(20, 20, 590, 310);
        add(scroll);

        List<Estudiante> lista = controller.obtenerEstudiantes();
        for (Estudiante e : lista) {
            modeloTabla.addRow(new Object[]{e.getId(), e.getNombre(), e.getRut(), e.getCurso(), e.getCorreo()});
        }
    }
}