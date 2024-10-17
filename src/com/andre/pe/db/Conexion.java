package com.andre.pe.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que maneja la conexión a la base de datos Oracle.
 */
public class Conexion {

    private static String usuario = "CAPIBARA";
    private static String contraseña = "123456";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";

    public static Connection getConnection() {
        Connection con = null; // Mover la variable aquí para evitar problemas de conexión estática
        try {
            // Cargar el controlador jdbc
            Class.forName("oracle.jdbc.OracleDriver");

            // Establecer la conexión con la base de datos
            con = DriverManager.getConnection(url, usuario, contraseña);
            con.setAutoCommit(false);
            System.out.println("Conexión establecida.");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: Controlador no encontrado - " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error: No se pudo establecer la conexión - " + e.getMessage());
        }
        return con;
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Connection conexion = getConnection();
        
    }
}

