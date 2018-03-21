/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import clases.Cliente;
import clases.ModeloCelular;
import clases.UsuarioModelo;
import operacionesBaseDeDatos.ManejoDeBaseDeDatos;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Christian
 */
public class AsignarTelefono {
    private ManejoDeBaseDeDatos baseDeDatos;
    
    public AsignarTelefono(){
        baseDeDatos=new ManejoDeBaseDeDatos();
    }
    
    public UsuarioModelo asignarTel(Cliente cliente, ModeloCelular modelo, String fecha){
        Statement s;
        UsuarioModelo usm = new UsuarioModelo();
        try{
            baseDeDatos=new ManejoDeBaseDeDatos();
            Connection con = baseDeDatos.crearConexion();
            s = con.createStatement();
            //String parametro = construirParametros(cliente);
            s.executeUpdate("INSERT INTO usuario_modelo VALUES(null, '" + cliente.getClaveIdent() + 
                    "', '" + modelo.getClave() + 
                    "', '" + modelo.getPrecio() + 
                    "', '" + fecha + "')");
            usm.setUsuarioClaveUsuario(cliente.getClaveIdent());
            usm.setModeloClaveModelo(modelo.getClave());
            usm.setPrecioCompra(modelo.getPrecio());
            usm.setFechaCompra(fecha);
            
            s.close();
        }catch(Exception e1){
            e1.printStackTrace();
        }
        return usm;
    }
}