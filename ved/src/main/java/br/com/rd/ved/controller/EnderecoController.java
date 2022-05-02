package br.com.rd.ved.controller;

import java.util.List;

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

import br.com.rd.ved.dto.EnderecoDTO;
import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired 
	private EnderecoRepository er; 
	
	@GetMapping 
	public List<EnderecoDTO> listar(){
		List<Endereco> enderecos = er.findAll();
		return EnderecoDTO.converter(enderecos); 
	} 
	

	
}
