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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rd.ved.dto.CartaoDTO;
import br.com.rd.ved.formdto.ClienteCartaoForm;
import br.com.rd.ved.model.Cartao;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.repository.BandeiraRepository;
import br.com.rd.ved.repository.CartaoRepository;
import br.com.rd.ved.repository.ClienteRepository;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private ClienteRepository clienterepository;

	@Autowired
	private BandeiraRepository bandeiraRepository;

	
	
	@GetMapping
	public List<CartaoDTO> listar(Integer idcliente) {
		if (idcliente == null) {
			List<Cartao> cartoes = cartaoRepository.findAll();
			return CartaoDTO.converter(cartoes);
		} else {
			return null;
		}
	}

//	@PostMapping
//	@Transactional
//	public ResponseEntity<CartaoDTO> cadastrar(@RequestBody @Valid ClienteCartaoForm cartaform,
//			UriComponentsBuilder uriBuilder) {
//		Cartao cartao = cartaform.converter(cartaoRepository);
//		cartaoRepository.save(cartao);
//
//		URI uri = uriBuilder.path("/cartao/{id}").buildAndExpand(cartao.getId()).toUri();
//		return ResponseEntity.created(uri).body(new CartaoDTO(cartao));
//	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable("id") Integer idcartao) {
		Optional<Cartao> optional = cartaoRepository.findById(idcartao);

		if (optional.isPresent()) {
			cartaoRepository.deleteById(idcartao);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping("/novo/{id}")
	@Transactional
	public ResponseEntity<CartaoDTO> cadastrar(@PathVariable("id") Integer id,
			@RequestBody @Valid ClienteCartaoForm clienteCartaoForm, UriComponentsBuilder uriBuilder) {
		
		Optional<Cliente> cliente = clienterepository.findById(id);
		
		Cartao cartao = clienteCartaoForm.converter(bandeiraRepository);
		cartaoRepository.save(cartao);
		clienteCartaoForm.cadastrarCartao(cartao, cliente.get(), clienterepository);
		
		URI uri = uriBuilder.path("/cartao/novo/{id}").buildAndExpand(cartao.getId()).toUri();
		return ResponseEntity.created(uri).body(new CartaoDTO(cartao));

	}

}
