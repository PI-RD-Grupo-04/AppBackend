package br.com.rd.ved.testando;

import java.util.List;

import br.com.rd.ved.formdto.ItemPedidoForm;
import br.com.rd.ved.service.ItemPedidoService;

public class Testando {

	private List<ItemPedidoForm> itemsForm;
		
	public Testando() {}



	public void listando(List<ItemPedidoForm> itemsForm) {
		ItemPedidoService itemPedidoService = new ItemPedidoService();
		
		for(int i = 0; i < itemsForm.size(); i++) {
			itemPedidoService.insert(itemsForm.get(i));
		}		
	}
}
