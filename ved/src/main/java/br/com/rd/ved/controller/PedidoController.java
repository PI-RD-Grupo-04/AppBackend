package br.com.rd.ved.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.rd.ved.dto.PedidoDTO;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.repository.PedidoRepository;


public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public List<PedidoDTO> Listar() {
		List<Pedido> pedidos = pedidoRepository.findAll();  
		return 	PedidoDTO.converter(pedidos);
	} 

	
//	@PostMapping 
//	@Transactional
//	public ResponseEntity<PedidoDTO> cadastrar(@RequestBody @Valid PedidoForm pedidoForm,
//			                                    UriComponentsBuilder uriBuilder){
//		Pedido pedido = pedidoForm.converter(pedidoRepository);
//		pedidoRepository.save(pedido); 
//		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(pedido.getId()).toUri();
//		return ResponseEntity.created(uri).body(new ClienteDTO(pedido)) ;
//	}
}
