package br.ifsp.poo.farmacia.testes;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;

import br.ifsp.poo.farmacia.modelo.entidade.Criptografia;
import br.ifsp.poo.farmacia.modelo.entidade.Login;
import br.ifsp.poo.farmacia.modelo.persistencia.ILoginDAO;

public class MockLoginDAO implements ILoginDAO{

	private String userName;
	private String password;
	
	public void criaUsuarioTeste(String userName, String password) throws Exception {
		Criptografia.inicializa();
		this.userName = userName;
		this.password = Criptografia.criptografarSenha(password);
	}

	@Override
	public void validarLogin(Login login) throws SQLException, AccessDeniedException, Exception {
		if(!isValid(login))
			throw new Exception("Erro ao logar");
	}
	
	public boolean isValid(Login login) {
		return login.getUserName() == userName && login.getPassword().equals(password);
	}

	
	
}
