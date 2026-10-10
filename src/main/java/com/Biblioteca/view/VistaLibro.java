package com.Biblioteca.view;

import com.Biblioteca.controlador.LibroController;
import com.Biblioteca.model.Libro;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VistaLibro extends JFrame {
    private JTable tablaLibros;
    private DefaultTableModel modeloTabla;
    private LibroController controller = new LibroController();
    private JTextField txtTitulo, txtAutor, txtIsbn, txtEditorial, txtStock, txtCat;

    public VistaLibro() {
        setTitle("Gestión de Libros");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Título", "Autor", "ISBN", "Stock"}, 0);
        tablaLibros = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaLibros);
        scroll.setBounds(20, 20, 430, 360);
        add(scroll);

        JButton btnCargar = new JButton("Actualizar Tabla");
        btnCargar.setBounds(480, 20, 170, 30);
        add(btnCargar);

        btnCargar.addActionListener(e -> cargarDatos());
        cargarDatos();
    }

    private void cargarDatos() {
        modeloTabla.setRowCount(0);
        List<Libro> lista = controller.obtenerLibros();
        for (Libro l : lista) {
            modeloTabla.addRow(new Object[]{l.getId(), l.getTitulo(), l.getAutor(), l.getIsbn(), l.getStock()});
        }
    }
}
