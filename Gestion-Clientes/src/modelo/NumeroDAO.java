package modelo;

import java.sql.*;

public class NumeroDAO {
	public Numero buscarNumero(String numero) {
		Numero numeroARegresar = null;
		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			String query = "select * from patrones.numero where numero=" + "'" + numero + "'";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			if (resultSet.next()) {
				String resultNumero = resultSet.getString("numero");
				Numero.Estado estado = Numero.Estado.valueOf(resultSet.getString("estado"));
				numeroARegresar = new Numero(resultNumero, estado);

			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return numeroARegresar;
	}
}
