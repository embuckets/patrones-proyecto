/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Christian
 */
public class Equipo {
	private String modelo;
	private String color;
	private String sistemaOperativo;
	private float precio;
	private String fabricante;

	public Equipo(String modelo, String color, String sistemaOperativo, float precio, String fabricante) {
		this.modelo = modelo;
		this.color = color;
		this.sistemaOperativo = sistemaOperativo;
		this.precio = precio;
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Equipo{" + "modelo=" + modelo + ", color=" + color + ", sistemaOperativo=" + sistemaOperativo
				+ ", precio=" + precio + ", fabricante=" + fabricante + '}';
	}

}