package br.ifsp.poo.farmacia.modelo.persistencia;

import java.util.ArrayList;
import java.sql.SQLException;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;

public interface IFuncionarioDAO {
	public void insertFuncionario(Funcionario func) throws SQLException, Exception;
	public void updateFuncionario(Funcionario func)throws SQLException, Exception;
	public void deleteFuncionario(Funcionario func)throws SQLException, Exception;
	public ArrayList<Funcionario> selectFuncionario(String filter)throws SQLException, Exception;
	public ArrayList<Funcionario> selectFuncionario()throws SQLException, Exception;
	public Funcionario buscarFuncionario(int id) throws SQLException, Exception;
}