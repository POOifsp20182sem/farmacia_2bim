package br.ifsp.poo.farmacia.control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.persistencia.ClienteDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.IClienteDAO;

public class ClienteControl {
	
	IClienteDAO cd = new ClienteDAO();
	
	public void CadastrarCliente (Cliente cli){
		
		try {
			cd.insertCliente(cli);
			JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso.", "Informação", 2);
		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void AtualizarCliente (Cliente cli){
		try {
			cd.updateCliente(cli);
			JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.", "Informação", 2);
		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	}
	
	public void DeletarCliente (Cliente cli){
		try {
			cd.deleteCliente(cli);
			JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.", "Informação", 2);
		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public ArrayList<Cliente> listarCliente (String filtro) {
		try {
			return cd.selectCliente(filtro);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	
	public ArrayList<Cliente> listarCliente () throws SQLException {
		try {
			return cd.selectCliente();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public Cliente buscarCliente(int id) {
		try {
			return cd.buscarCliente(id);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
}
