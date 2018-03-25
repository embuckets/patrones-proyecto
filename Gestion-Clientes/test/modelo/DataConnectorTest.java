package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DataConnectorTest {

	@Test
	void testGetConnection() {
		DataConnector connector = new DataConnector();
		try (Connection conn = connector.getConnection()) {

			System.out.println(conn.getClientInfo().toString()
					+ conn.getMetaData().toString());
			conn.close();
			assert(true);
		} catch (SQLException e) {
			System.out.println("SQLExeption: " + e.getMessage());
			assert(false);
			// TODO: handle exception
		}
		// fail("Not yet implemented");
	}
	
	public void main(String[] args) {
		DataConnectorTest test = new DataConnectorTest();
		test.testGetConnection();
	}

}
