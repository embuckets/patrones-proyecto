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
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Christian
 */
public class ConsultarTelefonoCliente {
        private ManejoDeBaseDeDatos baseDeDatos;
    
    public ConsultarTelefonoCliente(){
        baseDeDatos=new ManejoDeBaseDeDatos();
    }
            
    public void despliegaListaUsuarioModelo(){
        Statement s;
        UsuarioModelo usm = new UsuarioModelo();
        try{
            Connection con = baseDeDatos.crearConexion();
            s=con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM usuario_modelo");
            
            while(rs.next()){
                usm.setUsuarioClaveUsuario(rs.getString("usuario_clave_usuario"));
                usm.setModeloClaveModelo(rs.getString("modelo_clave_modelo"));
                usm.setPrecioCompra(rs.getDouble("precio_compra"));
                usm.setFechaCompra(rs.getString("fecha_compra"));
                usm.imprimeUsuarioModelo();
            }
            
            s.close();
            baseDeDatos.cerrarConexion();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}