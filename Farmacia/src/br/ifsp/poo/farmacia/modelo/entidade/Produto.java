package br.ifsp.poo.farmacia.modelo.entidade;

public class Produto {
	
	private int id;
	private String nomeComercial;
	private String apresentacao;
	private EnumFormaFarmaco formaFarmaco;
	private String codigoBarras;
	private PrincipioAtivo principioAtivo;
	private ClasseTerapeutica classeTerapeutica;
	private double precoUnitario;

	public Produto(String nomeComercial, String apresentacao, EnumFormaFarmaco formaFarmaco,
			PrincipioAtivo principioAtivo, String codigoBarras,
			ClasseTerapeutica classeTerapeutica, double precoUnitario) {
		super();
		this.nomeComercial = nomeComercial;
		this.apresentacao = apresentacao;
		this.formaFarmaco = formaFarmaco;
		this.principioAtivo = principioAtivo;
		this.codigoBarras = codigoBarras;
		this.classeTerapeutica = classeTerapeutica;
		this.precoUnitario = precoUnitario;
	}

	public Produto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeComercial() {
		return nomeComercial;
	}

	public void setNomeComercial(String nomeComercial) {
		this.nomeComercial = nomeComercial;
	}

	public String getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}

	public String getFormaFarmaco() {
		return formaFarmaco.getFormaFarmaco();
	}

	public void setFormaFarmaco(EnumFormaFarmaco formaFarmaco) {
		this.formaFarmaco = formaFarmaco;
	}


	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	
	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public PrincipioAtivo getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(PrincipioAtivo principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	public ClasseTerapeutica getClasseTerapeutica() {
		return classeTerapeutica;
	}

	public void setClasseTerapeutica(ClasseTerapeutica classeTerapeutica) {
		this.classeTerapeutica = classeTerapeutica;
	}
	

	@Override
	public String toString() {
		return this.getNomeComercial();
	}
	
}
