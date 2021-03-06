package br.ifsp.poo.farmacia.control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.entidade.Global;
import br.ifsp.poo.farmacia.modelo.entidade.Produto;
import br.ifsp.poo.farmacia.modelo.entidade.ProdutosPedidos;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;
import br.ifsp.poo.farmacia.modelo.persistencia.ClienteDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.FuncionarioDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.IProdutosPedidosDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.IVendaDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.ProdutoDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.ProdutosPedidosDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.VendaDAO;

/**
 * @author Alice Lima
 * Classe respons�vel por fazer o controle da interface gr�fica Venda
 * Fazendo a media��o entre a view e o modelo
 */
public class VendaControl {
	
	IVendaDAO vendaDao = new VendaDAO();
	IProdutosPedidosDAO ppDao = new ProdutosPedidosDAO();
	
	public void insertVenda(Venda ven) {
		try {
			vendaDao.insertVenda(ven);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	

	
	public void insertProdutoPedido(ProdutosPedidos produtoPedido) {
		try {
			ppDao.insertProdutoPedido(produtoPedido);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void removeProdutoPedido(ProdutosPedidos produtoPedido) {
		try {
			ppDao.removeProdutoPedido(produtoPedido);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void updateProdutoPedido(ProdutosPedidos produtoPedido, ProdutosPedidos produtoPedidoNew) {
		try {
			ppDao.updateProdutoPedido(produtoPedido, produtoPedidoNew);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}		
	
	public ArrayList<Cliente> selecionarCliente(){
		ClienteDAO cli = new ClienteDAO();
		try {
			return cli.selectCliente();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	
	public ArrayList<Produto> selecionarMedicamento(){
		ProdutoDAO med = new ProdutoDAO();
		try {
			return med.selectProduto();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	
	public ArrayList<Funcionario> selecionarFuncionario() {
		FuncionarioDAO fun = new FuncionarioDAO();
		try {
			return fun.selectFuncionario();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
	
	public Funcionario getLogin() {
		return Global.getFuncionarioLogado();
	}
	
	public double calcularSubtotal(ProdutosPedidos pp) {
		pp.setValorItem(pp.getProduto().getPrecoUnitario() * pp.getQuantidade());
		return pp.getValorItem();
	}
}