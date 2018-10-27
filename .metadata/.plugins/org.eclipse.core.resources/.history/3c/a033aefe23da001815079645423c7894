package br.ifsp.farmacia.testes;

import java.sql.SQLException;
import java.time.LocalDate;

import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.entities.Endereco;
import br.ifsp.farmacia.model.entities.EnumCliente;
import br.ifsp.farmacia.model.persistence.ClienteDAO;

public class TesteBanco {

	public static void main(String[] args) throws java.text.ParseException, SQLException {
		Endereco end = new Endereco();
		end.setLogradouro("Irineu Bernardi");
		end.setNumero("97");
		end.setCidade("Monte Si�o");
		end.setBairro("");
		
		LocalDate nascimento = LocalDate.of(1997, 12, 31);
         
		
		Cliente cli = new Cliente("Éder", nascimento, end, "eder@gmail", "1988845", "154544", EnumCliente.JURIDICA, "12409534612", false);
		
		ClienteDAO cliDao = new ClienteDAO();
		cliDao.insertCliente(cli);
		
		cli.setId(12);
		cliDao.updateCliente(cli);
		
		cli.setId(15);
		cliDao.deleteCliente(cli);
	}
}
