package controlador;

import java.util.ArrayList;
import java.util.Observable;

import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Numero;
import modelo.NumeroDAO;

public class AsignarNumeroMainController extends Observable{
	private static AsignarNumeroMainController instance;
	private Cliente cliente;
	private ArrayList<Numero> numerosRegistrados;
	private ArrayList<Numero> numerosPorAsignar;
	private ArrayList<Numero> numerosPorCancelar;
	
	private AsignarNumeroMainController() {
		super();
		cliente = null;
		numerosRegistrados = new ArrayList<Numero>();
		numerosPorAsignar = new ArrayList<Numero>();
		numerosPorCancelar = new ArrayList<Numero>();
	}
	
	public static AsignarNumeroMainController getInstance() {
		if (instance == null) {
			instance = new AsignarNumeroMainController();
		}
		return instance;
	}
	
	public boolean buscarCliente(String nombre, String paterno, String materno) {
		boolean success = false;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscarCliente(paterno, materno, nombre);
		if (cliente != null) {
			this.cliente = cliente;
			buscarNumerosDelCliente(cliente);
			success = true;
			setChanged();
			notifyObservers();
		}
		return success;
		
	}
	
	public ClienteDTO getCliente() {
		ClienteDTO clienteDTO = new ClienteDTO(cliente, numerosRegistrados, numerosPorAsignar, numerosPorCancelar);
		return clienteDTO;
	}
	
	public boolean buscarNumeroDisponible() {
		boolean success = false;
		NumeroDAO numeroDAO = new NumeroDAO();
		Numero numero = numeroDAO.buscarDisponible();
		if (numero != null) {
			numerosPorAsignar.add(numero);
			success = true;
			setChanged();
			notifyObservers();
		}
		
		return success;
	}
	
	public boolean darDeBajaNumero(String numero){
		Numero numeroADarBaja = new Numero(numero, Numero.Estado.asignado);
		boolean success = false;
		NumeroDAO numeroDAO = new NumeroDAO();
		boolean esDelCliente = numeroDAO.buscarSiNumeroEsDelCliente(numeroADarBaja, cliente);
		if (esDelCliente ) {
			numerosPorCancelar.add(numeroADarBaja);
			success = true;
			setChanged();
			notifyObservers();
		}
		return success;
	}
	
	public boolean guardarCambios() {
		boolean success = false;
		NumeroDAO numeroDAO = new NumeroDAO();
		for(Numero numero : numerosPorAsignar) {
			numeroDAO.asignar(numero, cliente);
		}
		
		for(Numero numero : numerosPorCancelar) {
			numeroDAO.darDeBaja(numero);
		}
		
		setChanged();
		notifyObservers();
		
		success = true;
		return success;
	}
	
	private void buscarNumerosDelCliente(Cliente cliente) {
		NumeroDAO numeroDAO = new NumeroDAO();
		ArrayList<Numero> numerosDelCliente = numeroDAO.buscarNumerosDelCliente(cliente);
		for (Numero numero : numerosDelCliente) {
			numerosRegistrados.add(numero);
		}
	}
	
	public void cancelarCambios() {
		
	}
	
}
