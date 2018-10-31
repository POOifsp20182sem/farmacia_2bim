package br.ifsp.poo.farmacia.testes;

import java.sql.SQLException;

import br.ifsp.poo.farmacia.modelo.entidade.Produto;
import br.ifsp.poo.farmacia.modelo.entidade.ProdutosPedidos;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;
import br.ifsp.poo.farmacia.modelo.persistencia.ProdutosPedidosDAO;

public class TesteProdutosPedidos {

	public static void main(String[] args) throws SQLException {

		ProdutosPedidosDAO ppDao = new ProdutosPedidosDAO();
		ProdutosPedidos pp = new ProdutosPedidos();
		Produto produto = new Produto();
		Venda venda = new Venda();

		produto.setId(7);
		venda.setId(3);

		pp.setProduto(produto);
		pp.setVenda(venda);
		pp.setQuantidade(4);
		pp.setValorItem(pp.getQuantidade() * 3.8);

		System.out.println(ppDao.insertProdutoPedido(pp));

		// System.out.println(ppDao.removeProdutoPedido(pp));

		ProdutosPedidos pp2 = new ProdutosPedidos();

		pp2.setProduto(produto);
		pp2.setVenda(venda);
		pp2.setQuantidade(2);
		pp2.setValorItem(pp.getQuantidade() * 3.8);

		System.out.println(ppDao.updateProdutoPedido(pp, pp2));
	}

}
