package com.andre.pe.ctest;

import com.andre.pe.cmodelo.Cliente;
import com.andre.pe.cnegocio.ClienteBO;
import java.sql.SQLException;
import java.text.ParseException;

public class Test {

    ClienteBO clienteBO = new ClienteBO(); // Instancia de la lógica de negocio para Cliente
    Cliente cliente = new Cliente(); // Instancia del modelo Cliente

    // Método para insertar un nuevo cliente
    public void insertar() throws SQLException, ParseException {
        System.out.println("INGRESO DATOS");

        cliente.setClienteID(5);
        cliente.setNombre("María");
        cliente.setApellido("González");
        cliente.setEmail("maria.gonzalez@example.com");
        cliente.setTelefono("987654321");
        cliente.setFechaNacimiento("1990-07-22"); // Uso de formato estándar

        clienteBO.guardarCliente(cliente); // Usamos el método para guardar el cliente
    }

    public static void main(String[] args) throws SQLException, ParseException {
        Test t = new Test();
        t.insertar(); 
    }
}

    

