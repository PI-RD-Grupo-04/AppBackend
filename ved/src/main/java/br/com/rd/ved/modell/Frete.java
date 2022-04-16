package br.com.rd.ved.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fretes")
public class Frete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double valor;
	
	private Uf uf;
	private TipoFrete tipoFrete;
	
	public Frete() {
		super();
	}

	public Frete(Integer id, Double valor, Uf uf, TipoFrete tipoFrete) {
		this.id = id;
		this.valor = valor;
		this.uf = uf;
		this.tipoFrete = tipoFrete;
	}

	public Frete(Double valor, Uf uf, TipoFrete tipoFrete) {
		this.valor = valor;
		this.uf = uf;
		this.tipoFrete = tipoFrete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public TipoFrete getTipoFrete() {
		return tipoFrete;
	}

	public void setTipoFrete(TipoFrete tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	@Override
	public String toString() {
		return "Frete [id=" + id + ", valor=" + valor + ", uf=" + uf + ", tipoFrete=" + tipoFrete + "]";
	}
	
	
}
