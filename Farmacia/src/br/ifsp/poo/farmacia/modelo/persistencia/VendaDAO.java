package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.entidade.ProdutosPedidos;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;

public class VendaDAO implements IVendaDAO {

	@Override
	public void insertVenda(Venda ven) throws SQLException, Exception {
		PreparedStatement ps = null;
		
		try (Connection conn = MySqlConnection.getConnection()) {
			
			String query = "{call inserir_pedido(?, ?, ?, ?, ?)}";
			ps = conn.prepareStatement(query);

			ps.setInt(1, ven.getCliente().getId());
			ps.setInt(2, ven.getFuncionario().getId());
			ps.setDouble(3, ven.getDesconto());
			ps.setDouble(4, ven.getTotal());
			ps.setDate(5, ven.getData());

			ps.executeUpdate();		
			
			/*ArrayList<ProdutosPedidos> produtos = ven.getProdutos();
			ProdutosPedidosDAO ppDao = new ProdutosPedidosDAO();
			
			for(ProdutosPedidos pp : produtos) {
				ppDao.insertProdutoPedido(pp);
			}*/
			
		} catch (SQLException e) {
			throw new SQLException("Erro ao inserir o pedido no banco.");
		} catch (Exception e) {
			throw new Exception("Erro ao inserir o pedido.");
		} 
	}

	@Override
	public void updateVenda(Venda ven) throws SQLException, Exception {
		PreparedStatement ps = null;
		try (Connection conn = MySqlConnection.getConnection()) {
			
			String query = "{call alterar_pedido(?, ?, ?, ?, ?, ?)}";
			ps = conn.prepareStatement(query);

			ps.setInt(1, ven.getId());
			ps.setInt(2, ven.getCliente().getId());
			ps.setInt(3, ven.getFuncionario().getId());
			ps.setDouble(4, ven.getDesconto());
			ps.setDouble(5, ven.getTotal());
			ps.setDate(6, ven.getData());

			ps.executeUpdate();
			
			ArrayList<ProdutosPedidos> produtos = ven.getProdutos();
			ProdutosPedidosDAO ppDao = new ProdutosPedidosDAO();
			
			for(ProdutosPedidos pp : produtos) {
				ppDao.insertProdutoPedido(pp);
			}
			
		} catch (SQLException e) {
			throw new SQLException("Erro ao atualizar o pedido no banco.");
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar o pedido.");
		} 
	}

	@Override
	public void deleteVenda(int id) throws SQLException, Exception {
		PreparedStatement ps = null;
		try (Connection conn = MySqlConnection.getConnection()) {

			String query = "{call excluir_pedido(?)}";
			ps = conn.prepareStatement(query);

			ps.setInt(1, id);

			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new SQLException("Erro ao excluir o pedido do banco.");
		} catch (Exception e) {
			throw new Exception("Erro ao excluir o pedido.");
		} 
	}

	@Override
	public ArrayList<Venda> selectVenda(String filter) throws SQLException, Exception {	
		PreparedStatement ps = null;

		ArrayList<Venda> listVendas = new ArrayList<>();
		Venda ven = new Venda();

		try (Connection conn = MySqlConnection.getConnection()) {
			
			String query = "{call buscar_pedidos(?)}";
			ps = conn.prepareStatement(query);

			ps.setString(1, filter);

			ResultSet result = ps.executeQuery();

			while (result.next()) {
				ven = new Venda();

				Cliente cli = new Cliente();
				Funcionario fun = new Funcionario();

				cli.setId(result.getInt("cliente_id"));
				cli.setNome(result.getString("nome"));

				fun.setId(result.getInt("funcionario_id"));
				fun.setNome(result.getString("nome_fun"));

				ven.setId(result.getInt("id"));
				ven.setCliente(cli);
				ven.setFuncionario(fun);
				ven.setTotal(result.getDouble("total"));
				ven.setDesconto(result.getDouble("desconto"));
				ven.setData(result.getDate("data_compra"));

				listVendas.add(ven);	
			}
			
			return listVendas;
			
		} catch (SQLException e) {
			throw new SQLException("Erro ao buscar o pedido no banco.");
		} catch (Exception e) {
			throw new Exception("Erro ao buscar o pedido.");
		} 
		
	}

	@Override
	public ArrayList<Venda> selectVenda() throws SQLException, Exception {
		PreparedStatement ps = null;

		ArrayList<Venda> listVendas = new ArrayList<>();
		Venda ven = new Venda();

		try (Connection conn = MySqlConnection.getConnection() ) {
			
			String query = "{call buscar_pedidos(?)}";
			ps = conn.prepareStatement(query);

			ps.setString(1, "");

			ResultSet result = ps.executeQuery();

			while (result.next()) {
				ven = new Venda();

				Cliente cli = new Cliente();
				Funcionario fun = new Funcionario();

				cli.setId(result.getInt("cliente_id"));
				cli.setNome(result.getString("nome"));

				fun.setId(result.getInt("funcionario_id"));
				fun.setNome(result.getString("nome_fun"));

				ven.setId(result.getInt("id"));
				ven.setCliente(cli);
				ven.setFuncionario(fun);
				ven.setTotal(result.getDouble("total"));
				ven.setDesconto(result.getDouble("desconto"));
				ven.setData(result.getDate("data_compra"));

				listVendas.add(ven);
			}
			
			return listVendas;
			
		} catch (SQLException e) {
			throw new SQLException("Erro ao buscar o pedido no banco.");
		} catch (Exception e) {
			throw new Exception("Erro ao buscar o pedido.");
		} 	
	}
}
