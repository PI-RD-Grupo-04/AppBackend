package br.com.rd.ved.dto;

import java.util.List;
import java.util.stream.Collectors;
import br.com.rd.ved.model.ItemPedido;

public class ItemPedidoDTO {

	private Integer Quantidade;
	
	
		
	public ItemPedidoDTO(ItemPedido itemPedido) {
		this.Quantidade = itemPedido.getQuantidade();
	}


	public Integer getQuantidade() {
		return Quantidade;
	}



	public void setQuantidade(Integer quantidade) {
		Quantidade = quantidade;
	}


	public static List<ItemPedidoDTO> converter(List<ItemPedido> itemPedidos) {
		return itemPedidos.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
	}
	
}