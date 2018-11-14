package br.ifsp.poo.farmacia.control;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.entidade.Produto;
import br.ifsp.poo.farmacia.modelo.entidade.ProdutosPedidos;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;
import br.ifsp.poo.farmacia.modelo.persistencia.ProdutosPedidosDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.VendaDAO;

/**
 * @author Alice Lima
 * Classe respons�vel por fazer o controle da interface gr�fica Venda
 * Fazendo a media��o entre a view e o modelo
 */
public class VendaControl {
	
	VendaDAO vendaDao = new VendaDAO();
	ProdutosPedidosDAO ppDao = new ProdutosPedidosDAO();
	
	public boolean insertVenda(Venda ven) {
		try {
			return vendaDao.insertVenda(ven);
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return false;
	}
	
	public boolean updateVenda(Venda ven) {
		try {
			return vendaDao.updateVenda(ven);
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return false;
	}
	
	public boolean deleteVenda(Venda ven) {
		try {
			return vendaDao.deleteVenda(ven);
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return false;
	}
	
	public ArrayList<Venda> selectVenda(String filter){
		try {
			return vendaDao.selectVenda(filter);
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return null;
	}
	
	public ArrayList<Venda> selectVenda(){
		try {
			return vendaDao.selectVenda();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insertProdutoPedido(ProdutosPedidos produtoPedido) {
		try {
			return ppDao.insertProdutoPedido(produtoPedido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeProdutoPedido(ProdutosPedidos produtoPedido) {
		try {
			return ppDao.removeProdutoPedido(produtoPedido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateProdutoPedido(ProdutosPedidos produtoPedido, ProdutosPedidos produtoPedidoNew) {
		try {
			return ppDao.updateProdutoPedido(produtoPedido, produtoPedidoNew);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}		
	
	public ArrayList<Cliente> selecionarCliente(){
		ClienteDAO cli = new ClienteDAO();
		return cli.selecionarCliente();
	}
	
	public ArrayList<Produto> selecionarMedicamento(){
		ProdutoDAO med = new ProdutoDAO();
		return med.selecionarProduto();
	}
	
	public ArrayList<Funcionario> selecionarFuncionario() {
		FuncionarioDAO fun = new FuncionarioDAO();
		return fun.selecionarFuncionario();
	}
}