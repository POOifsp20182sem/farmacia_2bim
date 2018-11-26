package br.ifsp.poo.farmacia.control;

import br.ifsp.poo.farmacia.modelo.persistencia.FuncionarioDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.IFuncionarioDAO;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FuncionarioControl {

	IFuncionarioDAO fd = new FuncionarioDAO();

	public void cadastrarFuncionario(Funcionario func) {

		try {
			fd.insertFuncionario(func);
		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
		catch (Exception e) {
			System.out.println(func.getTipoFuncionario());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void atualizarFuncionario(Funcionario func) {
		try {
			fd.updateFuncionario(func);
		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void excluirFuncionario(Funcionario func) {
		try {
			fd.deleteFuncionario(func);
		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public ArrayList<Funcionario> listarFuncionarios() {
		try {
			return fd.selectFuncionario();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public ArrayList<Funcionario> listarFuncionarios(String filtro) {
		try {
			return fd.selectFuncionario(filtro);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public Funcionario buscarFuncionario(int id) {
		try {
			return fd.buscarFuncionario(id);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

}
