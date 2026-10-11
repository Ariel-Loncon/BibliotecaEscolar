package com.Biblioteca.model;
import java.sql.Date;

/**
 * Clase encargada de gestionar las clasificaciones de los libros y de los préstamos realizados
 */

public class Prestamo {
    //Atributos de la clase Prestamo
    private int id;
    private int idEstudiante;
    private int idLibro;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean devuelto;

    //Constructor vacío
    public Prestamo() {
    }

    /**
     *
     * @param id Número de identificación del préstamo
     * @param idEstudiante Número de identificación del estudiante que solicito el libro
     * @param idLibro Numero de identificación del libro prestado
     * @param fechaPrestamo Fecha de préstamo del libro
     * @param fechaDevolucion Fecha de devolución del libro
     * @param devuelto Indicador de estado, de las devoluciones del libro
     */

    //Constructor de Prestamo
    public Prestamo(int id, int idEstudiante, int idLibro, Date fechaPrestamo, Date fechaDevolucion, boolean devuelto) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idLibro = idLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = devuelto;
    }
    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
}
