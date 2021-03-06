package br.ifsp.poo.farmacia.modelo.entidade;

import java.time.LocalDate;

public class Cliente extends Pessoa {
	private int id;
	private boolean especial;
	private String celular;

	public Cliente(String nome, LocalDate dataNascimento, String endereco, String email, String telefone,
			String celular, String documento, boolean especial) {
		super(nome, dataNascimento, endereco, email, telefone, documento);

		this.setDocumento(documento);
		this.setEspecial(especial);
		this.setCelular(celular);
	}

	public Cliente() {
	}

	public boolean isEspecial() {
		return this.especial;
	}

	public void setEspecial(boolean isEspecial) {
		this.especial = isEspecial;
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

	@Override
	public String toString() {
		return this.getNome();
	}

}
