package br.ifsp.poo.farmacia.modelo.entidade;

public class CaixaSingleton {
	private static final Caixa caixa = new Caixa();

	public static Caixa getInstance() {
		return caixa;
	}
}
