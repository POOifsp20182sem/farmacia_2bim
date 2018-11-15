package br.ifsp.poo.farmacia.control;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.entidade.Produto;
import br.ifsp.poo.farmacia.modelo.entidade.ProdutosPedidos;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;
import br.ifsp.poo.farmacia.modelo.persistencia.ClienteDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.FuncionarioDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.ProdutoDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.ProdutosPedidosDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.VendaDAO;

/**
 * @author Alice Lima
 * Classe responsável por fazer o controle da interface gráfica Venda
 * Fazendo a mediação entre a view e o modelo
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
		try {
			return cli.selectCliente();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Produto> selecionarMedicamento(){
		ProdutoDAO med = new ProdutoDAO();
		try {
			return med.selectProduto();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Funcionario> selecionarFuncionario() {
		FuncionarioDAO fun = new FuncionarioDAO();
		try {
			return fun.selectFuncionario();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// TODO: VERIFICAR A FORMA DE FAZER O GET DO FUNCIONARIO LOGADO
	public String getLogin() {
		Funcionario f = new Funcionario();
		return f.getLoga().getUserName();
	}
	
	public double calcularSubtotal(ProdutosPedidos pp) {
		pp.setValorItem(pp.getProduto().getPrecoUnitario() * pp.getQuantidade());
		return pp.getValorItem();
	}
}