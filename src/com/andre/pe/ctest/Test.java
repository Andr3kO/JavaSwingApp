package com.andre.pe.ctest;

import com.andre.pe.cmodelo.Datos_Documento;
import com.andre.pe.cnegocio.Datos_DocumentoBO;
import java.sql.SQLException;
import java.text.ParseException;

public class Test {

    Datos_DocumentoBO tdbo = new Datos_DocumentoBO();
    Datos_Documento dd = new Datos_Documento();

    public void insertar() throws SQLException, ParseException {
        System.out.println("INGRESO DATOS");

        dd.setId_Datos_Documento(1);
        dd.setNumero(5);
        dd.setFecha_Emision("2024-10-24");  // Uso de formato estándar
        dd.setFecha_Vencimiento("2024-10-30");
        dd.setId_Documento_Identidad(1);
        dd.setId_cliente(1);

        tdbo.agregarDatosDocumento(dd);
    }
    public void eliminar() throws SQLException, ParseException {
        System.out.println("eliminar DATOS");

        dd.setId_Datos_Documento(2);

        tdbo.eliminarDatosDocumento(dd);
    }
    public void actualizar() throws SQLException, ParseException {
    System.out.println("ACTUALIZACIÓN DE DATOS");

    
    dd.setId_Datos_Documento(5);  
    dd.setNumero(5165151);  

    tdbo.actualizarDatosDocumento(dd);
}


    public static void main(String[] args) throws SQLException, ParseException {
        Test t = new Test();
        //t.insertar();
        //t.eliminar();
        t.actualizar();
    }
    
    
}

    

