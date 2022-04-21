package br.com.rd.ved.service;

import org.springframework.stereotype.Service;

import br.com.rd.ved.repository.ClienteRepository;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	private Boolean sistema = true;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	
}
