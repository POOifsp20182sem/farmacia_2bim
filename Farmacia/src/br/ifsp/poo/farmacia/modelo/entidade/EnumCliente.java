package br.ifsp.poo.farmacia.modelo.entidade;

public enum EnumCliente {
	FISICA("fisica"), JURIDICA("juridica");

	private String tipoCliente;

	private EnumCliente(String tipo) {
		this.tipoCliente = tipo;
	}

	@SuppressWarnings("unused")
	private String getTipoCliente() {
		return this.tipoCliente;
	}

}