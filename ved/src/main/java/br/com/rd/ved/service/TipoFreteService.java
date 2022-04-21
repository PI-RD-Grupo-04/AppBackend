package br.com.rd.ved.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.TipoFrete;
import br.com.rd.ved.repository.TipoFreteRepository;

@Service
public class TipoFreteService {
	private final TipoFreteRepository tipoFreteRepository;
	private Boolean sistema = true;
	
	public TipoFreteService(TipoFreteRepository tipoFreteRepository) {
		this.tipoFreteRepository = tipoFreteRepository;
	}
	
	
	
	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no Funcionario");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - deletar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - atualizar");

			acao = sc.nextInt();

			switch (acao) {
			case 1:
				salvar(sc);
				break;
			case 2:
				deletar(sc);
				break;
			default:
				sistema = false;
				break;
			}
		}
	}
	
	
	private void salvar(Scanner sc) {
		 String descricao;
			System.out.println("Informe descrição para o tipo frete");
			descricao = sc.next(); 
			TipoFrete tipoFrete = new TipoFrete(descricao);
			tipoFreteRepository.save(tipoFrete);
		
	}
	
	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do tipo frete");
		sc.nextLine(); 
		Integer id = Integer.parseInt(sc.nextLine());
		tipoFreteRepository.deleteById(id);
		System.out.println(" Deletado com Sucesso");
	}
	
	
}
