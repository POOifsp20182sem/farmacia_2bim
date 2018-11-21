package br.ifsp.poo.farmacia.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import br.ifsp.poo.farmacia.modelo.entidade.Caixa;
import br.ifsp.poo.farmacia.modelo.persistencia.CaixaDAO;

public class CaixaControl {
	private static final Logger logger = Logger.getLogger(CaixaControl.class.getName());
	private CaixaDAO caixaDao = new CaixaDAO();

	public void inserirCaixa(Caixa caixa) throws SQLException, Exception {
		caixaDao.insertCaixa(caixa);
	}

	public void alterarCaixa(Caixa caixa) throws SQLException, Exception {
		caixaDao.updateCaixa(caixa);
	}

	public void removerCaixa(Caixa caixa) throws SQLException, Exception {
		caixaDao.removeCaixa(caixa);
	}

	public ArrayList<Caixa> listarCaixas(String filtro) throws SQLException, Exception {
		return caixaDao.selectCaixa(filtro);
	}

	public ArrayList<Caixa> listarCaixas() throws SQLException, Exception {
		return caixaDao.selectCaixa();
	}
}
