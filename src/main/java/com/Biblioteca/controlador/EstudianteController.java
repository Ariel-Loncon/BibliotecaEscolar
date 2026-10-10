package com.Biblioteca.controlador;

import com.Biblioteca.dao.EstudianteDAO;
import com.Biblioteca.model.Estudiante;
import java.util.List;

public class EstudianteController {
    private EstudianteDAO dao = new EstudianteDAO();

    public List<Estudiante> obtenerEstudiantes() {
        return dao.listarEstudiantes();
    }

    public boolean registrarEstudiante(String nombre, String rut, String curso, String correo) {
        Estudiante e = new Estudiante(0, nombre, rut, curso, correo);
        return dao.insertar(e);
    }
}
