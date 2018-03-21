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
public class ModeloCelular {
    private String clave, color, sistemaOperativo, compañiaFabricante;
    private double precio;
    private int cantidadExistencia;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getCompañiaFabricante() {
        return compañiaFabricante;
    }

    public void setCompañiaFabricante(String compañiaFabricante) {
        this.compañiaFabricante = compañiaFabricante;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(int cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }
    
    public void imprimeModelo(){
        System.out.println("| " + clave + " | " + color + " | " + precio + " | " + sistemaOperativo
                + " | " + cantidadExistencia + " | " + compañiaFabricante + " |");
    }    
}