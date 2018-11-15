package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.SQLException;

import br.ifsp.poo.farmacia.modelo.entidade.ProdutosPedidos;

/**
 * @author Alice Lima
 * 
 * Interface responsavel por definir os metodos que sao implementados
 * pela classe ProdutosPedidosDAO. Usada para o uso do padrao de projeto
 * MVC.
 */

public interface IProdutosPedidosDAO {

	public void insertProdutoPedido(ProdutosPedidos produtoPedido) throws SQLException, Exception;
	public void removeProdutoPedido(ProdutosPedidos produtoPedido) throws SQLException, Exception;
	public void updateProdutoPedido(ProdutosPedidos produtoPedido, ProdutosPedidos produtoPedidoNew)
			throws SQLException, Exception;
}
