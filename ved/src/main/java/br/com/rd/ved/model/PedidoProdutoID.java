package br.com.rd.ved.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PedidoProdutoID implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_pedido")
	private Integer idPedido = 12;

	@Column(name = "id_produto")
	private Integer idProduto;

	public PedidoProdutoID() {
	}

	public PedidoProdutoID(Integer idPedido, Integer idProduto) {
		this.idPedido = idPedido;
		this.idProduto = idProduto;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedido, idProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoProdutoID other = (PedidoProdutoID) obj;
		return Objects.equals(idPedido, other.idPedido) && Objects.equals(idProduto, other.idProduto);
	}

}
