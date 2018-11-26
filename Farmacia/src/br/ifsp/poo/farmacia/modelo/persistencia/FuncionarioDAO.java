package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.ifsp.poo.farmacia.modelo.entidade.EnumFuncionario;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;

public class FuncionarioDAO implements IFuncionarioDAO {

	@Override
	public void insertFuncionario(Funcionario func) throws SQLException, Exception {

		PreparedStatement ps = null;

		try (Connection conn = MySqlConnection.getConnection()) {

			String query = "{call inserir_funcionario(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

			ps = conn.prepareStatement(query);

			ps.setString(1, func.getNome());
			ps.setString(2, func.getEmail());
			ps.setString(3, func.getEndereco());
			ps.setString(4, func.getTelefone());
			ps.setString(5, func.getCelular());
			ps.setString(6, func.getDocumento());
			ps.setString(7, (func.getDataNascimento().toString()));
			ps.setString(8, func.getTipoFuncionario().name());
			ps.setString(9, Double.toString(func.getSalario()));

			ps.execute();
			
			ILoginDAO loginDao = new LoginDAO();
			loginDao.insertLogin(func.getLogin());
			
		} catch (SQLException e) {
			throw new SQLException("Erro ao inserir funcion�rio." + e);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateFuncionario(Funcionario func) throws SQLException, Exception {
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

			ps.execute();

		} catch (SQLException e) {
			throw new SQLException("Erro ao alterar funcionário.");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public void deleteFuncionario(Funcionario func) throws SQLException, Exception {
		PreparedStatement ps = null;

		try (Connection conn = MySqlConnection.getConnection();) {
			String query = "{call excluir_funcionario(?) }";

			ps = conn.prepareStatement(query);

			ps.setInt(1, func.getId());

			ps.execute();
		} catch (SQLException e) {
			throw new SQLException("Erro ao deletar funcionário.");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public ArrayList<Funcionario> selectFuncionario(String filter) throws SQLException, Exception {

		PreparedStatement ps = null;

		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try (Connection conn = MySqlConnection.getConnection()) {
			String query = "{call buscar_funcionarios(?)}";
			ps = conn.prepareStatement(query);
			ps.setString(1, filter);

			ArrayList<Funcionario> funList = new ArrayList<Funcionario>();

			ResultSet resultado = ps.executeQuery();

			while (resultado.next()) {
				Funcionario func = new Funcionario();

				func.setId(resultado.getInt("id"));
				func.setNome(resultado.getString("nome"));
				func.setEmail(resultado.getString("email"));
				func.setEndereco(resultado.getString("endereco"));
				func.setTelefone(resultado.getString("telefone"));
				func.setCelular(resultado.getString("celular"));
				func.setDocumento(resultado.getString("cpf"));
				func.setDataNascimento(LocalDate.parse(resultado.getString("data_nascimento"), dtf));
				func.setTipoFuncionario(
						(resultado.getString("tipo_funcionario").equalsIgnoreCase(EnumFuncionario.ATENDENTE.toString()))
								? EnumFuncionario.ATENDENTE
								: EnumFuncionario.GERENTE);
				func.setSalario(resultado.getDouble("salario"));
				funList.add(func);
			}

			return funList;

		} catch (SQLException e) {
			throw new SQLException("Erro no banco de dados.");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public ArrayList<Funcionario> selectFuncionario() throws SQLException, Exception {
		return selectFuncionario("");
	}

	public Funcionario buscarFuncionario(int id) throws SQLException, Exception {
		Connection conn = null;
		PreparedStatement ps = null;

		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try {
			String query = "SELECT * FROM funcionario WHERE id = ?";

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);

			ps.setInt(1, id);

			ResultSet resultado = ps.executeQuery();

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
					(resultado.getString("tipo_funcionario").equalsIgnoreCase(EnumFuncionario.ATENDENTE.toString()))
							? EnumFuncionario.ATENDENTE
							: EnumFuncionario.GERENTE);
			f.setSalario(resultado.getDouble("salario"));

			return f;
		} catch (SQLException e) {
			throw new SQLException("Erro no banco de dados.");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
