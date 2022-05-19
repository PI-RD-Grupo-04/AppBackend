package br.com.rd.ved.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rd.ved.model.PK.PedidoIntemPedidoCH;

@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoIntemPedidoCH id;
	
	@Column(name = "quantidade_total")
	@Size(max = 50)
	private Integer quantidade;
	
	@Column(name = "porcentagem_icms")
	private Double porcentagemIcms;
	
	@Column(name = "valor_icms")
	private Double valorIcms;
	
	

	public ItemPedido() {}

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double porcentagemIcms, Double valorIcms) {
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.quantidade = quantidade;
		this.porcentagemIcms = porcentagemIcms;
		this.valorIcms = valorIcms;
	}

	public ItemPedido(Integer quantidade, Double porcentagemIcms, Double valorIcms) {
		this.quantidade = quantidade;
		this.porcentagemIcms = porcentagemIcms;
		this.valorIcms = valorIcms;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}

	

}
