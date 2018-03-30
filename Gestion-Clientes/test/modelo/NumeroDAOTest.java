package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class NumeroDAOTest {

	@Test
	void testBuscarNumero() {
		System.out.println("buscarNumero");
		Numero numero = new Numero("5589562323", Numero.Estado.asignado);
		NumeroDAO dao = new NumeroDAO();
		Numero numeroRessultado = dao.buscarNumero(numero);
		System.out.println(numeroRessultado.getNumero() + ", " + numeroRessultado.getEstado());
		System.out.println();
		// fail("Not yet implemented");
	}

	@Test
	void testBuscarDisponible() {
		System.out.println("buscarDisponible");
		NumeroDAO dao = new NumeroDAO();
		List<Numero> numerosDisponibles = dao.buscarDisponible();
		for(Numero numeroActual : numerosDisponibles) {
			System.out.println(numeroActual.getNumero() + ", " + numeroActual.getEstado());
		}
		System.out.println();
		// fail("Not yet implemented");
	}

	@Test
	void testBuscarNumeroDelCliente() {
		System.out.println("buscarNumeroDelCliente");
		Cliente cliente = new Cliente(2, "test", "test", "test");
		NumeroDAO dao = new NumeroDAO();
		List<Numero> numerosDelCliente = dao.buscarNumerosDelCliente(cliente);
		System.out.println("clietne: " + cliente.getId());
		for (Numero numero : numerosDelCliente) {
			System.out.println("- " + numero.getNumero());
		}
		System.out.println();
		// fail("Not yet implemented");
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
		// fail("Not yet implemented");
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
		// fail("Not yet implemented");
	}

	@Test
	void testbuscarSiNumeroEsDelCliente() {
		System.out.println("buscarSiEsDelCliente");

		Numero numero = new Numero("5511122233", Numero.Estado.asignado);
		Cliente cliente = new Cliente(2, "test", "test", "test");

		NumeroDAO dao = new NumeroDAO();
		boolean success = dao.buscarSiNumeroEsDelCliente(numero, cliente);
		System.out.println(success);
		System.out.println("numero: " + numero.getNumero() + ", cliente: " + cliente.getId());
		System.out.println();
	}

	public static void main(String[] args) {
		NumeroDAOTest test = new NumeroDAOTest();
		// test.testBuscarNumero();
		// test.testBuscarDisponible();
		// test.testBuscarNumeroDelCliente();
		//test.testAsignar();
		test.testbuscarSiNumeroEsDelCliente();
	}
}
