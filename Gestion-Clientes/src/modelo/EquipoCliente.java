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
public class EquipoCliente {

	private int idEquipoCliente;
	private int idCliente;
	private int idEquipo;
	private String color;
	private float precio;
	private String fecha;

	public EquipoCliente(int idEquipoCliente, int idCliente, int idEquipo, String color, float precio, String fecha) {
		this.idEquipoCliente = idEquipoCliente;
		this.idCliente = idCliente;
		this.idEquipo = idEquipo;
		this.color = color;
		this.precio = precio;
		this.fecha = fecha;
	}

	public int getIdEquipoCliente() {
		return idEquipoCliente;
	}

	public void setIdEquipoCliente(int idEquipoCliente) {
		this.idEquipoCliente = idEquipoCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "EquipoCliente{" + "idEquipoCliente=" + idEquipoCliente + ", idCliente=" + idCliente + ", idEquipo="
				+ idEquipo + ", color=" + color + ", precio=" + precio + ", fecha=" + fecha + '}';
	}
}