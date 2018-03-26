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
public class EquipoDAO {

	public LinkedList<Equipo> listaEquipos() {

		LinkedList<Equipo> lista = new LinkedList();

		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			String query = "select * from equipo, equipo_inventario where equipo.id_equipo = equipo_inventario.id_equipo";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String modelo = resultSet.getString("modelo");
				String color = resultSet.getString("equipo_inventario.color");
				String sistemaOperativo = resultSet.getString("sistema_operativo");
				float precio = resultSet.getFloat("precio");
				String fabricante = resultSet.getString("fabricante");
				Equipo equipo = new Equipo(modelo, color, sistemaOperativo, precio, fabricante);
				lista.add(equipo);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return lista;
	}

	public EquipoCliente buscarEquipo(String modelo, String color) {
		EquipoCliente equipo = null;
		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			String query = "select * from equipo, equipo_inventario where " + "modelo='" + modelo + "' and color='"
					+ color + "'";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			if (resultSet.next()) {
				int id = resultSet.getInt("equipo.id_equipo");
				String col = resultSet.getString("color");
				float precio = resultSet.getFloat("precio");
				equipo = new EquipoCliente(0, 0, id, col, precio, null);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return equipo;
	}

	public boolean asignar(EquipoCliente equipo) {

		boolean bandera = false;
		try {
			DataConnector connector = new DataConnector();
			Connection conn = connector.getConnection();
			Statement statement = null;
			String query = "insert into equipo_compra values(null, '" + equipo.getFecha() + "', "
					+ equipo.getIdCliente() + ", " + equipo.getIdEquipo() + ", '" + equipo.getColor() + "', "
					+ equipo.getPrecio() + ")";
			statement = conn.createStatement();
			statement.executeUpdate(query);
			conn.close();
			bandera = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return bandera;
	}

}