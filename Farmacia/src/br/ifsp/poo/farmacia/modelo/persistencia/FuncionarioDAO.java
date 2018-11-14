package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import br.ifsp.poo.farmacia.modelo.entidade.EnumCliente;
import br.ifsp.poo.farmacia.modelo.entidade.EnumFuncionario;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;

public class FuncionarioDAO implements IFuncionarioDAO{
	
	@Override
	public boolean insertFuncionario(Funcionario func) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String query = "{call inserir_funcionario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setString(1, func.getNome());
			ps.setString(2, func.getEmail());	
			ps.setString(3, func.getEndereco());
			ps.setString(4, func.getTelefone());
			ps.setString(5, func.getCelular());
			ps.setString(6, func.getDocumento());
			ps.setString(7, func.getStrDataNascimento());
			ps.setString(8, func.getTipoFuncionario().toString());
			ps.setString(9, Double.toString(func.getSalario()));
			ps.setString(10, func.getUser());
			ps.setString(11, func.getSenha());


			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao inserir!");
			}
			else {
				System.out.println("Dado inserido com sucesso!");
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return false;
	}

	@Override
	public boolean updateFuncionario(Funcionario func) throws SQLException {
		PreparedStatement ps = null;
		Connection conn = null;
		
		try {
			String query = "{call alterar_funcionario(?,?,?,?,?,?,?,?,?,?,?,?) }"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, func.getId());
			ps.setString(2, func.getNome());
			ps.setString(3, func.getEmail());
			ps.setString(4, func.getEndereco());
			ps.setString(5, func.getTelefone());
			ps.setString(6, func.getCelular());
			ps.setString(7, func.getDocumento());
			ps.setString(8, func.getStrDataNascimento());
			ps.setString(9, func.getTipoFuncionario().toString());
			ps.setDouble(10, func.getSalario());
			ps.setString(11, func.getUser());
			ps.setString(12, func.getSenha());

			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao atualizar!");
			} else {
				System.out.println("Dado atualizado com sucesso!");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return false;
	}

	@Override
	public boolean deleteFuncionario(Funcionario func) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "{call excluir_funcionario(?) }"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, func.getId());

			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao excluir!");
			} else {
				System.out.println("Dado excluido com sucesso!");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return false;
	}

	@Override
	public ArrayList<Funcionario> selectFuncionario(String filter) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		try {
			String query = "{call buscar_funcionarios(?)}";
			
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);
			
			ps.setString(1, filter);
			
			ResultSet resultado = ps.executeQuery();
			ArrayList<Funcionario> funList = new ArrayList<Funcionario>();
			
			while(resultado.next()) {
				Funcionario f = new Funcionario();
				f.setId(resultado.getInt("id"));
				f.setNome(resultado.getString("nome"));
				f.setEmail(resultado.getString("email"));
				f.setEndereco(resultado.getString("endereco"));
				f.setTelefone(resultado.getString("telefone"));
				f.setCelular(resultado.getString("celular"));
				f.setDocumento(resultado.getString("cpf"));
				f.setDataNascimento(LocalDate.parse(resultado.getString("data_nascimento"), dtf));
				f.setTipoFuncionario(
						(resultado.getString("tipo_funcionario").
								equalsIgnoreCase(EnumFuncionario.ATENDENTE.toString()))? 
										EnumFuncionario.ATENDENTE:EnumFuncionario.GERENTE);
				f.setSalario(resultado.getDouble("salario"));
				f.setUser("login");
				f.setSenha("senha");
				
				funList.add(f);
			}
			conn.close();
			
			return funList;
					
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Funcionario> selectFuncionario() throws SQLException {
		return selectFuncionario("");
	}
	
	public Funcionario buscarFuncionario(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		try {
			String query = "SELECT * FROM funcionario WHERE id = ?";
			
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				Funcionario f = new Funcionario();
				f.setId(resultado.getInt("id"));
				f.setNome(resultado.getString("nome"));
				f.setEmail(resultado.getString("email"));
				f.setEndereco(resultado.getString("endereco"));
				f.setTelefone(resultado.getString("telefone"));
				f.setCelular(resultado.getString("celular"));
				f.setDocumento(resultado.getString("cpf"));
				f.setDataNascimento(LocalDate.parse(resultado.getString("data_nascimento"), dtf));
				f.setTipoFuncionario(
						(resultado.getString("tipo_funcionario").
								equalsIgnoreCase(EnumFuncionario.ATENDENTE.toString()))? 
										EnumFuncionario.ATENDENTE:EnumFuncionario.GERENTE);
				f.setSalario(resultado.getDouble("salario"));
				
				return f;
			}
		conn.close();			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

