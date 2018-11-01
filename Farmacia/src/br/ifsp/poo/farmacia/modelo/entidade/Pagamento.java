package br.ifsp.poo.farmacia.modelo.entidade;

import java.util.Date;

/**
 * @author Alice Lima
 * Classe responsável pela modelagem de pagamentos
 */
public class Pagamento {

	private int id;
	private Venda venda;
	private double valorPago;
	private Date dataPagamento;
	private EnumPagamento formaPagamento;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public double getValorPago() {
		return valorPago;
	}
	
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
	public Date getDataPagamento() {
		return dataPagamento;
	}
	
	/*
	 * Método para pegar a data de pagamento formatada para o sql
	 */
	public java.sql.Date getDataPagamentoSql() {
		return new java.sql.Date(dataPagamento.getTime());
	}
	
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	public String getFormaPagamento() {
		return formaPagamento.getFormaPagamento();
	}
	
	public void setFormaPagamento(EnumPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return "Pagamento [id = " + id + "venda = " + venda + ", valor Pago = " + valorPago + ", data Pagamento = " + dataPagamento
				+ ", forma Pagamento = " + formaPagamento + "]";
	}
	
	
}
