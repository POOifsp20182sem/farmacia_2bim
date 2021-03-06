package br.ifsp.poo.farmacia.modelo.entidade;

/**
 * @author Alice Lima
 * 
 *         Classe responsável por modelar os produtos de uma venda
 */
public class ProdutosPedidos {

	private Venda venda;
	private Produto produto;
	private int quantidade;
	private double valorItem;

	/**
	 * @return a venda
	 */
	public Venda getVenda() {
		return venda;
	}

	/**
	 * @param venda a venda para atribuir
	 */
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	/**
	 * @return o produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @param produto o produto para atribuir
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * @return a quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade a quantidade para atribuir
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return o valorItem
	 */
	public double getValorItem() {
		return valorItem;
	}

	/**
	 * @param valorItem o valorItem para atribuir
	 */
	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}
}
