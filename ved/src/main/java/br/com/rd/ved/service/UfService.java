package br.com.rd.ved.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Uf;
import br.com.rd.ved.repository.UfRepository;

@Service
public class UfService {
	private final UfRepository ufRepository;
	private Boolean sistema = true;
	
	public UfService(UfRepository ufRepository) {
		this.ufRepository = ufRepository;
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
			System.out.println("Informe descrição para a UF");
			descricao = sc.next(); 
			Uf uf = new Uf(descricao);
			ufRepository.save(uf);
		
	}
	private void deletar(Scanner sc) {
		System.out.println("Digite o ID do uf");
		sc.nextLine(); 
		Integer id = Integer.parseInt(sc.nextLine());
		ufRepository.deleteById(id);
		System.out.println(" Deletado com Sucesso");
	}
}
	
	
