package br.com.rd.ved.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

	
	@EmbeddedId
	private PedidoProdutoID id;
	
	@ManyToOne(fetch=FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name="id_pedido", nullable=false, insertable=false, updatable=false)
	private Pedido pedido;
	
	@ManyToOne(fetch=FetchType.EAGER )
	@JoinColumn(name="id_produto", nullable=false, insertable=false, updatable=false)
	private Produto produtos;
	
	@Column(name = "quantidade_total")
	@Size(max = 50)
	private Integer quantidade;
	
	@Column(name = "porcentagem_icms")
	private Double porcentagemIcms;
	
	@Column(name = "valor_icms")
	private Double valorIcms;

	public ItemPedido(Pedido pedido, Produto produtos, @Size(max = 50) Integer quantidade, Double porcentagemIcms,
			Double valorIcms) {
		this.pedido = pedido;
		this.produtos = produtos;
		this.quantidade = quantidade;
		this.porcentagemIcms = porcentagemIcms;
		this.valorIcms = valorIcms;
	}

	public PedidoProdutoID getId() {
		return id;
	}

	public void setId(PedidoProdutoID id) {
		this.id = id;
	}

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
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
		return produtos;
	}

	public void setProduto(Produto produto) {
		this.produtos = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", pedido=" + pedido + ", produtos=" + produtos + ", quantidade=" + quantidade
				+ ", porcentagemIcms=" + porcentagemIcms + ", valorIcms=" + valorIcms + "]";
	}


}
