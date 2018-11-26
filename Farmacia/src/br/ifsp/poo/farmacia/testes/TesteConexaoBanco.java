package br.ifsp.poo.farmacia.testes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.ifsp.poo.farmacia.modelo.persistencia.MySqlConnection;

public class TesteConexaoBanco {
	public static void main(String args[]) throws IOException {
		try {
			Connection conn = MySqlConnection.getConnection();

			if (conn == null)
				throw new SQLException("Conexão não realizada.");

			System.out.println("Conectado.");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
