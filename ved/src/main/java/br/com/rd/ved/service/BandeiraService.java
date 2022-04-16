package br.com.rd.ved.service;

import org.springframework.stereotype.Service;

import br.com.rd.ved.repository.BandeiraRepository;

@Service
public class BandeiraService {
	private final BandeiraRepository bandeiraRepository;
	private Boolean sistema = true;
	
	public BandeiraService(BandeiraRepository bandeiraRepository) {
		this.bandeiraRepository = bandeiraRepository;
	}
	
	
}
