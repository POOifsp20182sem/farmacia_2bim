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

			String query = "{call inserir_cliente(?, ?, ?, ?, ?, ?, ?)}"; 

			ps = conn.prepareStatement(query);

			ps.setString(1, cli.getNome());
			ps.setString(2, cli.getEmail());
			ps.setString(3, cli.getEndereco().toString());
			ps.setString(4, cli.getTelefone());
			ps.setString(5, cli.getCelular());
			ps.setString(6, cli.getDocumento());
			ps.setString(7, cli.getDataNascFormatado());

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}

	@Override
	public void updateCliente(Cliente cli) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {

			String query = "{call alterar_cliente(?, ?, ?, ?, ?, ?, ?, ?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, cli.getId());
			ps.setString(2, cli.getNome());
			ps.setString(3, cli.getEmail());
			ps.setString(4, cli.getEndereco().toString());
			ps.setString(5, cli.getTelefone());
			ps.setString(6, cli.getCelular());
			ps.setString(7, cli.getDocumento());
			ps.setString(8, cli.getDataNascFormatado());


		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}

	@Override
	public void deleteCliente(Cliente cli) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String query = "{call excluir_cliente(?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, cli.getId());

			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn.close();
			}
		}

		@Override
		public ArrayList<Cliente> selectCliente(String filter) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;

			ArrayList<Cliente> listClientes = new ArrayList<>();
			Cliente cli = new Cliente();

			final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			try {
				String query = "{call buscar_clientes(?)}"; 

				conn = MySqlConnection.getConnection();
				ps = conn.prepareStatement(query);		

				ps.setString(1, filter);

				ResultSet result = ps.executeQuery();
			
				while(result.next()) {
					cli = new Cliente();

					cli.setId(result.getInt("id"));
					cli.setNome(result.getString("nome"));
					cli.setEmail(result.getString("email"));
					cli.setTelefone(result.getString("telefone"));
					cli.setCelular(result.getString("celular"));
					cli.setDataNascimento(LocalDate.parse(result.getString("data_nascimento"), dtf));

					listClientes.add(cli);
				}

			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn.close();
			}

			return listClientes;

		}

		@Override
		public ArrayList<Cliente> selectCliente() throws SQLException {
			return selectCliente("");
		}

		public Cliente buscarCliente(int id) throws SQLException {

			Connection conn = null;
			PreparedStatement ps = null;

			Cliente cli = new Cliente();

			final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			try {
				String query = "SELECT id, nome, email, endereco, telefone, celular, cpf, data_nascimento FROM cliente WHERE id = ?;";

				conn = MySqlConnection.getConnection();
				ps = conn.prepareStatement(query);		

				ps.setInt(1, id);

				ResultSet result = ps.executeQuery();

				while(result.next()) {
					cli = new Cliente();

					cli.setId(result.getInt("id"));
					cli.setNome(result.getString("nome"));
					cli.setEmail(result.getString("email"));
					cli.setTelefone(result.getString("telefone"));
					cli.setCelular(result.getString("celular"));
					cli.setEndereco(result.getString("endereco"));
					cli.setDataNascimento(LocalDate.parse(result.getString("data_nascimento"), dtf));

					return cli;
				}

			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn.close();
			}
			return null;
		}
	}
