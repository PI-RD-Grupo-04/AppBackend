package br.com.rd.ved.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rd.ved.dto.ItemPedidoDTO;
import br.com.rd.ved.dto.ItemPedidoDetalheDTO;
import br.com.rd.ved.formdto.ItemPedidoForm;
import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.service.ItemPedidoService;

@RestController
@RequestMapping("/itemPedido")
public class ItemPedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ItemPedidoService itemService;

	@GetMapping
	public ResponseEntity<List<ItemPedidoDTO>> findAll() {
		List<ItemPedidoDTO> list = itemService.findAll();
		return ResponseEntity.ok(list);
	}

	@PostMapping("/novo")
	public ResponseEntity<ItemPedidoDTO> insert(@RequestBody ItemPedidoForm form) {
		try {
			ItemPedidoDTO entity = itemService.insert(form);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(entity).toUri();
			return ResponseEntity.created(uri).body(entity);
		} catch (ServiceException e) {
			return ResponseEntity.unprocessableEntity().build();

	}
}

	@GetMapping("/pedido={id}/items")
	public ResponseEntity<List<ItemPedidoDetalheDTO>> visualizar(@PathVariable("id") Integer id) {

		Optional<Pedido> pedido = pedidoRepository.findById(id);

		if (pedido.isPresent()) {
			List<ItemPedido> itemPedido;
			itemPedido = pedido.get().getItemPedidos();
			return ResponseEntity.ok().body(ItemPedidoDetalheDTO.converter(itemPedido));
		}
		return ResponseEntity.notFound().build();
	}
	 
	
	

}
