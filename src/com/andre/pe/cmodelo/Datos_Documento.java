package com.andre.pe.cmodelo;

public class Datos_Documento {

    private int id_Datos_Documento;
    private int numero;
    private String fecha_de_Emision;
    private String fecha_de_Vencimiento;
    private int id_documento_identidad;
    private int id_cliente;

    public int getId_Datos_Documento() {
        return id_Datos_Documento;
    }

    public void setId_Datos_Documento(int id_Datos_Documento) {
        this.id_Datos_Documento = id_Datos_Documento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha_de_Emision() {
        return fecha_de_Emision;
    }

    public void setFecha_Emision(String fecha_de_Emision) {
        this.fecha_de_Emision = fecha_de_Emision;
    }

    public String getFecha_de_Vencimiento() {
        return fecha_de_Vencimiento;
    }

    public void setFecha_Vencimiento(String fecha_de_Vencimiento) {
        this.fecha_de_Vencimiento = fecha_de_Vencimiento;
    }

    public int getId_Documento_Identidad() {
        return id_documento_identidad;
    }

    public void setId_Documento_Identidad(int id_documento_identidad) {
        this.id_documento_identidad = id_documento_identidad;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}

