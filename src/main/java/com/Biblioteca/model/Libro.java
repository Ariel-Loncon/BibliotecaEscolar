package com.Biblioteca.model;

/**
 * Clase que gestiona los libros de la biblioteca
 */
public class Libro {
    //Atributos de los libros
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;
    private int stock;
    private int idCategoria;
    //Constructor vacío
    public Libro() {
    }

    /**
     *
     * @param id Número de identificación del libro
     * @param titulo Titúlo del libro
     * @param autor Autor del libro
     * @param isbn Código de identificación único para libros (International Standar Book Number)
     * @param editorial Editorial del libro
     * @param stock Cantidad de unidades disponibles del libro
     * @param idCategoria Identificación de la categoria del libro
     */
    //Constructor de la clase libro
    public Libro(int id, String titulo, String autor, String isbn, String editorial, int stock, int idCategoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.stock = stock;
        this.idCategoria = idCategoria;


    }
    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
