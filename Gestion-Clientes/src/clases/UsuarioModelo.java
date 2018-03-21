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
public class UsuarioModelo {
    private String usuarioClaveUsuario, modeloClaveModelo;
    private Double precioCompra;
    private String fechaCompra;

    public String getUsuarioClaveUsuario() {
        return usuarioClaveUsuario;
    }

    public void setUsuarioClaveUsuario(String usuarioClaveUsuario) {
        this.usuarioClaveUsuario = usuarioClaveUsuario;
    }

    public String getModeloClaveModelo() {
        return modeloClaveModelo;
    }

    public void setModeloClaveModelo(String modeloClaveModelo) {
        this.modeloClaveModelo = modeloClaveModelo;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    public void imprimeUsuarioModelo(){
        System.out.println("| " + usuarioClaveUsuario + " | " + modeloClaveModelo + " | " + precioCompra 
                + " | " + fechaCompra + " |");
    }
}
