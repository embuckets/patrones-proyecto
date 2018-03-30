package controlador;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;

import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Numero;
import modelo.NumeroDAO;

public class AsignarNumeroMainController extends Observable{
	private static AsignarNumeroMainController instance;
	private Cliente cliente;
	private Set<Numero> numerosRegistrados;
	private Set<Numero> numerosPorAsignar;
	private Set<Numero> numerosPorCancelar;
	
	private AsignarNumeroMainController() {
		super();
		cliente = null;
		numerosRegistrados = new HashSet<Numero>();
		numerosPorAsignar = new HashSet<Numero>();
		numerosPorCancelar = new HashSet<Numero>();
	}
	
	public static AsignarNumeroMainController getInstance() {
		if (instance == null) {
			instance = new AsignarNumeroMainController();
		}
		return instance;
	}
	
	public boolean buscarCliente(String nombre, String paterno, String materno) {
		numerosRegistrados = new HashSet<Numero>();
		numerosPorAsignar = new HashSet<Numero>();
		numerosPorCancelar = new HashSet<Numero>();
		
		boolean success = false;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente clienteEncontrado = clienteDAO.buscarCliente(paterno, materno, nombre);
		if (clienteEncontrado != null) {
			this.cliente = clienteEncontrado;			
			NumeroDAO numeroDAO = new NumeroDAO();
			ArrayList<Numero> numerosDelCliente = numeroDAO.buscarNumerosDelCliente(cliente);
			for (Numero numero : numerosDelCliente) {
				numerosRegistrados.add(numero);
			}
			success = true;
		}else {
			this.cliente = new Cliente(-1, "", "", "");
		}
		setChanged();
		notifyObservers();
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
			success = numerosPorAsignar.add(numero);
			System.out.println("[MainController - NumeroADarDeAlta]");
			System.out.println("[" + numero.toString() + "]");
			ClienteDTO dto = getCliente();
			printClienteDTO(dto);
			System.out.println();
			//success = true;
			setChanged();
			notifyObservers();
		}
		
		return success;
	}
	boolean success = false;
	public boolean darDeBajaNumero(String numero){
		boolean success = false;
		String numeroFormateado = formatNumero(numero);
		Numero numeroADarBaja = new Numero(numeroFormateado, Numero.Estado.disponible);
		if(numerosPorAsignar.contains(numeroADarBaja)) {
			numerosPorAsignar.remove(numeroADarBaja);
			setChanged();
			notifyObservers();
			success = true;
			return success;
		}
		else if(numerosPorCancelar.contains(numeroADarBaja)) {
			numerosPorCancelar.remove(numeroADarBaja);
			setChanged();
			notifyObservers();
			success = true;
			return success;
		}
		
		NumeroDAO numeroDAO = new NumeroDAO();
		boolean esDelCliente = numeroDAO.buscarSiNumeroEsDelCliente(numeroADarBaja, cliente);
		if (esDelCliente ) {
			System.out.println("[MainController - NumeroADarDeBaja]");
			System.out.println("[" + numero + "]");
			numerosPorCancelar.add(numeroADarBaja);
			success = true;
			ClienteDTO dto = getCliente();
			printClienteDTO(dto);
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
		
		buscarCliente(cliente.getNombre(), cliente.getPaterno(), cliente.getMaterno());
		
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
	
	private void printClienteDTO(ClienteDTO clienteDTO) {
		System.out.println("-------clientedDTO-------");
		System.out.println(clienteDTO.getNombre());
		System.out.println(clienteDTO.getPaterno());
		System.out.println(clienteDTO.getMaterno());
		System.out.println("***Numeros REgistrados***");
		for(NumeroDTO numero : clienteDTO.getNumerosRegistrados()) {
			System.out.println(numero.getNumero());
		}
		System.out.println("***Numeros Por REgistrar***");
		for(NumeroDTO numero : clienteDTO.getNumerosPorAsignar()) {
			System.out.println(numero.getNumero());
		}
		System.out.println("***Numeros Por Cancelar***");
		for(NumeroDTO numero : clienteDTO.getNumerosPorCancelar()) {
			System.out.println(numero.getNumero());
		}		
		System.out.println("-------clientedDTO-------");
	}
	
	private String formatNumero(String numero) {
		String numeroFormateado = numero.replace("-", "");
		return numeroFormateado;
	}

}
