package br.com.rd.ved.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="boleto")
public class Boleto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_boleto")
	private Integer id;
	
	@Column(name="codigo_barra", nullable = false)
	@Size(max = 25)
	private String codigoBarras;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@Column(name="cpf", nullable = false)
	private String cpf;
	
	
	public Boleto() {
		super();
	}
	
	public Boleto(@Size(max = 25) String codigoBarras, String nome, String cpf) {
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
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

	@Override
	public String toString() {
		return "Boleto [id=" + id + ", codigoBarras=" + codigoBarras + "]";
	}
		
}
