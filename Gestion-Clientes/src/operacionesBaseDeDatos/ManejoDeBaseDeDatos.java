/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacionesBaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Christian
 */
public class ManejoDeBaseDeDatos {
    
    private Connection conexion=null;
    
    public ManejoDeBaseDeDatos(){
    }
    
    public Connection crearConexion(){
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conexion = DriverManager.getConnection("jdbc:Mysql://localhost:3306/celulares", "root", "root");
        }
        catch(Exception e){
            System.out.println("Error al crear la conexion");
            e.printStackTrace();
            conexion=null;
        }
        return conexion;
    }
    
    public void cerrarConexion(){
        try{
            conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
}