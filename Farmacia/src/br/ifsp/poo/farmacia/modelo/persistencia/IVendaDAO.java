package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.poo.farmacia.modelo.entidade.Venda;

public interface IVendaDAO {
	
	public void insertVenda(Venda ven) throws SQLException, Exception;
	public void updateVenda(Venda ven) throws SQLException, Exception;
	public void deleteVenda(Venda ven) throws SQLException, Exception;
	public ArrayList<Venda> selectVenda(String filter) throws SQLException, Exception;
	public ArrayList<Venda> selectVenda() throws SQLException, Exception;
}
