package br.com.rd.ved.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rd.ved.dto.ItemPedidoDTO;
import br.com.rd.ved.formdto.ItemPedidoForm;
import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.Produto;
import br.com.rd.ved.repository.ItemPedidoRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.ProdutoRepository;

@RestController
@RequestMapping("/itemPedido")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@PostMapping("/novo")
	@Transactional
	public ResponseEntity<ItemPedidoDTO> cadastrar(@RequestBody @Valid ItemPedidoForm itemPedidoForm, 
												UriComponentsBuilder uriBuilder) {
		Optional<Pedido> pedido = pedidoRepository.findById(itemPedidoForm.getPedido());
		Optional<Produto> produto = produtoRepository.findById(itemPedidoForm.getProduto());
		
		ItemPedido itemPedido = itemPedidoForm.converter(itemPedidoRepository, pedido.get(), produto.get());
		
		itemPedidoForm.cadastrarItemPedido(itemPedido, pedido.get(), pedidoRepository);
		URI uri = uriBuilder.path("/novo/{id}").buildAndExpand(itemPedido.getId()).toUri();
		return ResponseEntity.created(uri).body(new ItemPedidoDTO(itemPedido));

	}

	
	@GetMapping("/pedido={id}/items")
	public ResponseEntity<List<ItemPedidoDTO>> visualizar(@PathVariable("id") Integer id){
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		
		if (pedido.isPresent()) {
			List<ItemPedido> itemPedidos = new ArrayList<>();
			itemPedidos = pedido.get().getItemPedidos();
			return ResponseEntity.ok().body(ItemPedidoDTO.converter(itemPedidos));
		}
		return ResponseEntity.notFound().build();
	}
	
}
