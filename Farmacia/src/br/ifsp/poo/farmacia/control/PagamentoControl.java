package br.ifsp.poo.farmacia.control;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.entidade.Pagamento;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;
import br.ifsp.poo.farmacia.modelo.persistencia.IPagamentoDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.IVendaDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.PagamentoDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.VendaDAO;

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
	
	public double calcularDesconto(double total, Cliente cliente, String forma) {
		double desconto = 0;
		
		if(cliente == null && forma == "dinheiro") {
			return desconto = total * 0.05;
		}
		else if(cliente != null && forma == "dinheiro") {
			return desconto = total * 0.20;
		}
		else if(cliente != null && forma == "cartao") {
			return desconto = total * 0.20;
		}
		else {
			return desconto;
		}
	}

	public double calcularValorFinal(double total, double desconto) {
		return total - desconto;
	}
	
	public double calcularTroco(double pago, double total) {
		
		try {
			
			if(pago < total)
				throw new Exception("Valor pago inferior ao valor total da compra.");
			else {
				return pago - total;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return 0;
	}
	
	public void updateVenda(Venda venda) {
		IVendaDAO vendaDao = new VendaDAO(); 
		
		try {
			vendaDao.updateVenda(venda);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
