package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import br.ifsp.poo.farmacia.modelo.entidade.Cliente;


public class ClienteDAO implements IClienteDAO {

	@Override
	public void insertCliente(Cliente cli) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = MySqlConnection.getConnection();

			String query = "{call inserir_cliente(?, ?, ?, ?, ?, ?, ?, ?)}"; 

			ps = conn.prepareStatement(query);

			ps.setString(1, cli.getNome());
			ps.setString(2, cli.getEmail());
			ps.setString(3, cli.getEndereco());
			ps.setString(4, cli.getTelefone());
			ps.setString(5, cli.getCelular());
			ps.setString(6, cli.getDocumento());
			ps.setString(7, (cli.getDataNascimento().toString()));
			if(cli.isEspecial()==true) {
				ps.setBoolean(8, true);
			}
			else if(cli.isEspecial()==false) {
				ps.setBoolean(8, false);
			}
			
			ps.execute();

		} catch (SQLException e) {
			throw new SQLException("Erro ao inserir cliente." + e);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateCliente(Cliente cli) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;

		try {

			String query = "{call alterar_cliente(?, ?, ?, ?, ?, ?, ?, ?, ?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, cli.getId());
			ps.setString(2, cli.getNome());
			ps.setString(3, cli.getEmail());
			ps.setString(4, cli.getEndereco());
			ps.setString(5, cli.getTelefone());
			ps.setString(6, cli.getCelular());
			ps.setString(7, cli.getDocumento());
			ps.setString(8, (cli.getDataNascimento().toString()));
			if(cli.isEspecial()==true) {
				ps.setInt(9, 1);
			}
			else if(cli.isEspecial()==false) {
				ps.setInt(9, 0);
			}

			ps.execute();

		} catch (SQLException e) {
			throw new SQLException("Erro ao alterar cliente." + e);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void deleteCliente(Cliente cli) throws SQLException, Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String query = "{call excluir_cliente(?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, cli.getId());

			ps.execute();
		} catch (SQLException e) {
			throw new SQLException("Erro ao deletar cliente." + e);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public ArrayList<Cliente> selectCliente(String filter) throws SQLException, Exception {
		PreparedStatement ps = null;

		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try (Connection conn = MySqlConnection.getConnection()) {
			ArrayList<Cliente> listClientes = new ArrayList<>();
			Cliente cli = new Cliente();
			String query = "{call buscar_clientes(?)}"; 
			ps = conn.prepareStatement(query);		

			ps.setString(1, filter);

			ResultSet result = ps.executeQuery();

			while(result.next()) {
				cli = new Cliente();

				cli.setId(result.getInt("id"));
				cli.setNome(result.getString("nome"));
				cli.setEmail(result.getString("email"));
				cli.setEndereco(result.getString("endereco"));
				cli.setTelefone(result.getString("telefone"));
				cli.setCelular(result.getString("celular"));
				cli.setDocumento(result.getString("cpf"));
				cli.setDataNascimento(LocalDate.parse(result.getString("data_nascimento"), dtf));
				if(result.getInt("especial")==1) {
					cli.setEspecial(true);
				}else if(result.getInt("especial")==0) {
					cli.setEspecial(false);
				}

				listClientes.add(cli);
			}
			return listClientes;

		} catch (SQLException e) {
			throw new SQLException("Erro no banco de dados." + e);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public ArrayList<Cliente> selectCliente() throws SQLException, Exception {
		return selectCliente("");
	}

	public Cliente buscarCliente(int id) throws SQLException, Exception {

		Connection conn = null;
		PreparedStatement ps = null;

		Cliente cli = new Cliente();

		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try {
			String query = "SELECT * FROM cliente WHERE id = ?;";

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, id);

			ResultSet result = ps.executeQuery();

			while(result.next()) {
				cli.setId(result.getInt("id"));
				cli.setNome(result.getString("nome"));
				cli.setEmail(result.getString("email"));
				cli.setTelefone(result.getString("telefone"));
				cli.setCelular(result.getString("celular"));
				cli.setEndereco(result.getString("endereco"));
				cli.setDocumento(result.getString("cpf"));
				cli.setDataNascimento(LocalDate.parse(result.getString("data_nascimento"), dtf));
				if(result.getInt("especial")==1) {
					cli.setEspecial(true);
				}else if(result.getInt("especial")==0) {
					cli.setEspecial(false);
				}
			}
			return cli;
		} catch (SQLException e) {
			throw new SQLException("Erro no banco de dados." + e);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
