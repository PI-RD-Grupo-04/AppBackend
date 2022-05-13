package br.com.rd.ved.model;

import java.math.BigDecimal;

public class Cesta {

	private String nome;
	private BigDecimal valor;
	private String url;
	
	public Cesta() {}

	public Cesta(String nome, BigDecimal valor, String url) {
		this.nome = nome;
		this.valor = valor;
		this.url = url;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
}
