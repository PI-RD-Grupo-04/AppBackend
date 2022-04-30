package br.com.rd.ved.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.rd.ved.dto.ClienteCartaoDTO;
import br.com.rd.ved.model.Cartao;
import br.com.rd.ved.repository.CartaoRepository;


//@RestController
//@RequestMapping("/cartao")

public class ClienteCartaoController {
	
//	@Autowired
//	private CartaoRepository cartaoRepository;
//	
//	@GetMapping
//	public List<ClienteCartaoDTO> listar(Integer idcliente){
//		if(idcliente == null) {
//			List<Cartao> cartoes = cartaoRepository.findAll();
//			return ClienteCartaoDTO.converter(cartoes);
//		} else {
//			List<Cartao> cartoes = cartaoRepository.findByClienteId(idcliente);
//			return ClienteCartaoDTO.converter(cartoes);
//		}	
//	}
//}
}



