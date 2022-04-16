package br.com.rd.ved.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cupomDescontos")
public class CupomDesconto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Integer porcentagemDesconto;
	
	public CupomDesconto() {
		super();
	}

	public CupomDesconto(Integer id, String descricao, Integer porcentagemDesconto) {
		this.id = id;
		this.descricao = descricao;
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public CupomDesconto(String descricao, Integer porcentagemDesconto) {
		this.descricao = descricao;
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(Integer porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	@Override
	public String toString() {
		return "CupomDesconto [id=" + id + ", descricao=" + descricao + ", porcentagemDesconto=" + porcentagemDesconto
				+ "]";
	}
	
}
