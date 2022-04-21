package br.com.rd.ved.service;

import org.springframework.stereotype.Service;

import br.com.rd.ved.repository.FreteRepository;

@Service
public class FreteService {
	private final FreteRepository freteRepository;
	private Boolean sistema = true;
	
	public FreteService(FreteRepository freteRepository) {
		this.freteRepository = freteRepository;
	}
	
	
}
