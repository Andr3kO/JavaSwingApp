package com.andre.pe.cnegocio;

import com.andre.pe.cdatosdao.Datos_DocumentoDao;
import com.andre.pe.cmodelo.Datos_Documento;
import com.andre.pe.db.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

public class Datos_DocumentoBO {

    private String mensaje;
    private Datos_DocumentoDao dd = new Datos_DocumentoDao();

    public String agregarDatosDocumento(Datos_Documento datosDocumento) {
        String mensaje = "";
        try (Connection c = Conexion.getConnection()) {
            c.setAutoCommit(false);
            mensaje = dd.agregarDatosDocumento(c, datosDocumento);
            c.commit();
        } catch (SQLException e) {
            mensaje = "Error: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarDatosDocumento(Datos_Documento datosDocumento) {
        String mensaje = "";
        try (Connection c = Conexion.getConnection()) {
            c.setAutoCommit(false);
            mensaje = dd.eliminarDatosDocumento(c, datosDocumento);
            c.commit();
        } catch (SQLException e) {
            mensaje = "Error: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarDatosDocumento(Datos_Documento datosDocumento) {
        String mensaje = "";
        try (Connection c = Conexion.getConnection()) {
            c.setAutoCommit(false);
            mensaje = dd.actualizarDatosDocumento(c, datosDocumento);
            c.commit();
        } catch (SQLException e) {
            mensaje = "Error al actualizar el documento: " + e.getMessage();
        }
        return mensaje;
    }

    public void listarDatosDocumento(JTable table) {
        try (Connection c = Conexion.getConnection()) {
            dd.listarDatosDocumento(c, table);
        } catch (SQLException e) {
            System.err.println("Error al listar los datos: " + e.getMessage());
        }
    }
}