package br.com.rd.ved.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.ved.dto.PedidoDTO;
import br.com.rd.ved.model.Categoria;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.repository.CategoriaRepository;
import br.com.rd.ved.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/categoria")	
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping
	public List<ProdutoDTO> listar() {
		List<Produto> produtos = produtoRepository.findAll();
		return ProdutoDTO.converter(produtos);
	}
	
	
	
	
	@GetMapping("/produto={id}/categoria")
	public ResponseEntity<ProdutoDTO> visualizar(@PathVariable("id") Integer id,
			@PathVariable("produto") Integer idProduto) {

		Optional<Categoria> categoria = categoriaRepository.findById(id);
		Optional<Produto> produto = produtoRepository.findById(idProduto);
		List<Produto> produtos = new ArrayList<>();
		produtos = categoria.get().getProdutos();

		if (categoria.isPresent() && produtos.contains(produto.get())) {

			return ResponseEntity.ok().body(new PedidoDTO(produto.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
}
