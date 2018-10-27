package br.ifsp.farmacia.testes;

import java.time.LocalDate;

import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.entities.Endereco;
import br.ifsp.farmacia.model.entities.EnumCliente;
import br.ifsp.farmacia.model.persistence.ClienteDAO;

public class TesteClienteDAO {

	public static void main(String[] args) {
		
		Endereco end = new Endereco();
		
		
		Cliente cli = new Cliente("aaa", LocalDate.now() , end, "asdasd",
				"145454", "45454", EnumCliente.FISICA, "cpf", true);
		ClienteDAO clienteDAO = new ClienteDAO();
		
		try {
			//clienteDAO.insertCliente(cli);
			//Funcionando
			for (Cliente c : clienteDAO.selectCliente()) {
				System.out.println(c.toString());
			} 
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
}
