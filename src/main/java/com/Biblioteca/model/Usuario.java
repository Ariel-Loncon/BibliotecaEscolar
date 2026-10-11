package com.Biblioteca.model;

/**
 * Clase que representa al usuario previamente registrado
 */

public class Usuario {
    //Atributos de usuario
    private int id;
    private String nombre;
    private String rut;
    private String correo;
    private String contraseña;
    private String rol;

    //Constructor vacío
    public Usuario() {
    }
    /**
     *
     * @param id Numero identificador del usuario
     * @param nombre Nombre de usuario
     * @param rut Rol único tributario del usuario
     * @param correo Correo electrónico del usuario
     * @param contraseña Contraseña de la cuanta del usuario
     * @param rol Quien es 'Bibliotecario o estudiante'
     */
    //Constructor
    public Usuario(int id, String nombre, String rut, String correo, String contraseña, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
    }
    //Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
