package br.ifsp.poo.farmacia.modelo.percistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.poo.farmacia.modelo.entidade.Venda;

public interface IVendaDAO {
	public boolean insertVenda(Venda ven) throws SQLException;

	public boolean updateVenda(Venda ven) throws SQLException;

	public boolean deleteVenda(Venda ven) throws SQLException;

	public ArrayList<Venda> selectVenda(String filter) throws SQLException;

	public ArrayList<Venda> selectVenda() throws SQLException;
}
