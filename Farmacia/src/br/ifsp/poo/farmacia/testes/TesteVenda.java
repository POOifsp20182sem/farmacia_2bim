package br.ifsp.poo.farmacia.testes;

import java.util.ArrayList;
import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;
import br.ifsp.poo.farmacia.modelo.persistencia.VendaDAO;

public class TesteVenda {

	public static void main(String[] args) throws Exception {

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
		
		vendaDao.deleteVenda(1);

		vendaDao.updateVenda(venda);

		ArrayList<Venda> vazio = vendaDao.selectVenda();
		ArrayList<Venda> parametro = vendaDao.selectVenda("batatao");

		System.out.println("Vazio: ");

		for (Venda ven : vazio) {
			System.out.println(ven.toString());
		}

		System.out.println("Com parametro: ");

		for (Venda ven : parametro) {
			System.out.println(ven.toString());
		}
	}
}
