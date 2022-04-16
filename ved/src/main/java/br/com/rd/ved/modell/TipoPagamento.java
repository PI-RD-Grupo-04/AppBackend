package br.com.rd.ved.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipoPagamentos")
public class TipoPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	public TipoPagamento() {
		super();
	}

	public TipoPagamento(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public TipoPagamento(String descricao) {
		this.descricao = descricao;
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

	@Override
	public String toString() {
		return "TipoPagamento [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	
}
