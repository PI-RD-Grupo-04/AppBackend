package br.com.rd.ved.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemPedidos")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer quantidade;
	private Double porcentagemIcms;
	private Double valorIcms;
	
	private Produto produto;
	
	private Pedido pedido;

	public ItemPedido() {
		super();
	}

	public ItemPedido(Integer id, Integer quantidade, Double porcentagemIcms, Double valorIcms, Produto produto,
			Pedido pedido) {
		this.id = id;
		this.quantidade = quantidade;
		this.porcentagemIcms = porcentagemIcms;
		this.valorIcms = valorIcms;
		this.produto = produto;
		this.pedido = pedido;
	}

	public ItemPedido(Integer quantidade, Double porcentagemIcms, Double valorIcms, Produto produto, Pedido pedido) {
		this.quantidade = quantidade;
		this.porcentagemIcms = porcentagemIcms;
		this.valorIcms = valorIcms;
		this.produto = produto;
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPorcentagemIcms() {
		return porcentagemIcms;
	}

	public void setPorcentagemIcms(Double porcentagemIcms) {
		this.porcentagemIcms = porcentagemIcms;
	}

	public Double getValorIcms() {
		return valorIcms;
	}

	public void setValorIcms(Double valorIcms) {
		this.valorIcms = valorIcms;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", quantidade=" + quantidade + ", porcentagemIcms=" + porcentagemIcms
				+ ", valorIcms=" + valorIcms + ", produto=" + produto + ", pedido=" + pedido + "]";
	}
	
	
}
