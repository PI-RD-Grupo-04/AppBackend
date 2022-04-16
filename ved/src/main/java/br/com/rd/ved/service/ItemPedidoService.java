package br.com.rd.ved.service;

import org.springframework.stereotype.Service;

import br.com.rd.ved.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	private final ItemPedidoRepository itemPedidoRepository;
	private Boolean sistema = true;
	
	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
	}
	
	
}
