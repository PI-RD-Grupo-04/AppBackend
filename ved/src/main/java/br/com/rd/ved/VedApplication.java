package br.com.rd.ved;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.rd.ved.service.BandeiraService;
import br.com.rd.ved.service.CartaoService;
@EnableJpaRepositories 
@SpringBootApplication

public class VedApplication implements CommandLineRunner  {
	
	private Boolean sistema = true;
	private final BandeiraService bandeiraService;
	private final CartaoService cataoService;

	public VedApplication(BandeiraService bandeiraService, CartaoService cataoService) {
		this.bandeiraService = bandeiraService;
		this.cataoService = cataoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(VedApplication.class, args);
	}
   
	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será executada?");
			System.out.println("0 - Sair");
			System.out.println("1 - Bandeira");
			System.out.println("2 - Cartao");

			acao = Integer.parseInt(sc.nextLine());

			if (acao == 1) {
				bandeiraService.iniciar(sc);
			}else if (acao == 2){
				cataoService.iniciar(sc);
			}
			else {
				sistema = false;
			}
		}
		sc.close();
	}
}