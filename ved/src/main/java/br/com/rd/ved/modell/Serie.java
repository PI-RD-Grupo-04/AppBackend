package br.com.rd.ved.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="series")
public class Serie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	public Serie() {
		super();
	}

	public Serie(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Serie(String descricao) {
		super();
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
		return "Serie [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	
}
