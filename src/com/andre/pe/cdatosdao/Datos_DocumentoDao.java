package com.andre.pe.cdatosdao;

import com.andre.pe.cmodelo.Datos_Documento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Datos_DocumentoDao {

    private String mensaje;

    public String agregarDatosDocumento(Connection conexion, Datos_Documento datosDocumento) {

        PreparedStatement ps = null;
        String sql = "INSERT INTO DATOS_DOCUMENTO (ID_DATOS_DOCUMENTO, NUMERO, FECHA_EMICION, FECHA_VENCIMIENTO, ID_CLIENTE, ID_DOCUMENTO_IDENTIDAD)"
                + " VALUES (?, ?, ?, ?, ?, ?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, datosDocumento.getId_Datos_Documento());
            ps.setInt(2, datosDocumento.getNumero());
            ps.setString(3, datosDocumento.getFecha_de_Emision());
            ps.setString(4, datosDocumento.getFecha_de_Vencimiento());
            ps.setInt(5, datosDocumento.getId_cliente());
            ps.setInt(6, datosDocumento.getId_Documento_Identidad());

            ps.execute();
            ps.close();
            mensaje = "El documento fue agregado correctamente.";

        } catch (SQLException e) {
            mensaje = "Error al agregar los datos: " + e.getMessage();
        }
        return mensaje;
    }
    //elimininar
    public String eliminarDatosDocumento(Connection conexion, Datos_Documento datosDocumento) {

        PreparedStatement ps = null;
        String sql = "DELETE FROM DATOS_DOCUMENTO WHERE ID_DATOS_DOCUMENTO = ?";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, datosDocumento.getId_Datos_Documento());
            ps.execute();
            ps.close();
            mensaje = "El documento fue erradicado correctamente.";

        } catch (SQLException e) {
            mensaje = "Error al erradicar el dato: " + e.getMessage();
        }
        return mensaje;
    }
    public String actualizarDatosDocumento(Connection conexion, Datos_Documento datosDocumento) {

    PreparedStatement ps = null;
    String sql = "UPDATE DATOS_DOCUMENTO SET NUMERO = ? WHERE ID_DATOS_DOCUMENTO = ?";

    try {
        ps = conexion.prepareStatement(sql);
        

        ps.setInt(1, datosDocumento.getNumero());
        
        
        ps.setInt(2, datosDocumento.getId_Datos_Documento());
        
        ps.executeUpdate();  
        ps.close();
        mensaje = "El documento fue actualizado correctamente.";

    } catch (SQLException e) {
        mensaje = "Error al actualizar el dato: " + e.getMessage();
    }
    return mensaje;
}

}

