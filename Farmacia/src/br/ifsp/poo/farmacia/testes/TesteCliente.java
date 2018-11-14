package br.ifsp.poo.farmacia.testes;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.entidade.EnumCliente;
import br.ifsp.poo.farmacia.modelo.persistencia.ClienteDAO;

public class TesteCliente {

	public static void main(String[] args) {

		Cliente cli = new Cliente();
		
		cli.setNome("Teste");
		cli.setEmail("email@mail.com");
		cli.setEndereco("rua das garcas, 65, jd mario, atibaia");
		cli.setTelefone("1109876543");
		cli.setCelular("1112345678");
		cli.setTipoCliente(EnumCliente.FISICA);
		cli.setDocumento("12345678901");
		cli.setDataNascimento(LocalDate.of(2014, Month.JANUARY, 1));
		
		ClienteDAO cDao = new ClienteDAO();
		//deu certo
		try {
		cDao.insertCliente(cli);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		//deu certo
		try {
			cli.setId(33);
			cDao.deleteCliente(cli);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
