package br.ifsp.poo.farmacia.modelo.entidade;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
	private int id;
	private double salario;
	private EnumFuncionario tipoFuncionario;
	private String celular;

	public Funcionario(String nome, LocalDate dataNascimento, String endereco, String email, String telefone,
			String celular, double salario, EnumFuncionario tipoFuncionario, String documento) {
		super(nome, dataNascimento, endereco, email, telefone, documento);

		this.setCelular(celular);
		this.setSalario(salario);
		this.setTipoFuncionario(tipoFuncionario);
	}

	public Funcionario() {
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public EnumFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(EnumFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
