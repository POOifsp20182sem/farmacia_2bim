package br.ifsp.poo.farmacia.control;

import java.sql.SQLException;

import br.ifsp.poo.farmacia.modelo.entidade.Pagamento;
import br.ifsp.poo.farmacia.modelo.persistencia.PagamentoDAO;

/**
 * @author Alice Lima
 * Classe respons�vel por fazer o controle da interface gr�fica Pagamento
 * Fazendo a media��o entre a view e o modelo
 */
public class PagamentoControl {

	PagamentoDAO pagDao = new PagamentoDAO();
	
	public boolean insertPagamento(Pagamento pagamento) {
		try {
			return pagDao.insertPagamento(pagamento);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean removePagamento(Pagamento pagamento) {
		try {
			return pagDao.removePagamento(pagamento);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// TODO: verificar como ir�o ser realizados
	/*public NotaFiscal emitirNotaFiscal() {
		
	}
	
	public void reduzirEstoque(){
	
	}*/
	
}
