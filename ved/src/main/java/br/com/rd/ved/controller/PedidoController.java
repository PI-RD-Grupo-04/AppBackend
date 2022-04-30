package br.com.rd.ved.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rd.ved.dto.PedidoDTO;
import br.com.rd.ved.formdto.PedidoForm;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.repository.PedidoRepository;


public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public List<PedidoDTO> Listar() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		return PedidoDTO.converter(pedidos);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PedidoDTO> cadastrar(@RequestBody @Valid PedidoForm pedidoForm,
			UriComponentsBuilder uriBuilder) {
		Pedido pedido = pedidoForm.converter(pedidoRepository);
		pedidoRepository.save(pedido);
		URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> detalhar(@PathVariable("id") Integer id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (pedido.isPresent()) {
			return ResponseEntity.ok(new PedidoDTO(pedido.get()));
		}
		return ResponseEntity.notFound().build();
	} 
	
	
	@DeleteMapping("/delete={id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable("id") Integer id){
		Optional<Pedido> pedido = pedidoRepository.findById(id);		
		if(pedido.isPresent()) {
			pedidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
		
	}

}
