
package com.andre.pe.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Andre
 */
public class Conexion {
    
    private static Connection con = null;
    private static String usuario = "RIZ3";
    private static String contraseña = "123456";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    public static Connection getConnetion(){
        try {
           //Cargar el controlador jdbc
           
           Class.forName("oracle.jdbc.OracleDriver");
           
           // ESTABLECER LA CONEXION CON LA BASE DE DATOS
           
        con = DriverManager.getConnection(url,usuario,contraseña);
        con.setAutoCommit(false);
            System.out.println("ANDRE");
            
            if(con != null){
                System.out.println("Conectado");
            }else{
                System.out.println("No se pudo pipipi");
            }
            
        } catch (Exception e) {
            
            System.out.println("Error: " +e.getMessage());
            

            
        }
        return con;
      
    };
    public void closeConnection0(){
        try {
            
        } catch (Exception e) {
            System.out.println("No se pudo pipipi"+e.getMessage());
            

        }
    
}
    public static void main(String[] args) {
        //Conexion con = new Conexion();
        Conexion.getConnetion();
    }
}

