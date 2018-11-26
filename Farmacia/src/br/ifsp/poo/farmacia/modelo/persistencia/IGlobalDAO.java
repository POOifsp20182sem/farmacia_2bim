package br.ifsp.poo.farmacia.modelo.persistencia;

import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;

public interface IGlobalDAO {

	public Funcionario recuperarLogado(String login)  throws Exception;
}
