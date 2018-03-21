/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import clases.Cliente;
import operacionesBaseDeDatos.ManejoDeBaseDeDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Christian
 */
public class RegistrarCliente {
    private ManejoDeBaseDeDatos baseDeDatos;
    
    public RegistrarCliente(){
        baseDeDatos=new ManejoDeBaseDeDatos();
    }
    
    public void despliegaListaCliente(){
        Statement s;
        Cliente cliente = new Cliente();
        try{
            Connection con = baseDeDatos.crearConexion();
            s=con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM usuario"); // order by RFC
            
            while(rs.next()){
                cliente.setClaveIdent(rs.getString("clave_usuario"));
                cliente.setPrimerApellido(rs.getString("primer_apellido"));
                cliente.setSegundoApellido(rs.getString("segundo_apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setFechaApertura(rs.getString("fecha_apertura"));
                cliente.imprimeCliente();
            }
            
            s.close();
            baseDeDatos.cerrarConexion();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Cliente buscarClientePorClave(String clave){
        Statement s;
        Connection con = baseDeDatos.crearConexion();
        Cliente cliente = new Cliente();
        
        try{
            s=con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM usuario WHERE clave_usuario ='" + clave + "'");
            // Si no hay elementos, lo indica
            if(!rs.first())
                System.out.println("No existen coincidencias");
            // Es necesario regresar al primer elemento antes de recorrer
            else{
                rs.beforeFirst();
                while(rs.next()){
                    cliente.setClaveIdent(rs.getString("clave_usuario"));
                    cliente.setPrimerApellido(rs.getString("primer_apellido"));
                    cliente.setSegundoApellido(rs.getString("segundo_apellido"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setFechaApertura(rs.getString("fecha_apertura"));
                    cliente.imprimeCliente();
                }
            }
            s.close();
            baseDeDatos.cerrarConexion();
        }catch(Exception e){
            e.printStackTrace();
        }
        return cliente;
    }

    public void registrarNuevoCliente(Cliente cliente){
        Statement s;
        try{
            baseDeDatos=new ManejoDeBaseDeDatos();
            Connection con = baseDeDatos.crearConexion();
            s = con.createStatement();
            s.executeUpdate("INSERT INTO usuario VALUES('" + cliente.getClaveIdent() + 
                    "', '" + cliente.getPrimerApellido() + 
                    "', '" + cliente.getSegundoApellido() + 
                    "', '" + cliente.getNombre() + 
                    "', '" + cliente.getFechaApertura() + "')");
            s.close();
        }catch(Exception e1){
            e1.printStackTrace();
        }
    }
}