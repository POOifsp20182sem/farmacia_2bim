package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// https://docs.oracle.com/javase/tutorial/jdbc/overview/index.html
public class MySqlConnection {

	public static Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/farmacia", "root", "");
		} catch (SQLException e) {
			throw new SQLException("Erro ao carregar o driver de conexão com o banco.");
		}

		if (connection == null)
			throw new SQLException("Connection class could not be created.");

		return connection;
	}
}
