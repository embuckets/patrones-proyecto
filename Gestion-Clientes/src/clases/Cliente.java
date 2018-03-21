/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Christian
 */
public class Cliente {
    private String nombre, primerApellido, segundoApellido, direccion, claveIdent;
    private String fechaApertura;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClaveIdent() {
        return claveIdent;
    }

    public void setClaveIdent(String claveIdent) {
        this.claveIdent = claveIdent;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
    
    public void imprimeCliente(){
        System.out.println("| " + claveIdent + " | " + primerApellido + " | " + segundoApellido + " | " 
                + nombre + " | " + fechaApertura + " |");
    }
}