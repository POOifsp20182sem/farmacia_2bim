package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ifsp.poo.farmacia.modelo.entidade.ProdutosPedidos;

/**
 * @author Alice Lima
 * 
 * Classe responsavel pelo acesso ao banco de dados, para manipulacao
 * dos produtos de uma venda
 */

public class ProdutosPedidosDAO implements IProdutosPedidosDAO {

	/*
	 * @param produtoPedido o produto pedido para ser inserido
	 */
	@Override
	public void insertProdutoPedido(ProdutosPedidos produtoPedido) throws SQLException, Exception {
		PreparedStatement ps = null;

		try (Connection conn = MySqlConnection.getConnection()) {
			
			String query = "{call inserir_itens_pedido(?, ?, ?, ?)}";
			ps = conn.prepareStatement(query);

			ps.setInt(1, produtoPedido.getProduto().getId());
			ps.setInt(2, produtoPedido.getVenda().getId());
			ps.setInt(3, produtoPedido.getQuantidade());
			ps.setDouble(4, produtoPedido.getValorItem());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new SQLException("Erro ao inserir o produto pedido no banco.");
		} catch (Exception e) {
			throw new Exception("Erro ao inserir o produto pedido.");
		} 
	}

	/*
	 * @param produtoPedido o produto pedido para ser removido
	 */
	@Override
	public void removeProdutoPedido(ProdutosPedidos produtoPedido) throws SQLException, Exception {
		PreparedStatement ps = null;

		try (Connection conn = MySqlConnection.getConnection()) {
			
			String query = "{call excluir_itens_pedido(?, ?)}";
			ps = conn.prepareStatement(query);

			ps.setInt(1, produtoPedido.getProduto().getId());
			ps.setInt(2, produtoPedido.getVenda().getId());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new SQLException("Erro ao excluir o produto pedido no banco.");
		} catch (Exception e) {
			throw new Exception("Erro ao excluir o produto pedido.");
		} 
	}

	/*
	 * @param produtoPedido o produto pedido para ser alterado
	 */
	@Override
	public void updateProdutoPedido(ProdutosPedidos produtoPedido, ProdutosPedidos produtoPedidoNew)
			throws SQLException, Exception {

		PreparedStatement ps = null;

		try (Connection conn = MySqlConnection.getConnection()) {
			
			String query = "{call alterar_itens_pedido(?, ?, ?, ?, ?, ?)}";;
			ps = conn.prepareStatement(query);

			ps.setInt(1, produtoPedido.getProduto().getId());
			ps.setInt(2, produtoPedido.getVenda().getId());
			ps.setInt(3, produtoPedidoNew.getProduto().getId());
			ps.setInt(4, produtoPedidoNew.getVenda().getId());
			ps.setInt(5, produtoPedidoNew.getQuantidade());
			ps.setDouble(6, produtoPedidoNew.getValorItem());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new SQLException("Erro ao atualizar o produto pedido no banco.");
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar o produto pedido.");
		} 
	}
}