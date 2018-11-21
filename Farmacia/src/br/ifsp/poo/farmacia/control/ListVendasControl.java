package br.ifsp.poo.farmacia.control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ifsp.poo.farmacia.modelo.entidade.Venda;
import br.ifsp.poo.farmacia.modelo.persistencia.IVendaDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.VendaDAO;

/**
 * @author Alice Lima
 * Classe responsável por fazer o controle da interface gráfica Historico de Vendas
 * Fazendo a mediação entre a view e o modelo
 */
public class ListVendasControl {

	IVendaDAO vendaDao = new VendaDAO();
	
	public void updateVenda(Venda ven) {
		try {
			vendaDao.updateVenda(ven);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void deleteVenda(int id) {
		try {
			vendaDao.deleteVenda(id);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public ArrayList<Venda> selectVenda(String filter) {
		try {
			return vendaDao.selectVenda(filter);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	
	public ArrayList<Venda> selectVenda(){
		try {
			return vendaDao.selectVenda();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
}
