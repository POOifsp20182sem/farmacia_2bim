package br.ifsp.poo.farmacia.control;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.poo.farmacia.modelo.entidade.ClasseTerapeutica;
import br.ifsp.poo.farmacia.modelo.entidade.PrincipioAtivo;
import br.ifsp.poo.farmacia.modelo.entidade.Produto;
import br.ifsp.poo.farmacia.modelo.persistencia.ProdutoDAO;


public class ProdutoControl {

	private ProdutoDAO pd = new ProdutoDAO();

	public boolean cadastrarProduto(Produto prod) throws SQLException {
		return pd.insertProduto(prod);
	}

	public boolean atualizarProduto(Produto prod) throws SQLException {
		return pd.updateProduto(prod);
	}
	
	public boolean deletarProduto(Produto prod) throws SQLException {
		return pd.deleteProduto(prod);
	}
	
	public ArrayList<Produto> listarProduto (String prod) throws SQLException {
		return pd.selectProduto(null);
	}
	
	public ArrayList<Produto> listarProduto () throws SQLException {
		return pd.selectProduto(null);
	}
	
	public ArrayList<ClasseTerapeutica> listarClasseTerapeutica() throws SQLException{
		return pd.selectClasseTerapeutica();
	}
	
	public ArrayList<PrincipioAtivo> listarPrincipioAtivo() throws SQLException{
		return pd.selectPrincipioAtivo();
	}
}
