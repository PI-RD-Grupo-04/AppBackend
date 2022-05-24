package br.com.rd.ved.controller;

import java.net.URI;
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

import br.com.rd.ved.dto.BoletoDTO;
import br.com.rd.ved.formdto.BoletoForm;
import br.com.rd.ved.model.Boleto;
import br.com.rd.ved.repository.BoletoRepository;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
	
	@Autowired
	private BoletoRepository boletoRepository; 
	
	
	@PostMapping("/novo")
	@Transactional
	public ResponseEntity<BoletoDTO> cadastrar(
			@RequestBody @Valid BoletoForm boletoForm, UriComponentsBuilder uriBuilder) { 
		Boleto boleto = boletoForm.converter();
		boletoRepository.save(boleto);
		URI uri = uriBuilder.path("/novo/{id}").buildAndExpand(boleto.getId()).toUri();
		return ResponseEntity.created(uri).body(new BoletoDTO(boleto));
	} 
	  
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<BoletoDTO> buscar(@PathVariable("id") Integer id ){
		Optional<Boleto> boleto = boletoRepository.findById(id);
		
		if (boleto.isPresent()) {
			return ResponseEntity.ok().body(new BoletoDTO(boleto.get()));
		}
		return ResponseEntity.notFound().build();	
	}
}
