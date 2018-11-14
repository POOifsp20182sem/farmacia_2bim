package br.ifsp.poo.farmacia.control;

import br.ifsp.poo.farmacia.modelo.persistencia.FuncionarioDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.IFuncionarioDAO;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioControl {
	
	IFuncionarioDAO fd = new FuncionarioDAO();
	
	public boolean cadastrarFuncionario(Funcionario func) throws SQLException {
		return fd.insertFuncionario(func);
	}
	
	public boolean atualizarFuncionario(Funcionario func) throws SQLException {
		return fd.updateFuncionario(func);
	}
	
	public boolean excluirFuncionario(Funcionario func) throws SQLException {
		return fd.deleteFuncionario(func);
	}
	
	public ArrayList<Funcionario> listarFuncionarios() throws SQLException {
		return fd.selectFuncionario();
	}
	
	public ArrayList<Funcionario> listarFuncionarios(String filtro) throws SQLException {
		return fd.selectFuncionario(filtro);
	}
	
	public Funcionario buscarFuncionario(int id) throws SQLException{
		return fd.buscarFuncionario(id);
	}

}
