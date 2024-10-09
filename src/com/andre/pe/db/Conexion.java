package com.andre.pe.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase que maneja la conexión a la base de datos Oracle.
 */
public class Conexion {

    private static Connection con = null;
    private static String usuario = "RIZ3";
    private static String contraseña = "123456";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";

    public static Connection getConnection() {
        try {
            // Cargar el controlador jdbc
            Class.forName("oracle.jdbc.OracleDriver");

            // Establecer la conexión con la base de datos
            con = DriverManager.getConnection(url, usuario, contraseña);
            con.setAutoCommit(false);
            System.out.println("Conexión establecida.");

            if (con != null) {
                System.out.println("Conectado.");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

    public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Conexion.getConnection();
    }
}


