package com.Biblioteca.app;

/*import com.Biblioteca.conexion.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        try (Connection conexion = DatabaseConnection.getInstance().getConnection()) {
            System.out.println("Conexión exitosa con MySQL.");
        } catch (SQLException e) {
            System.out.println(
                    "Error de conexión: " + e.getMessage());}}}

 */
import com.Biblioteca.view.VistaLogin;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Asegurar que la interfaz gráfica corra en el hilo seguro de Swing
        SwingUtilities.invokeLater(() -> {
            VistaLogin login = new VistaLogin();
            login.setVisible(true);
        });
    }
}