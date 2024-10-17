package com.andre.pe.cnegocio;

import com.andre.pe.cdatosdao.ClienteDao;
import com.andre.pe.cmodelo.Cliente;
import com.andre.pe.db.Conexion;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteBO {
    
    private String mensaje = "";
    
    private ClienteDao clienteDao = new ClienteDao(); 

    public boolean verificarCliente(int clienteID) {
       
        return clienteDao.verificarCliente(clienteID);
    }

    public void guardarCliente(Cliente cliente) {
        
        clienteDao.guardarCliente(cliente); 
    }

    public void actualizarCliente(Cliente cliente) {
        clienteDao.actualizarCliente(cliente); 
    }
    
    
    //----------------------------------------
     public void listarCliente (JTable table) {

      Connection c = Conexion.getConnection();

      System.out.println("llego aqui2");

    try {

      clienteDao.listarCliente(c,table);

    } catch (Exception e) {

      System.out.println("error2:" +e.getMessage());

    } finally{

    } 
}
     
    
     public String eliminarCliente (Cliente cliente) throws SQLException{

    Connection c = Conexion.getConnection();

    try {

      mensaje = clienteDao.eliminarCliente(c,cliente);

      c.commit();

    } catch (Exception e) {

      c.rollback();

    } finally{

      c.close();

    }

    return mensaje ;

  }
     
     public String modificarCliente (Cliente cliente) throws SQLException{

    Connection c = Conexion.getConnection();

    try {

      mensaje = clienteDao.modificarCliente(c,cliente);

      c.commit();

    } catch (Exception e) {

      c.rollback();

    } finally{

      c.close();

    }

    return mensaje ;

  }
    
     public ArrayList<Cliente> ListarClienteCombo(){

         ArrayList<Cliente> ListarClienteCombo = new ArrayList<>();
         Connection c = Conexion.getConnection();
         ListarClienteCombo = clienteDao.ListarClienteCombo(c);
         
         try{
             c.close();
         }catch (Exception e){
             System.out.println("Error: " + e.getMessage());
             
         }
        return ListarClienteCombo;
         
     }
}