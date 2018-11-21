package br.ifsp.poo.farmacia.testes;

import java.sql.SQLException;
import java.time.LocalDateTime;

import br.ifsp.poo.farmacia.control.CaixaControl;
import br.ifsp.poo.farmacia.modelo.entidade.Caixa;
import br.ifsp.poo.farmacia.modelo.entidade.CaixaSingleton;
import br.ifsp.poo.farmacia.modelo.entidade.EnumStatusCaixa;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;

public class TesteCaixa {

	public static void main(String args[]) throws Exception {
		Caixa caixa = CaixaSingleton.getInstance();
		CaixaControl ctrlCaixa = new CaixaControl();
		Funcionario func = new Funcionario();

		func.setId(02);
		caixa.setAbertura(LocalDateTime.now());
		caixa.setSaldoInicial(100.00);
		caixa.setFuncAbertura(func);
		caixa.setStatus(EnumStatusCaixa.ABERTO);

		try {
			ctrlCaixa.inserirCaixa(caixa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(caixa.getId());

		caixa.setStatus(EnumStatusCaixa.FECHADO);
		caixa.setFuncFechamento(func);
		caixa.setFechamento(LocalDateTime.now());
		caixa.setSaldoFinal(200.00);

		try {
			ctrlCaixa.alterarCaixa(caixa);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			for (Caixa cx : ctrlCaixa.listarCaixas())
				System.out.println(cx);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Caixa box = CaixaSingleton.getInstance();

		if (box == caixa)
			System.out.println("YEAH! São iguais!");

		try {
			ctrlCaixa.removerCaixa(caixa);
			System.out.println("Caixa removido!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
