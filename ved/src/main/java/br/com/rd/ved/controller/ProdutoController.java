package br.com.rd.ved.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.ved.dto.ProdutoCardDTO;
import br.com.rd.ved.model.Produto;
import br.com.rd.ved.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping 
	public List<ProdutoCardDTO> listarCard(){
		List<Produto> produtos = produtoRepository.findAll();
		return ProdutoCardDTO.converter(produtos);
	} 
	
	
	
	
}
