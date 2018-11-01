package br.ifsp.poo.farmacia.testes;

import java.sql.SQLException;
import java.util.Date;

import br.ifsp.poo.farmacia.modelo.entidade.EnumPagamento;
import br.ifsp.poo.farmacia.modelo.entidade.Pagamento;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;
import br.ifsp.poo.farmacia.modelo.persistencia.PagamentoDAO;

public class TestePagamento {

	public static void main(String[] args) {
		
		Venda venda = new Venda();
	
		venda.setId(2);
		venda.setTotal(100);
		venda.setDesconto(10);
	
		Pagamento pagamento = new Pagamento();
		
		Date dataPagamento = new Date();
		dataPagamento.getTime();
		
		pagamento.setVenda(venda);
		pagamento.setDataPagamento(dataPagamento);
		pagamento.setFormaPagamento(EnumPagamento.CARTAO);
		pagamento.setValorPago(venda.getTotal() - venda.getDesconto());
		
		PagamentoDAO pagDao = new PagamentoDAO();
		
		try {
			pagDao.insertPagamento(pagamento);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pagamento.setId(2);
		try {
			pagDao.removePagamento(pagamento);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}