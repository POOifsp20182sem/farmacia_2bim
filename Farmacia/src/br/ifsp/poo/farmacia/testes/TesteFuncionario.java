package br.ifsp.poo.farmacia.testes;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import br.ifsp.poo.farmacia.modelo.entidade.EnumFuncionario;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.persistencia.FuncionarioDAO;

public class TesteFuncionario {

	public static void main(String[] args) {

		Funcionario fun = new Funcionario();
		FuncionarioDAO fDao = new FuncionarioDAO();
		
		/*fun.setId(1);
		fun.setNome("Teste");
		fun.setEmail("email@mail.com");
		fun.setEndereco("rua das garcas, 65, jd mario, atibaia");
		fun.setTelefone("1109876543");
		fun.setCelular("1112345678");
		fun.setDocumento("12345678901");
		fun.setDataNascimento(LocalDate.of(2014, Month.JANUARY, 1));
		fun.setTipoFuncionario(EnumFuncionario.ATENDENTE);
		fun.setSalario(1234.44);
		fun.setUser("lalala");
		fun.setSenha("098700");
		
		//deu certo
		try {
			fDao.insertFuncionario(fun);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//deu certo
		try {
			fun.setId(10);
			fDao.deleteFuncionario(fun);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
