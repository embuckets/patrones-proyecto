package controlador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AsignarNumeroMainControllerTest {
	
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

	@Test
	void testBuscarCliente() {
		System.out.println("testBuscarCliente");
		AsignarNumeroMainController controller = AsignarNumeroMainController.getInstance();
//		String nombre = "test";
//		String paterno = "test";
//		String materno = "test";
//		boolean success = controller.buscarCliente(nombre, paterno, materno);
//		System.out.println(success);
//		ClienteDTO clienteDTO = controller.getCliente();
//		printClienteDTO(clienteDTO);
//		
		String nombre = "em";
		String paterno = "hernandez";
		String materno = "segovia";
		boolean success = controller.buscarCliente(nombre, paterno, materno);
		System.out.println(success);
		ClienteDTO clienteDTO = controller.getCliente();
		printClienteDTO(clienteDTO);
		System.out.println();
	}
	
	@Test
	void testBuscarNumeroDisponible() {
		System.out.println("testBuscarNumeroDisponible");
		AsignarNumeroMainController controller = AsignarNumeroMainController.getInstance();
//		String nombre = "test";
//		String paterno = "test";
//		String materno = "test";
//		boolean success = controller.buscarCliente(nombre, paterno, materno);
//		System.out.println(success);
//		ClienteDTO clienteDTO = controller.getCliente();
//		printClienteDTO(clienteDTO);
//		
		String nombre = "emilio";
		String paterno = "hernandez";
		String materno = "segovia";
		boolean success = controller.buscarCliente(nombre, paterno, materno);
		success = controller.buscarNumeroDisponible();
		System.out.println(success);
		ClienteDTO clienteDTO = controller.getCliente();
		printClienteDTO(clienteDTO);
		System.out.println();
	}
	
	@Test
	void testDarDeBajaNumero() {
		System.out.println("testDarDeBajaNumero");
		AsignarNumeroMainController controller = AsignarNumeroMainController.getInstance();
//		String nombre = "test";
//		String paterno = "test";
//		String materno = "test";
//		boolean success = controller.buscarCliente(nombre, paterno, materno);
//		System.out.println(success);
//		ClienteDTO clienteDTO = controller.getCliente();
//		printClienteDTO(clienteDTO);
//		
		String nombre = "emilio";
		String paterno = "hernandez";
		String materno = "segovia";
		boolean success = controller.buscarCliente(nombre, paterno, materno);
		success = controller.darDeBajaNumero("5512124545");
		System.out.println(success);
		ClienteDTO clienteDTO = controller.getCliente();
		printClienteDTO(clienteDTO);
		System.out.println();
	}
	
	@Test
	void testBuscarDisponibleBaja() {
		System.out.println("testBuscarDisponibleBaja");
		AsignarNumeroMainController controller = AsignarNumeroMainController.getInstance();
//		String nombre = "test";
//		String paterno = "test";
//		String materno = "test";
//		boolean success = controller.buscarCliente(nombre, paterno, materno);
//		System.out.println(success);
//		ClienteDTO clienteDTO = controller.getCliente();
//		printClienteDTO(clienteDTO);
//		
		String nombre = "emilio";
		String paterno = "hernandez";
		String materno = "segovia";
		boolean success = controller.buscarCliente(nombre, paterno, materno);
		success = controller.buscarNumeroDisponible();
		success = controller.darDeBajaNumero("5512124545");
		System.out.println(success);
		ClienteDTO clienteDTO = controller.getCliente();
		printClienteDTO(clienteDTO);
		System.out.println();
	}
	
	@Test
	void testBuscarDisponibleBajaGuardar() {
		System.out.println("testBuscarDisponibleBajaGuardar");
		AsignarNumeroMainController controller = AsignarNumeroMainController.getInstance();
//		String nombre = "test";
//		String paterno = "test";
//		String materno = "test";
//		boolean success = controller.buscarCliente(nombre, paterno, materno);
//		System.out.println(success);
//		ClienteDTO clienteDTO = controller.getCliente();
//		printClienteDTO(clienteDTO);
//		
		String nombre = "emilio";
		String paterno = "hernandez";
		String materno = "segovia";
		boolean success = controller.buscarCliente(nombre, paterno, materno);
		success = controller.buscarNumeroDisponible();
		success = controller.darDeBajaNumero("5512124545");
		success = controller.guardarCambios();
		System.out.println(success);
		ClienteDTO clienteDTO = controller.getCliente();
		printClienteDTO(clienteDTO);
		System.out.println();
	}
	
	
	
	

}
