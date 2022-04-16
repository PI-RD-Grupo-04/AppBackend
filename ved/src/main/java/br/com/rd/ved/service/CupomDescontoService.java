package br.com.rd.ved.service;

import org.springframework.stereotype.Service;

import br.com.rd.ved.repository.CupomDescontoRepository;

@Service
public class CupomDescontoService {
	private final CupomDescontoRepository cupomDescontoRepository;
	private Boolean sistema = true;
	
	public CupomDescontoService(CupomDescontoRepository cupomDescontoRepository) {
		this.cupomDescontoRepository = cupomDescontoRepository;
	}
	
	
}
