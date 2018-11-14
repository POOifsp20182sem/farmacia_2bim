package br.ifsp.poo.farmacia.modelo.persistencia;

import java.util.ArrayList;
import java.sql.SQLException;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;

public interface IFuncionarioDAO {
	public boolean insertFuncionario(Funcionario func) throws SQLException;
	public boolean updateFuncionario(Funcionario func)throws SQLException;
	public boolean deleteFuncionario(Funcionario func)throws SQLException;
	public ArrayList<Funcionario> selectFuncionario(String filter)throws SQLException;
	public ArrayList<Funcionario> selectFuncionario()throws SQLException;
	public Funcionario buscarFuncionario(int id) throws SQLException;
}