package br.ifsp.farmacia.model.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// https://docs.oracle.com/javase/tutorial/jdbc/overview/index.html
public class MySqlConnection {

	public static Connection getConnection()
			throws SQLException {
		Connection connection = null;

		connection = DriverManager.getConnection("jdbc:mysql://localhost/farmacia",
				"root",
				"");

		if (connection == null)
			throw new SQLException("Connection class could not be created.");

		return connection;
	}
}
