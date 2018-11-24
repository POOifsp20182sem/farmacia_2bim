package br.ifsp.poo.farmacia.testes;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import br.ifsp.poo.farmacia.modelo.entidade.EnumFuncionario;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.entidade.Login;
import br.ifsp.poo.farmacia.modelo.persistencia.FuncionarioDAO;

public class TesteFuncionario {

	public static void main(String[] args) throws Exception {

		Funcionario fun = new Funcionario();
		FuncionarioDAO fDao = new FuncionarioDAO();

		/*fun.setNome("Teste");
		fun.setEmail("email@mail.com");
		fun.setEndereco("rua das garcas, 65, jd mario, atibaia");
		fun.setTelefone("1109876543");
		fun.setCelular("1112345678");
		fun.setDocumento("12345678901");
		fun.setDataNascimento(LocalDate.of(2014, Month.JANUARY, 1));
		fun.setTipoFuncionario(EnumFuncionario.ATENDENTE);
		fun.setSalario(1234.44);
		Login login  = new Login("alissa", "1234");
		fun.setLogin(login);*/
		
		// deu certo
		/*try {
			fDao.insertFuncionario(fun);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		// deu certo
		try {
			fun.setId(34);
			fDao.deleteFuncionario(fun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
