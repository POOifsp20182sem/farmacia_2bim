package br.ifsp.poo.farmacia.modelo.entidade;

import java.util.ArrayList;

public class Venda {

	private int id;
	private String data;
	private Cliente cliente;
	private Funcionario funcionario;
	private double total, desconto;
	private ArrayList<ProdutosPedidos> produtos;

	public Venda() {
	}

	public Venda(String data, Cliente cliente, Funcionario funcionario, double total, double desconto) {
		this.data = data;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.total = total;
		this.desconto = desconto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public ArrayList<ProdutosPedidos> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<ProdutosPedidos> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Venda [id = " + id + ", data = " + data + ", cliente = " + cliente.getNome() + ", funcionario = "
				+ funcionario.getNome() + ", total = " + total + ", desconto = " + desconto + "]";
	}

}
