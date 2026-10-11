package com.Biblioteca.controlador;

import com.Biblioteca.dao.UsuarioDAO;
import com.Biblioteca.model.Usuario;

/**
 * Clase encargada de gestionar a los usuarios en la base de datos,
 * siendo el intermediario entre la lógica y la interfaz Swing
 */

public class ControladorLogin {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Usuario autenticar(String correo, String contraseña) {
        if (correo == null || correo.trim().isEmpty() || contraseña == null || contraseña.trim().isEmpty()) {
            return null;
        }
        return usuarioDAO.validarLogin(correo, contraseña);
    }
}