package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.poo.farmacia.modelo.entidade.Produto;

public interface IProdutoDAO {
	
	public boolean insertProduto(Produto prod) throws SQLException;
	public boolean updateProduto(Produto prod) throws SQLException;
	public boolean deleteProduto(Produto prod) throws SQLException;
	public ArrayList<Produto> selectProduto(String filter) throws SQLException;
	public ArrayList<Produto> selectProduto() throws SQLException;
}
