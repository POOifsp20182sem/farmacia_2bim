package br.ifsp.farmacia.testes;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.entities.Funcionario;
import br.ifsp.farmacia.model.entities.Venda;
import br.ifsp.farmacia.model.persistence.VendaDAO;

public class TesteVenda {

	public static void main(String[] args) throws SQLException {
		
		VendaDAO vendaDao = new VendaDAO();
		Venda venda = new Venda();
		
		Cliente cliente = new Cliente();
		Funcionario funcionario = new Funcionario();
		
		cliente.setId(8);
		cliente.setNome("zé mane");
		
		funcionario.setId(5);
		funcionario.setNome("aaa");
		
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);
		venda.setData("2018-10-23");
		venda.setTotal(40);
		venda.setDesconto(1);
		
		//System.out.println(vendaDao.insertVenda(venda));

		venda.setId(8);
		System.out.println(vendaDao.deleteVenda(venda));
		
		System.out.println(vendaDao.updateVenda(venda));
		
		ArrayList<Venda> vazio = vendaDao.selectVenda();
		ArrayList<Venda> parametro = vendaDao.selectVenda("batatao");
		
		System.out.println("Vazio: ");
		
		for(Venda ven: vazio) {
			System.out.println(ven.toString());
		}
		
		System.out.println("Com parametro: ");
		
		for(Venda ven: parametro) {
			System.out.println(ven.toString());
		}
	}

}
