package br.ifsp.poo.farmacia.testes;

import java.util.Date;
import br.ifsp.poo.farmacia.modelo.entidade.EnumPagamento;
import br.ifsp.poo.farmacia.modelo.entidade.Pagamento;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;
import br.ifsp.poo.farmacia.modelo.persistencia.PagamentoDAO;

public class TestePagamento {

	public static void main(String[] args) throws Exception {
		
		Venda venda = new Venda();
	
		venda.setId(2);
		venda.setTotal(100);
		venda.setDesconto(10);
	
		Pagamento pagamento = new Pagamento();
		
		Date dataPagamento = new Date();
		dataPagamento.getTime();
		
		pagamento.setVenda(venda);
		pagamento.setDataPagamento(dataPagamento);
		pagamento.setFormaPagamento(EnumPagamento.DINHEIRO);
		pagamento.setValorPago(venda.getTotal() - venda.getDesconto());
		
		/*PagamentoDAO pagDao = new PagamentoDAO();
		
		pagDao.insertPagamento(pagamento);
		
		pagamento.setId(2);
	
		pagDao.removePagamento(pagamento);*/
		
		System.out.println(pagamento.getFormaPagamento());
	}
}