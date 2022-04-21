package br.com.rd.ved.service;

import org.springframework.stereotype.Service;

import br.com.rd.ved.repository.PedidoRepository;

@Service
public class PedidoService {
	private final PedidoRepository pedidoRepository;
	private Boolean sistema = true;
	
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	
}
