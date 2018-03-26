package controlador;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.Numero;

public class ClienteDTO {
	private Cliente cliente;
	private ArrayList<Numero> numerosRegistrados;
	private ArrayList<Numero> numerosPorAsignar;
	private ArrayList<Numero> numerosPorCancelar;
	
	public ClienteDTO(Cliente cliente, ArrayList<Numero> numerosRegistrados, ArrayList<Numero> numerosPorAsignar,
			ArrayList<Numero> numerosPorCancelar) {
		this.cliente = cliente;
		this.numerosRegistrados = numerosRegistrados;
		this.numerosPorAsignar = numerosPorAsignar;
		this.numerosPorCancelar = numerosPorCancelar;
	}

	public String getNombre() {
		return cliente.getNombre();
	}
	
	public String getPaterno() {
		return cliente.getPaterno();
	}
	
	public String getMaterno() {
		return cliente.getMaterno();
	}

	public ArrayList<Numero> getNumerosRegistrados() {
		return numerosRegistrados;
	}

	public ArrayList<Numero> getNumerosPorAsignar() {
		return numerosPorAsignar;
	}

	public ArrayList<Numero> getNumerosPorCancelar() {
		return numerosPorCancelar;
	}
	
}
