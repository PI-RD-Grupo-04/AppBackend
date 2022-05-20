package br.com.rd.ved.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.PK.PedidoIntemPedidoCH;

public class ItemPedidoDTO {

	private Integer codigo_produto;
	private String produto;
	private BigDecimal preco;
	private Integer quantidade;
	private PedidoIntemPedidoCH chave;
	
	
		
	public ItemPedidoDTO(ItemPedido itemPedido) {
		this.chave = itemPedido.getIdch();
		this.quantidade = itemPedido.getQuantidade();
//		this.produto = itemPedido.getProduto().getNomeProduto();
//		this.codigo_produto = itemPedido.getProduto().getId();
//		this.preco = itemPedido.getProduto().getPreco();
	}


	public Integer getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(Integer quantidade) {
		quantidade = quantidade;
	}

	public void setChave(PedidoIntemPedidoCH chave) {
		this.chave = chave;
	}
	
	public String getProduto() {
		return produto;
	}


	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Integer getCodigo_produto() {
		return codigo_produto;
	}


	public void setCodigo_produto(Integer codigo_produto) {
		this.codigo_produto = codigo_produto;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public static List<ItemPedidoDTO> converter(List<ItemPedido> itemPedidos) {
		return itemPedidos.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
	}
	
}