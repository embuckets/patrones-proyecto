package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumeroDAOTest {

	@Test
	void testBuscarNumero() {
		NumeroDAO dao = new NumeroDAO();
		Numero numero = dao.buscarNumero("5512124545");
		System.out.println(numero.getNumero() + ", " + numero.getEstado());
		//fail("Not yet implemented");
	}

	public static void main(String[] args) {
		NumeroDAOTest test = new NumeroDAOTest();
		test.testBuscarNumero();
	}
}
