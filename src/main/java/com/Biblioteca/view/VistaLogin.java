package com.Biblioteca.view;

import com.Biblioteca.controlador.ControladorLogin; // Importar el controlador
import com.Biblioteca.model.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Pantalla inició, primera ventana que hace el filtro según el tipo de usuario
 */

public class VistaLogin extends JFrame {
    private JTextField txtCorreo;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;
    private ControladorLogin controladorLogin = new ControladorLogin(); // Instanciar el controlador

    public VistaLogin() {
        setTitle("Biblioteca Escolar - Iniciar Sesión");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(30, 30, 80, 25);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(120, 30, 160, 25);
        add(txtCorreo);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(30, 70, 80, 25);
        add(lblPass);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(120, 70, 160, 25);
        add(txtContrasena);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(120, 120, 100, 30);
        add(btnIngresar);

        btnIngresar.addActionListener((ActionEvent e) -> {
            String correo = txtCorreo.getText();
            String pass = new String(txtContrasena.getPassword());

            // Usando el Controlador en lugar del DAO (Cumple con MVC)
            Usuario u = controladorLogin.autenticar(correo, pass);

            if (u != null) {
                JOptionPane.showMessageDialog(this, "Bienvenido " + u.getNombre() + " (" + u.getRol() + ")");
                new VistaMenuPrincipal(u).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}