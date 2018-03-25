package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class NumeroDAOTest {

	@Test
	void testBuscarNumero() {
		System.out.println("buscarNumero");
		NumeroDAO dao = new NumeroDAO();
		Numero numero = dao.buscarNumero("5589562323");
		System.out.println(numero.getNumero() + ", " + numero.getEstado());
		System.out.println();
		//fail("Not yet implemented");
	}
	
	@Test
	void testBuscarDisponible() {
		System.out.println("buscarDisponible");
		NumeroDAO dao = new NumeroDAO();
		Numero numero = dao.buscarDisponible();
		System.out.println(numero.getNumero() + ", " + numero.getEstado());
		System.out.println();
		//fail("Not yet implemented");
	}
	
	@Test
	void testBuscarNumeroDelCliente() {
		System.out.println("buscarNumeroDelCliente");
		int IdCliente = 2;
		NumeroDAO dao = new NumeroDAO();
		ArrayList<Numero> numerosDelCliente = dao.buscarNumeroDelCliente(IdCliente);
		System.out.println("clietne: " + IdCliente);
		for (Numero numero : numerosDelCliente) {
			System.out.println("- " + numero.getNumero());
		}
		System.out.println();
		//fail("Not yet implemented");
	}
	
	@Test
	void testAsignar() {
		System.out.println("asignar");
		
		Cliente cliente = new Cliente(1, "emilio", "hernandez", "segovia");
		Numero numero = new Numero("5526594815", Numero.Estado.disponible);
		
		NumeroDAO dao = new NumeroDAO();
		boolean success = dao.asignar(numero, cliente);
		System.out.println(success);
		System.out.println("cliente: " + cliente.getId() + ", numero: " + numero.getNumero());
		System.out.println();
		//fail("Not yet implemented");
	}
	
	@Test
	void testDarDeBaja() {
		System.out.println("baja");
		
		Numero numero = new Numero("5526594815", Numero.Estado.asignado);
		
		NumeroDAO dao = new NumeroDAO();
		boolean success = dao.darDeBaja(numero);
		System.out.println(success);
		System.out.println("numero: " + numero.getNumero());
		System.out.println();
		//fail("Not yet implemented");
	}
	
	

	public static void main(String[] args) {
		NumeroDAOTest test = new NumeroDAOTest();
		//test.testBuscarNumero();
		//test.testBuscarDisponible();
		//test.testBuscarNumeroDelCliente();
		test.testAsignar();
	}
}
