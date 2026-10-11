package com.Biblioteca.controlador;

import com.Biblioteca.dao.UsuarioDAO;
import com.Biblioteca.model.Usuario;

/**
 * Clase encargada de gestionar a los usuarios en la base de datos,
 * siendo el intermediario entre la lógica y la interfaz Swing
 */

public class ControladorLogin {
    //Instancia de objeto que comunica mediante dao con la base de datos
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    //Verifica las credenciales de los usuarios
    public Usuario autenticar(String correo, String contraseña) {
        //Validador de correo y contraseña, que no este vacío o nulo
        if (correo == null || correo.trim().isEmpty() || contraseña == null || contraseña.trim().isEmpty()) {
            return null;
        }
        return usuarioDAO.validarLogin(correo, contraseña);
    }
}