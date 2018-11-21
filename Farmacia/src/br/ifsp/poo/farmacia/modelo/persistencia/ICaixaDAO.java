package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.poo.farmacia.modelo.entidade.Caixa;

public interface ICaixaDAO {
	public void insertCaixa(Caixa caixa) throws SQLException, Exception;

	public void updateCaixa(Caixa caixa) throws SQLException, Exception;

	public void removeCaixa(Caixa caixa) throws SQLException, Exception;

	public ArrayList<Caixa> selectCaixa(String filtro) throws SQLException, Exception;
}
