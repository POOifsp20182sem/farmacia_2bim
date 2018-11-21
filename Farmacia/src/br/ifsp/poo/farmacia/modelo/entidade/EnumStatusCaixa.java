package br.ifsp.poo.farmacia.modelo.entidade;

import java.util.HashMap;
import java.util.Map;

public enum EnumStatusCaixa {
	ABERTO("ABERTO"), FECHADO("FECHADO");

	private String status;

	private static Map<String, EnumStatusCaixa> opcoes = new HashMap<String, EnumStatusCaixa>();

	static {
		for (EnumStatusCaixa scaixa : EnumStatusCaixa.values())
			opcoes.put(scaixa.getStatusCaixa(), scaixa);
	}

	private EnumStatusCaixa(String status) {
		this.status = status;
	}

	public String getStatusCaixa() {
		return status;
	}

	public static EnumStatusCaixa ofValue(String value) {
		return opcoes.get(value);
	}
}
