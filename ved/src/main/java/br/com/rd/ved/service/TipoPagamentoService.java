package br.com.rd.ved.service;

import org.springframework.stereotype.Service;

import br.com.rd.ved.repository.TipoPagamentoRepository;

@Service
public class TipoPagamentoService {
	private final TipoPagamentoRepository tipoPagamentoRepository;
	private Boolean sistema = true;
	
	public TipoPagamentoService(TipoPagamentoRepository tipoPagamentoRepository) {
		this.tipoPagamentoRepository = tipoPagamentoRepository;
	}
	
	
}
