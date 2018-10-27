package br.ifsp.farmacia.testes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.ifsp.farmacia.model.persistence.MySqlConnection;

public class TesteConexaoBanco {
	public static void main(String args[]) throws IOException {
		try {
			Connection conn = MySqlConnection.getConnection();

			if (conn == null)
				throw new SQLException("Conex�o n�o realizada.");

			System.out.println("Conectado.");			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}
}
