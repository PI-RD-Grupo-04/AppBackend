package br.com.rd.ved.formdto;

import br.com.rd.ved.model.Boleto;

public class BoletoForm {

	private String nome;
	private String cpf;
	private String codigo;

	public BoletoForm(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.codigo = "34191.79001 01043.510047 91020.150008 7 89250026000";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	} 
	
	public Boleto converter() { 
		return new Boleto(null, codigo); 
		
	}

}
