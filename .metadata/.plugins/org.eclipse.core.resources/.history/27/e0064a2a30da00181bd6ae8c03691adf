package br.ifsp.farmacia.model.persistence;

import br.ifsp.farmacia.model.entities.ProdutosPedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Alice Lima
 * 
 * Classe responsavel pelo acesso ao banco de dados,
 * para manipulação dos produtos de uma venda
 */

public class ProdutosPedidosDAO implements IProdutosPedidosDAO {

	/* 
	 * @param produtoPedido o produto pedido para ser inserido
	 * @return o sucesso ou a falha na inserção
	 */
	@Override
	public boolean insertProdutoPedido(ProdutosPedidos produtoPedido) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "{call inserir_itens_pedido(?, ?, ?, ?)}";
			
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, produtoPedido.getProduto().getId());
			ps.setInt(2, produtoPedido.getVenda().getId());
			ps.setInt(3, produtoPedido.getQuantidade());
			ps.setDouble(4, produtoPedido.getValorItem());
			
			if(ps.executeUpdate() == 0)
				System.out.println("Erro ao inserir.");
			else {
				System.out.println("Dado inserido com sucesso.");
				return true;
			}
		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			conn.close();
		}
		return false;
	}

	/* 
	 * @param produtoPedido o produto pedido para ser removido
	 * @return o sucesso ou a falha na remoção
	 */
	@Override
	public boolean removeProdutoPedido(ProdutosPedidos produtoPedido) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "{call excluir_itens_pedido(?, ?)}";
			
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, produtoPedido.getProduto().getId());
			ps.setInt(2, produtoPedido.getVenda().getId());
			
			if(ps.executeUpdate() == 0)
				System.out.println("Erro ao excluir.");
			else {
				System.out.println("Dado excluído com sucesso.");
				return true;
			}
		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			conn.close();
		}
		return false;
	}

	/* 
	 * @param produtoPedido o produto pedido para ser alterado
	 * @return o sucesso ou a falha na alteração
	 */
	@Override
	public boolean updateProdutoPedido(ProdutosPedidos produtoPedido, ProdutosPedidos produtoPedidoNew) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "{call alterar_itens_pedido(?, ?, ?, ?, ?, ?)}";
			
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, produtoPedido.getProduto().getId());
			ps.setInt(2, produtoPedido.getVenda().getId());
			ps.setInt(3, produtoPedidoNew.getProduto().getId());
			ps.setInt(4, produtoPedidoNew.getVenda().getId());
			ps.setInt(5, produtoPedidoNew.getQuantidade());
			ps.setDouble(6, produtoPedidoNew.getValorItem());
			
			if(ps.executeUpdate() == 0)
				System.out.println("Erro ao alterar.");
			else {
				System.out.println("Dado alterado com sucesso.");
				return true;
			}
		} catch (Exception e){
			e.printStackTrace();
			
		} finally {
			conn.close();
		}
		return false;
	}

	
}
