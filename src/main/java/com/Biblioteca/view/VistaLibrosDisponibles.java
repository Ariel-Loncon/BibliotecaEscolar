package com.Biblioteca.view;

import com.Biblioteca.controlador.ControladorLibro;
import com.Biblioteca.model.Libro;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VistaLibrosDisponibles extends JFrame {
    private JTable tablaLibros;
    private DefaultTableModel modeloTabla;
    private ControladorLibro controller = new ControladorLibro();

    public VistaLibrosDisponibles() {
        setTitle("Libros Disponibles con Stock");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Título", "Autor", "Stock Disponibles"}, 0);
        tablaLibros = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaLibros);
        scroll.setBounds(20, 20, 440, 260);
        add(scroll);

        // Cargar únicamente libros que tengan stock mayor a 0
        List<Libro> lista = controller.obtenerLibros();
        for (Libro l : lista) {
            if (l.getStock() > 0) {
                modeloTabla.addRow(new Object[]{l.getId(), l.getTitulo(), l.getAutor(), l.getStock()});
            }
        }
    }
}