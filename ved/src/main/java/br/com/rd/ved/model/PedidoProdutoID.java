package br.com.rd.ved.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;



@Embeddable
public class PedidoProdutoID implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id_pedido;
	
	private Integer id_produto;
	
	
	
	public PedidoProdutoID() {}
	
	public PedidoProdutoID(Integer id_pedido, Integer id_produto) {
		this.id_pedido = id_pedido;
		this.id_produto = id_produto;
	}



	public Integer getId_pedido() {
		return id_pedido;
	}
	
	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}
	
	public Integer getId_produto() {
		return id_produto;
	}
	
	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_pedido, id_produto);
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
		return Objects.equals(id_pedido, other.id_pedido) && Objects.equals(id_produto, other.id_produto);
	}		
}
