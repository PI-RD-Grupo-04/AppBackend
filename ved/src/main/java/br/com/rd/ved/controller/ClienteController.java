package br.com.rd.ved.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rd.ved.dto.ClienteDTO;
import br.com.rd.ved.formdto.ClienteForm;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<ClienteDTO> Listar() {
		List<Cliente> clientes = clienteRepository.findAll();  
		return 	ClienteDTO.converter(clientes);
	} 

	
	@PostMapping 
	@Transactional
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteForm clienteForm,
			                                    UriComponentsBuilder uriBuilder){
		Cliente cliente = clienteForm.converter(clienteRepository);
		clienteRepository.save(cliente); 
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDTO(cliente)) ;
	}

}
