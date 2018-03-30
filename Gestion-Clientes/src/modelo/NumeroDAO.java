package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NumeroDAO {
	
	public Numero buscarNumero(Numero numero) {
		Numero numeroARegresar = null;
		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			String query = "select * from patrones.numero where numero=" + "'" + numero.getNumero() + "'";
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
	
	public List<Numero> buscarDisponible() {
		List<Numero> numerosARegresar = new ArrayList<Numero>();
		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			String query = "select * from patrones.numero where estado=" + "'" + "disponible" + "';";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String resultNumero = resultSet.getString("numero");
				Numero.Estado estado = Numero.Estado.valueOf(resultSet.getString("estado"));
				Numero numeroDisponible = new Numero(resultNumero, estado);
				numerosARegresar.add(numeroDisponible);

			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return numerosARegresar;
	}
	
	public List<Numero> buscarNumerosDelCliente(Cliente cliente) {
		List<Numero> numerosDelCliente = new ArrayList<Numero>();
		
		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			String query = "select * from patrones.numero_asignado where id_cliente=" + cliente.getId();
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				String resultNumero = resultSet.getString("numero");
				Numero numeroNuevo = new Numero(resultNumero, Numero.Estado.asignado);
				numerosDelCliente.add(numeroNuevo);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return numerosDelCliente;
	}
	
	public boolean asignar (Numero numero, Cliente cliente) {
		int updateNumeroSuccessful = 0, insertNumeroAsignadoSuccessful = 0;
		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			numero.setEstado(Numero.Estado.asignado);
			
			String updateNumero = "update patrones.numero set estado = '" + numero.getEstado() + "' where numero= " + "'" + numero.getNumero() + "';";
			statement = conn.createStatement();
			updateNumeroSuccessful = statement.executeUpdate(updateNumero);
			
			String insertNumeroAsignado = "insert into patrones.numero_asignado values (" + "'" + numero.getNumero() + "'" + "," 
					+ cliente.getId() + ");";
			statement = conn.createStatement();
			insertNumeroAsignadoSuccessful = statement.executeUpdate(insertNumeroAsignado);
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return (insertNumeroAsignadoSuccessful > 0 && updateNumeroSuccessful > 0);
	}
	
	public boolean darDeBaja(Numero numero) {
		int deleteNumeroAsignadoSuccessful = 0, updateNumeroSuccessful = 0, insertNumeroBajaSuccessful = 0;
		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			numero.setEstado(Numero.Estado.baja);
			
			String updateNumero = "update patrones.numero set estado = '" + numero.getEstado() + "' where numero= '" + numero.getNumero() + "';";
			statement = conn.createStatement();
			updateNumeroSuccessful = statement.executeUpdate(updateNumero);
			
			String deleteNumeroAsignado = "delete from patrones.numero_asignado where numero = '" + numero.getNumero() + "';";
			statement = conn.createStatement();
			deleteNumeroAsignadoSuccessful = statement.executeUpdate(deleteNumeroAsignado);
			
			
			Calendar ahora = Calendar.getInstance();
			Date sqlDateAhora = new Date(ahora.getTimeInMillis());
			ahora.add(Calendar.YEAR, 3);
			Date sqlDateLiberacion = new Date(ahora.getTimeInMillis());
			
			String insertNumeroBaja = "insert into patrones.numero_baja values ('" + numero.getNumero() 
				+ "' , '" + sqlDateAhora.toString() + "', '" + sqlDateLiberacion.toString() + "' );";
			statement = conn.createStatement();
			insertNumeroBajaSuccessful = statement.executeUpdate(insertNumeroBaja);
			
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
		
		return (deleteNumeroAsignadoSuccessful > 0 && updateNumeroSuccessful > 0 && insertNumeroBajaSuccessful > 0);
	}

	public boolean buscarSiNumeroEsDelCliente(Numero numero, Cliente cliente) {
		boolean esDelCliente = false;
		
		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			String query = "select * from patrones.numero_asignado where id_cliente=" + cliente.getId()
				+ " and numero='" + numero.getNumero() + "';";
			statement = conn.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				esDelCliente = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return esDelCliente;
		
	}
	
	
	
}
