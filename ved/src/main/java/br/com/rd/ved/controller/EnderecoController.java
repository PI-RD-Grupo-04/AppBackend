package br.com.rd.ved.controller;

import java.net.URI;
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

import br.com.rd.ved.dto.EnderecoDTO;
import br.com.rd.ved.formdto.EnderecoForm;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.repository.ClienteRepository;
import br.com.rd.ved.repository.EnderecoRepository;
import br.com.rd.ved.repository.UfRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository er;
	@Autowired
	private ClienteRepository cr;

	@Autowired 
	private UfRepository ur;

	@GetMapping
	public List<EnderecoDTO> listar() {
		List<Endereco> enderecos = er.findAll();
		return EnderecoDTO.converter(enderecos);
	}

	@PostMapping("/novo/{id}")
	@Transactional
	public ResponseEntity<EnderecoDTO> cadastrar(@PathVariable("id") Integer id,
			@RequestBody @Valid EnderecoForm enderecoForm, UriComponentsBuilder uriBuilder) {

		Optional<Cliente> cliente = cr.findById(id);
		Endereco endereco = enderecoForm.converter(ur);
		er.save(endereco);
		enderecoForm.cadastrarEndereco(endereco, cliente.get(), cr);

		URI uri = uriBuilder.path("/endereco/novo/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDTO(endereco));

	}

	@GetMapping("/{id}")
	public ResponseEntity<EnderecoDTO> detalhar(@PathVariable("id") Integer id) {
		Optional<Endereco> endereco = er.findById(id);

		if (endereco.isPresent()) {
			return ResponseEntity.ok(new EnderecoDTO(endereco.get()));
		}

		return ResponseEntity.notFound().build();
	}

}
