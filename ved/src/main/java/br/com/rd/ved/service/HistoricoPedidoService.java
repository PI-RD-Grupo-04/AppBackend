package br.com.rd.ved.service;

import org.springframework.stereotype.Service;

import br.com.rd.ved.repository.HistoricoPedidoRepository;

@Service
public class HistoricoPedidoService {
	private final HistoricoPedidoRepository historicoPedidoRepository;
	private Boolean sistema = true;
	
	public HistoricoPedidoService(HistoricoPedidoRepository historicoPedidoRepository) {
		this.historicoPedidoRepository = historicoPedidoRepository;
	}
	
	
}
