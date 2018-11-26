package br.ifsp.poo.farmacia.modelo.persistencia;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;

import br.ifsp.poo.farmacia.modelo.entidade.Login;

public interface ILoginDAO {

	public void validarLogin(Login login) throws SQLException, AccessDeniedException, Exception;
	
	public void insertLogin(Login login) throws SQLException,Exception; 
	
	public Login buscarLogin(int id) throws SQLException, Exception;
}
