package br.com.rd.ved;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.rd.ved.service.ClienteService;

@SpringBootApplication
public class VedApplication implements CommandLineRunner {

	private ClienteService clienteService;
	private Boolean sistema = true;

	public VedApplication(ClienteService clienteService) {
		this.clienteService = clienteService;
	
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
			System.out.println("1 - Gestão de Clientes");
			

			acao = sc.nextInt();
			if (acao == 1) {
				clienteService.iniciar(sc);

			} else {
				sistema = false;
			}
		}
		sc.close();

	}

}
