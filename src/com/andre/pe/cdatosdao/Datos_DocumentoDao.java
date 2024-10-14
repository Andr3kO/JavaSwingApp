package com.andre.pe.cdatosdao;

import com.andre.pe.cmodelo.Datos_Documento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Datos_DocumentoDao {

    public String agregarDatosDocumento(Connection conexion, Datos_Documento datosDocumento) {
        String mensaje = "";
        String sql = "INSERT INTO DATOS_DOCUMENTO (ID_DATOS_DOCUMENTO, NUMERO, FECHA_EMICION, FECHA_VENCIMIENTO, ID_CLIENTE, ID_DOCUMENTO_IDENTIDAD) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, datosDocumento.getId_Datos_Documento());
            ps.setInt(2, datosDocumento.getNumero());
            ps.setString(3, datosDocumento.getFecha_de_Emision());
            ps.setString(4, datosDocumento.getFecha_de_Vencimiento());
            ps.setInt(5, datosDocumento.getId_cliente());
            ps.setInt(6, datosDocumento.getId_Documento_Identidad());
            ps.executeUpdate();
            mensaje = "El documento fue agregado correctamente.";
        } catch (SQLException e) {
            mensaje = "Error al agregar los datos: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarDatosDocumento(Connection conexion, Datos_Documento datosDocumento) {
        String mensaje = "";
        String sql = "DELETE FROM DATOS_DOCUMENTO WHERE ID_DATOS_DOCUMENTO = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, datosDocumento.getId_Datos_Documento());
            ps.executeUpdate();
            mensaje = "El documento fue erradicado correctamente.";
        } catch (SQLException e) {
            mensaje = "Error al erradicar el dato: " + e.getMessage();
        }
        return mensaje;
    }

    public String actualizarDatosDocumento(Connection conexion, Datos_Documento datosDocumento) {
        String mensaje = "";
        String sql = "UPDATE DATOS_DOCUMENTO SET NUMERO = ? WHERE ID_DATOS_DOCUMENTO = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, datosDocumento.getNumero());
            ps.setInt(2, datosDocumento.getId_Datos_Documento());
            ps.executeUpdate();
            mensaje = "El documento fue actualizado correctamente.";
        } catch (SQLException e) {
            mensaje = "Error al actualizar el dato: " + e.getMessage();
        }
        return mensaje;
    }

    public void listarDatosDocumento(Connection conn, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpiar cualquier fila existente
        String sql = "SELECT * FROM DATOS_DOCUMENTO";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Object[] datos = new Object[6];
                datos[0] = rs.getInt("ID_DATOS_DOCUMENTO");
                datos[1] = rs.getInt("NUMERO");
                datos[2] = rs.getString("FECHA_EMICION");
                datos[3] = rs.getString("FECHA_VENCIMIENTO");
                datos[4] = rs.getInt("ID_CLIENTE");
                datos[5] = rs.getInt("ID_DOCUMENTO_IDENTIDAD");
                model.addRow(datos); 
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos: " + e.getMessage());
        }
    }
}
