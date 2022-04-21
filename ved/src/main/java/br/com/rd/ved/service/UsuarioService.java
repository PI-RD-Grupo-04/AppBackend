package br.com.rd.ved.service;

import org.springframework.stereotype.Service;

import br.com.rd.ved.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	private Boolean sistema = true;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	
}
