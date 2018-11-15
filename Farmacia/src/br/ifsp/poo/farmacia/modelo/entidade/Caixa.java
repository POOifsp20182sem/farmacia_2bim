package br.ifsp.poo.farmacia.modelo.entidade;

import java.time.LocalDateTime;

public class Caixa {
	private int id;
	private Funcionario funcAbertura;
	private Funcionario funcFechamento;
	private double saldoInicial;
	private double saldoFinal;
	private LocalDateTime abertura;
	private LocalDateTime fechamento;
	private EnumStatusCaixa status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario getFuncAbertura() {
		return funcAbertura;
	}

	public void setFuncAbertura(Funcionario funcAbertura) {
		this.funcAbertura = funcAbertura;
	}

	public Funcionario getFuncFechamento() {
		return funcFechamento;
	}

	public void setFuncFechamento(Funcionario funcFechamento) {
		this.funcFechamento = funcFechamento;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public double getSaldoFinal() {
		return saldoFinal;
	}

	public void setSaldoFinal(double saldoFinal) {
		this.saldoFinal = saldoFinal;
	}

	public LocalDateTime getAbertura() {
		return abertura;
	}

	public void setAbertura(LocalDateTime abertura) {
		this.abertura = abertura;
	}

	public LocalDateTime getFechamento() {
		return fechamento;
	}

	public void setFechamento(LocalDateTime fechamento) {
		this.fechamento = fechamento;
	}

	public EnumStatusCaixa getStatus() {
		return status;
	}

	public void setStatus(EnumStatusCaixa status) {
		this.status = status;
	}
}