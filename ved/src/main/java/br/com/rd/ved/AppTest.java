package br.com.rd.ved;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rd.ved.repository.EnderecoRepository;
import br.com.rd.ved.repository.UfRepository;

public class AppTest {
	@Autowired
	static UfRepository ufRepository;
	@Autowired
	EnderecoRepository er;
	
	public static void main(String[] args) {
		
		//Endereco endereco = new Endereco("cep", "rua", 25, "complemento", "municipio", "cidade");
	//	System.out.println(endereco);
		//System.out.println();
		//Uf uf = ufRepository.findById(1);
		//System.out.println(uf);
		//endereco.setUf(uf.get());
		
	}



	
}
