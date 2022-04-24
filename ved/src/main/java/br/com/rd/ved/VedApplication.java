package br.com.rd.ved;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.rd.ved.service.ClienteService;
import br.com.rd.ved.service.CupomDescontoService;
import br.com.rd.ved.service.FornecedorService;
import br.com.rd.ved.service.PedidoService;
import br.com.rd.ved.service.ReceitaService;

@SpringBootApplication
public class VedApplication implements CommandLineRunner {

	private ClienteService clienteService;
	private FornecedorService fornecedorService;
	private ReceitaService receitaService;
	private CupomDescontoService cupomDescontoService;
	private PedidoService pedidoService;
	private Boolean sistema = true;

	public VedApplication(ClienteService clienteService, FornecedorService fornecedorService, ReceitaService receitaService, CupomDescontoService cupomDescontoService, PedidoService pedidoService) {
		this.clienteService = clienteService;
		this.fornecedorService = fornecedorService;
		this.receitaService = receitaService;
		this.cupomDescontoService = cupomDescontoService;
		this.pedidoService = pedidoService;
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
			System.out.println("2 - Gestão de Fornecedores");
			System.out.println("3 - Gestão de Receitas");
			System.out.println("4 - Gestão de Cupom de Desconto");
			
			
			acao = sc.nextInt();
			if (acao == 1) {
				clienteService.iniciar(sc);
			} else if (acao == 2) {
				fornecedorService.iniciar(sc);
			} else if (acao == 3) {
				receitaService.iniciar(sc);
			} else if (acao == 4) {
				cupomDescontoService.iniciar(sc);
			} else if (acao == 5) {
				pedidoService.iniciar(sc);

			} else {
				sistema = false;
			}
		}
		sc.close();
	}
}
