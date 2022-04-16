package br.com.rd.ved.service;

import org.springframework.stereotype.Service;

import br.com.rd.ved.repository.ReceitaRepository;

@Service
public class ReceitaService {
	private final ReceitaRepository receitaRepository;
	private Boolean sistema = true;
	
	public ReceitaService(ReceitaRepository receitaRepository) {
		this.receitaRepository = receitaRepository;
	}
	
	
}
