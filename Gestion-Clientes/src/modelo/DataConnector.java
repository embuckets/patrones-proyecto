package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataConnector {
	private String userName;
	private String password;
	private String dbms;
	private String serverName;
	private String portNumber;
	private String dataBase;
	
	public DataConnector() {
		userName = "root";
		password = "eva01";
		dbms = "mysql";
		serverName = "localhost";
		portNumber = "3306";
		dataBase = "patrones";
	}
	
	public Connection getConnection() throws SQLException {

		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:" + this.dbms + "://" + this.serverName + ":" + this.portNumber 
				+ "/" + dataBase + "?" 
				+ "user=" + connectionProps.getProperty("user") + "&password=" + connectionProps.getProperty("password") 
				+ "&useSSL=false");
		System.out.println("Connected to database");
		return conn;
	}
}
