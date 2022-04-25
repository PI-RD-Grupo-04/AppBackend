package br.com.rd.ved.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "frete")
public class Frete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_frete")
	private Integer id;
	@Column(name = "valor")
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "id_uf", nullable = false)
	private Uf uf;

	@ManyToOne
	@JoinColumn(name = "id_tipo_frete", nullable = false)
	private TipoFrete tipoFrete;
	
	
	@OneToMany(mappedBy = "pedidoStatus")
	private List <Pedido> lista; 

	public Frete() {
		super();
	}

	public Frete(BigDecimal valor, Uf uf, TipoFrete tipoFrete) {
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
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
