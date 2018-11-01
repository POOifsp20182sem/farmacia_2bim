package br.ifsp.poo.farmacia.modelo.entidade;

public enum EnumPagamento {

	CARTAO ("cartao"), DINHEIRO ("dinheiro");
	
	private String formaPagamento;
	
	private EnumPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}
}
