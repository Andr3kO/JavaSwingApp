package com.andre.pe.cnegocio;

import com.andre.pe.cdatosdao.Datos_DocumentoDao;
import com.andre.pe.cmodelo.Datos_Documento;
import com.andre.pe.db.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class Datos_DocumentoBO {

    private String mensaje;
    Datos_DocumentoDao dd = new Datos_DocumentoDao();

    public String agregarDatosDocumento(Datos_Documento datosDocumento) throws SQLException {

        Connection c = Conexion.getConnection(); 
        try {
            mensaje = dd.agregarDatosDocumento(c, datosDocumento);
            c.commit();
        } catch (Exception e) {
            c.rollback();
            mensaje = "Error: " + e.getMessage();
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return mensaje;
    }
    //eliminar
    public String eliminarDatosDocumento(Datos_Documento datosDocumento) throws SQLException {

        Connection c = Conexion.getConnection(); 
        try {
            mensaje = dd.eliminarDatosDocumento(c, datosDocumento);
            c.commit();
        } catch (Exception e) {
            c.rollback();
            mensaje = "Error: " + e.getMessage();
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return mensaje;
    }
    //ACTUALIZAR
    public String actualizarDatosDocumento(Datos_Documento datosDocumento) throws SQLException {

    Connection c = Conexion.getConnection();  
    try {
        mensaje = dd.actualizarDatosDocumento(c, datosDocumento);  
        c.commit();  
    } catch (Exception e) {
        c.rollback();  
        mensaje = "Error al actualizar el documento: " + e.getMessage();
    } finally {
        if (c != null && !c.isClosed()) {
            c.close(); 
        }
    }
    return mensaje;
}


}
