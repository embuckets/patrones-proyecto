/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import clases.ModeloCelular;
import operacionesBaseDeDatos.ManejoDeBaseDeDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Christian
 */
public class ConsultarModelosCelular {
    private ManejoDeBaseDeDatos baseDeDatos;
    
    public ConsultarModelosCelular(){
        baseDeDatos=new ManejoDeBaseDeDatos();
    }
    
    public void despliegaListaModelos(){
        Statement s;
        ModeloCelular modelo = new ModeloCelular();

        try{
            Connection con = baseDeDatos.crearConexion();
            s=con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM modelo");
            
            while(rs.next()){
                modelo.setClave(rs.getString("clave_modelo"));
                modelo.setColor(rs.getString("color"));
                modelo.setPrecio(rs.getDouble("precio"));
                modelo.setSistemaOperativo(rs.getString("sistema_operativo"));
                modelo.setCantidadExistencia(rs.getInt("existencia"));
                modelo.setCompañiaFabricante(rs.getString("fabricante"));
                modelo.imprimeModelo();
            }
            s.close();
            baseDeDatos.cerrarConexion();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ModeloCelular buscarModeloPorClave(String clave){
        Statement s;
        Connection con = baseDeDatos.crearConexion();
        ModeloCelular modelo = new ModeloCelular();
        
        try{
            s=con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM modelo WHERE clave_modelo ='" + clave + "'");
            // Si no hay elementos, lo indica
            if(!rs.first())
                System.out.println("No existen coincidencias");
            // Es necesario regresar al primer elemento antes de recorrer
            else{
                rs.beforeFirst();
                while(rs.next()){
                    modelo.setClave(rs.getString("clave_modelo"));
                    modelo.setColor(rs.getString("color"));
                    modelo.setPrecio(rs.getDouble("precio"));
                    modelo.setSistemaOperativo(rs.getString("sistema_operativo"));
                    modelo.setCantidadExistencia(rs.getInt("existencia"));
                    modelo.setCompañiaFabricante(rs.getString("fabricante"));
                    modelo.imprimeModelo();
                }
            }
            s.close();
            baseDeDatos.cerrarConexion();
        }catch(Exception e){
            e.printStackTrace();
        }
        return modelo;
    }
}