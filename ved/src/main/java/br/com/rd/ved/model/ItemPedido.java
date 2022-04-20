package br.com.rd.ved.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name = "itemPedidos")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Integer id;
	@Column(name = "quantidade_total")
	@Size(max = 50)
	private Integer quantidade;
	@Column(name = "porcentagem_icms")
	private Double porcentagemIcms;
	@Column(name = "valor_icms")
	private Double valorIcms;
	
	
//	@Column(name = "id_produto")
	@Transient
	private Produto produto;
	
//	@Column(name = "id_pedido")
	@Transient
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