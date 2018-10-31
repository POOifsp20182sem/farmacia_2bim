package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.Connection;
import java.sql.SQLException;

import br.ifsp.poo.farmacia.modelo.entidade.Login;

import java.nio.file.AccessDeniedException;
import java.sql.CallableStatement;

public class LoginDAO implements ILoginDAO{

	@Override
	public void validarLogin(Login login) throws SQLException, AccessDeniedException, Exception  {

		Connection conn = null;
		CallableStatement cs = null;

		/***
		 * Faz a validação do login
		 * recebe nome e senha e busca no banco
		 * @param outputValue recebe o valor de validacao (TRUE or FALSE)
		 * Caso a validação seja válida ou não, retorna mensagem
		 * que descreve o status atual
		 */
		try {
			boolean outputValue;
			String query = "{? = call validar_login(?, ?)}"; 

			conn = MySqlConnection.getConnection();
			cs = conn.prepareCall(query);

			cs.registerOutParameter(1, java.sql.Types.BOOLEAN);
			cs.setString(2, login.getUserName());
			cs.setString(3, login.getPassword());
			cs.execute();

			outputValue = cs.getBoolean(1);

			if(!outputValue) 
				throw new AccessDeniedException("Nome ou senha incorreto, tente novamente!");

		} catch (SQLException e1) {
			throw new SQLException("Erro no banco de dados!");
		} catch (AccessDeniedException e2) {
			throw e2;
		} catch (Exception e3) {
			throw new Exception("Erro desconhecido.");
		}finally {
			conn.close();
		}
	}
}
