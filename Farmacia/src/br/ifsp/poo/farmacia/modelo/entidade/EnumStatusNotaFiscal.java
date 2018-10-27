package br.ifsp.poo.farmacia.modelo.entidade;

public enum EnumStatusNotaFiscal {
	AUTORIZADA("autorizada"), CANCELADA("cancelada"), PROCESSANDO("processando");

	private String status;

	private EnumStatusNotaFiscal(String status) {
		this.status = status;
	}

	public String getFormaFarmaco() {
		return status;
	}
}
