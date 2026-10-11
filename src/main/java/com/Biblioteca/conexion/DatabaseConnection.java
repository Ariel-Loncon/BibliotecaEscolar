package com.Biblioteca.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que administra la conexion con la base de datos MySQL
 * aplicando patrón Singleton para asegurar una única instancia activa
 */

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CLAVE = "SWIER34ref3Dr34GT5dfq";
    private static DatabaseConnection instance;
    private Connection conexion;


    private DatabaseConnection() {
        try {
            this.conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else {
            try {
                if (instance.conexion == null || instance.conexion.isClosed()) {
                    instance.conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
                }
            } catch (SQLException e) {
                System.err.println("Error al verificar/reconectar la BD: " + e.getMessage());
            }
        }
        return instance;
    }
    public Connection getConnection() {
        return conexion;
    }
}