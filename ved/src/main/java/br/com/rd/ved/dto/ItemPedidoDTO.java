package br.com.rd.ved.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Produto;

public class ItemPedidoDTO {

	private Integer quantidade;	
	private BigDecimal preco;
	private Produto idProduto;
		
	public ItemPedidoDTO(ItemPedido itemPedido) {
		this.preco = itemPedido.getProduto().getPreco();
		this.quantidade = itemPedido.getQuantidade();
		this.idProduto = itemPedido.getProduto();
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Produto getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}

	public static List<ItemPedidoDTO> converter(List<ItemPedido> itemPedidos) {
		return itemPedidos.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
	}
	
}
