package br.ifsp.poo.farmacia.modelo.persistencia;

import java.util.ArrayList;
import java.sql.SQLException;
import br.ifsp.poo.farmacia.modelo.entidade.Cliente;

public interface IClienteDAO {
	
	public void insertCliente(Cliente cli) throws SQLException, Exception;
	public void updateCliente(Cliente cli) throws SQLException, Exception;
	public void deleteCliente(Cliente cli) throws SQLException, Exception;
	public ArrayList<Cliente> selectCliente(String filter) throws SQLException, Exception;
	public ArrayList<Cliente> selectCliente() throws SQLException, Exception;
	public Cliente buscarCliente(int id) throws SQLException, Exception;
}
