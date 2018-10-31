package br.ifsp.poo.farmacia.testes;

import org.junit.Before;
import org.junit.Test;

import br.ifsp.poo.farmacia.modelo.entidade.Criptografia;
import br.ifsp.poo.farmacia.modelo.entidade.Login;

public class TesteLogin {
	
	@Before
	public void inicializa() {
		try {
			Criptografia.inicializa();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testeValidaSenhaLogin() throws Exception {
		//MockLoginDAO simula o funcionamento do DAO
		String senha = Criptografia.criptografarSenha("1234");
		MockLoginDAO dao = new MockLoginDAO();
		dao.criaUsuarioTeste("admin", "1234");
		dao.validarLogin(new Login("admin",senha));	
	}
	
	@Test(expected = Exception.class)
	public void testeValidaSenhaLoginComErro() throws Exception {
		String senha = Criptografia.criptografarSenha("1234");
		MockLoginDAO dao = new MockLoginDAO();
		dao.criaUsuarioTeste("admin", "123");
		dao.validarLogin(new Login("admin",senha));
	}

}
