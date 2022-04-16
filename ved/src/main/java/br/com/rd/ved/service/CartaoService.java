package br.com.rd.ved.service;

import org.springframework.stereotype.Service;

import br.com.rd.ved.repository.CartaoRepository;

@Service
public class CartaoService {

	private final CartaoRepository cartaoRepository;
	private Boolean sistema = true;
	
	public CartaoService(CartaoRepository cartaoRepository) {
		this.cartaoRepository = cartaoRepository;
	}
	
	
}
