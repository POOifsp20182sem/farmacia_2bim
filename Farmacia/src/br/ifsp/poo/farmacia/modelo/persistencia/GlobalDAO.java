package br.ifsp.poo.farmacia.modelo.persistencia;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ifsp.poo.farmacia.modelo.entidade.EnumFuncionario;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.entidade.Global;

public class GlobalDAO implements IGlobalDAO {

	@Override
	public Funcionario recuperarLogado(String login) throws Exception {
		
		Funcionario fun = new Funcionario();
		
		PreparedStatement ps = null;
		
		try (Connection conn = MySqlConnection.getConnection()) {
			
			String query = "{call retornar_funcionario(?)}";
			ps = conn.prepareStatement(query);

			ps.setString(1, login);

			ResultSet result = ps.executeQuery();

			while (result.next()) {

				fun.setId(result.getInt("id"));
				fun.setNome(result.getString("nome_fun"));
				fun.setTipoFuncionario((result.getString("tipo_funcionario").equalsIgnoreCase(EnumFuncionario.ATENDENTE.toString()))
				? EnumFuncionario.ATENDENTE
						: EnumFuncionario.GERENTE);

				Global.setFuncionarioLogado(fun);	
			}
	
		} catch (SQLException e) {
			throw new SQLException("Erro ao recuperar o funcionário logado (BD).");
		} catch (Exception e) {
			throw new Exception("Erro ao recuperar o funcionário logado.");
		}
		return fun; 
	}
	

}
