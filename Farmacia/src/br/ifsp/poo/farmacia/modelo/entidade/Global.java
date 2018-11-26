package br.ifsp.poo.farmacia.modelo.entidade;

public class Global {

	private static Funcionario funcionarioLogado;

	public static Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	public static void setFuncionarioLogado(Funcionario funLogado) {
		funcionarioLogado = funLogado;
	}
}
