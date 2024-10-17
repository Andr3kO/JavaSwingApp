package com.andre.pe.cdatosdao;

import com.andre.pe.cmodelo.Cliente;
import com.andre.pe.db.Conexion;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClienteDao {
    
    private String mensaje = "";

    public boolean verificarCliente(int clienteID) {
        String sql = "SELECT COUNT(*) FROM Cliente WHERE ClienteID = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, clienteID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; 
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar si el cliente existe: " + e.getMessage());
        }
        return false;
    }

    public void guardarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (ClienteID, Nombre, Apellido, Email, Telefono, FechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, cliente.getClienteID());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellido());
            pst.setString(4, cliente.getEmail());
            pst.setString(5, cliente.getTelefono());
            pst.setString(6, cliente.getFechaNacimiento());
            pst.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
        }
    }

    public void actualizarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET Nombre = ?, Apellido = ?, Email = ?, Telefono = ?, FechaNacimiento = ? WHERE ClienteID = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getTelefono());
            pst.setString(5, cliente.getFechaNacimiento());
            pst.setInt(6, cliente.getClienteID());
            pst.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        }
    }
    
    
    
    public void listarCliente(Connection conn, JTable table ){

        System.out.println("llego aqui");



    DefaultTableModel model;

    Statement statement = null;

    ResultSet resultSet = null;

    String [] columnas = {"ClienteID","Nombre","Apellido","Email","Telefono","FechaNacimiento"};

            System.out.println("llego aqui");



    model = new DefaultTableModel (null,columnas);

     

    String sql = "SELECT * FROM Cliente";

    String [] datosTP = new String [6];

     

    try {

      statement = conn.createStatement();

      resultSet = statement.executeQuery(sql);

       

      while (resultSet.next()){

        Cliente DD = new Cliente();

        DD.setClienteID(resultSet.getInt("ClienteID"));

        DD.setNombre(resultSet.getString("Nombre"));

        DD.setApellido(resultSet.getString("Apellido"));

        DD.setEmail(resultSet.getString("Email"));

        DD.setTelefono(resultSet.getString("Telefono"));

        DD.setFechaNacimiento(resultSet.getString("FechaNacimiento"));

         

        datosTP[0] = DD.getClienteID()+"";

        datosTP[1] = DD.getNombre()+"";

        datosTP[2] = DD.getApellido()+"";

        datosTP[3] = DD.getEmail()+"";

        datosTP[4] = DD.getTelefono()+"";

        datosTP[5] = DD.getFechaNacimiento()+"";

         

        model.addRow(datosTP);

         

      }

      table.setModel(model);

    } catch (Exception e) {

      JOptionPane.showMessageDialog(null, "Error"+e.getMessage());

      System.out.println(e.getMessage());

    }


  }
    
    
    
    //Eliminar
    
     public String eliminarCliente (Connection conn, Cliente cliente){

     

    PreparedStatement ps = null ;

    String sql = "DELETE FROM Cliente WHERE ClienteID = ?";  

     

     

    try {

      ps= conn.prepareStatement(sql);

      ps.setInt(1,cliente.getClienteID());

       

       

      ps.execute();

      ps.close();

      mensaje ="el tipo de documento fue eliminado";

    } catch (Exception e) {

      mensaje ="Error al eliminar los datos"+e.getMessage();

      System.out.println(e.getMessage());

    }

    return mensaje ;

  }
  public String modificarCliente (Connection conn, Cliente cliente){   

     

    PreparedStatement ps = null ;

    String sql = "UPDATE Cliente SET Nombre = ?, Apellido = ?, Email = ?, Telefono = ?, FechaNacimiento = ?" + "WHERE ClienteID = ?";

           

     

     

    try {

      ps= conn.prepareStatement(sql);

       

       

      ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getFechaNacimiento());
            ps.setInt(6, cliente.getClienteID());

       

      ps.execute();

      ps.close();

      mensaje ="el tipo de documento fue modificado";

    } catch (Exception e) {

      mensaje ="Error al modificar los datos"+e.getMessage();

      System.out.println(e.getMessage());

    }

    return mensaje ;

  }
  
  public ArrayList<Cliente>ListarClienteCombo(Connection conn){
      ArrayList<Cliente>ListarClienteCombo = new ArrayList<>();
      Statement statement = null;
      ResultSet resultSet = null;
      
      String sql = "SELECT ClienteID, Ciudad FROM Direccion ORDER BY Ciudad";
      
      try {
            statement = conn.createStatement();

            resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            Cliente cli = new Cliente();
            cli.setClienteID(resultSet.getInt("ClienteID"));
            cli.setCiudad(resultSet.getString("Ciudad"));
            ListarClienteCombo.add(cli);
        }

    } catch (Exception e) {

      JOptionPane.showMessageDialog(null, "Error"+e.getMessage());

      System.out.println(e.getMessage());

    }
        return ListarClienteCombo;
     
}
}