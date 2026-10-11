package com.Biblioteca.controlador;

import com.Biblioteca.dao.EstudianteDAO;
import com.Biblioteca.model.Estudiante;
import java.util.List;

/**
 * Clase encargada de gestionar a los estudiantes,
 * siendo el intermediario entre la lógica y la interfaz Swing
 */

public class ControladorEstudiante {
    //Instancia de objeto que comunica mediante dao con la base de datos
    private EstudianteDAO dao = new EstudianteDAO();
    //Mediante lista se obtiene por DAo la lista completa de estudiante
    public List<Estudiante> obtenerEstudiantes() {
        return dao.listarEstudiantes();
    }
    //Se construye el objeto Estudiante y llama a Dao para su registro
    public boolean registrarEstudiante(String nombre, String rut, String curso, String correo) {
        Estudiante e = new Estudiante(0, nombre, rut, curso, correo);
        return dao.insertar(e);
    }
}
