/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author Christian
 */
public class ClienteDAO {

	public LinkedList<Cliente> listaClientes() {

		LinkedList<Cliente> lista = new LinkedList<Cliente>();

		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			String query = "select * from patrones.cliente";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id_cliente");
				String paterno = resultSet.getString("paterno");
				String materno = resultSet.getString("materno");
				String nombre = resultSet.getString("nombre");
				Cliente cliente = new Cliente(id, nombre, paterno, materno);
				lista.add(cliente);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return lista;
	}

	public Cliente buscarCliente(Cliente idCliente) {
		Cliente cliente = null;
		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			String query = "select * from cliente where id_cliente=" + "'" + idCliente.getId() + "';";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			if (resultSet.next()) {
				Integer id = resultSet.getInt("id_cliente");
				String paterno = resultSet.getString("paterno");
				String materno = resultSet.getString("materno");
				String nombre = resultSet.getString("nombre");
				cliente = new Cliente(id, nombre, paterno, materno);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return cliente;
	}

	public Cliente buscarCliente(String p, String m, String name) {
		Cliente cliente = null;
		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			String query = "select * from cliente where paterno='" + p + "' and materno='" + m + "' and nombre='" + name
					+ "';";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			if (resultSet.next()) {
				Integer id = resultSet.getInt("id_cliente");
				String paterno = resultSet.getString("paterno");
				String materno = resultSet.getString("materno");
				String nombre = resultSet.getString("nombre");
				cliente = new Cliente(id, nombre, paterno, materno);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return cliente;
	}

}