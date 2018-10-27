package br.ifsp.poo.farmacia.modelo.entidade;

public class NotaFiscal {
	private int id;
	private int numero;
	private EnumStatusNotaFiscal status;
	private String chave;
	private String protocolo;

	public NotaFiscal() {
	}

	public NotaFiscal(int id, int numero, EnumStatusNotaFiscal status, String chave, String protocolo) {
		this.id = id;
		this.numero = numero;
		this.status = status;
		this.chave = chave;
		this.protocolo = protocolo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public EnumStatusNotaFiscal getStatus() {
		return status;
	}

	public void setStatus(EnumStatusNotaFiscal status) {
		this.status = status;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
}
