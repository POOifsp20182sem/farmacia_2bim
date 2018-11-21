package br.ifsp.poo.farmacia.control;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.ifsp.poo.farmacia.modelo.entidade.Pagamento;
import br.ifsp.poo.farmacia.modelo.persistencia.IPagamentoDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.PagamentoDAO;

/**
 * @author Alice Lima
 * 
 * Classe responsável por fazer o controle da interface gráfica Pagamento
 * Fazendo a mediação entre a view e o modelo
 */
public class PagamentoControl {

	IPagamentoDAO pagDao = new PagamentoDAO();
	
	public void insertPagamento(Pagamento pagamento) {
		try {
			pagDao.insertPagamento(pagamento);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void removePagamento(Pagamento pagamento) {
		try {
			pagDao.removePagamento(pagamento);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	// TODO: verificar como irão ser realizados
	/*public NotaFiscal emitirNotaFiscal() {
		
	}
	
	public void reduzirEstoque(){
	
	}*/
	
}
