package br.com.rd.ved;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.rd.ved.service.ArmazenamentoService;
import br.com.rd.ved.service.BandeiraService;
import br.com.rd.ved.service.BoletoService;
import br.com.rd.ved.service.CartaoService;
import br.com.rd.ved.service.CategoriaService;
import br.com.rd.ved.service.MarcaService;
import br.com.rd.ved.service.PixService;
import br.com.rd.ved.service.SerieService;
import br.com.rd.ved.service.StatusProdutoService;
import br.com.rd.ved.service.TipoFreteService;
import br.com.rd.ved.service.UfService;

@EnableJpaRepositories 
@SpringBootApplication

public class VedApplication implements CommandLineRunner  {
	
	private Boolean sistema = true;
	private final BandeiraService bandeiraService;
	private final CartaoService cataoService;
	private final CategoriaService categoriaService;
	private final StatusProdutoService statusProdutoService;
	private final MarcaService marcaService;
	private final PixService pixService;
	private final BoletoService boletoService;
	private final ArmazenamentoService armazenamentoService;
	private final SerieService serieService;
	private final TipoFreteService tipoFreteService;
	private final UfService ufService;
	
	

	public VedApplication(BandeiraService bandeiraService, CartaoService cataoService , CategoriaService categoriaService , StatusProdutoService statusProdutoService, MarcaService marcaService , PixService pixService, BoletoService boletoService , ArmazenamentoService armazenamentoService , SerieService serieService,TipoFreteService tipoFreteService, UfService ufService) {
		this.bandeiraService = bandeiraService;
		this.cataoService = cataoService;
		this.categoriaService = categoriaService;
		this.statusProdutoService = statusProdutoService;
		this.marcaService = marcaService;
		this.pixService = pixService;
		this.boletoService = boletoService;
		this.armazenamentoService = armazenamentoService;
		this.serieService = serieService;
		this.tipoFreteService = tipoFreteService;
		this.ufService = ufService;
		
		
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
			System.out.println("3 - Categoria");
			System.out.println("4 - Status do Produto");
			System.out.println("5 - Marca");
			System.out.println("6 - Pix");
			System.out.println("7 - Boleto");
			System.out.println("8 - Armazenamento");
			System.out.println("9 - Serie");
			System.out.println("10 - Tipo Frete");
			System.out.println("11 - Uf");
			
			
			

			acao = Integer.parseInt(sc.nextLine());

			if (acao == 1) {
				bandeiraService.iniciar(sc);
				}
				else if (acao == 2){
				cataoService.iniciar(sc);
				}
				else if (acao == 3){
				categoriaService.iniciar(sc);
				}
				else if (acao == 4){
				statusProdutoService.iniciar(sc);
				}
				else if (acao == 5){
				marcaService.iniciar(sc);
				}
				else if (acao == 6){
				pixService.iniciar(sc);
				}
				else if (acao == 7){
				boletoService.iniciar(sc);
				}
				else if (acao == 8){
				armazenamentoService.iniciar(sc);
				}
				else if (acao == 9){
				serieService.iniciar(sc);
				}
				else if (acao == 10){
				tipoFreteService.iniciar(sc);
				}
				else if (acao == 11){
				ufService.iniciar(sc);
				}
				else {
				sistema = false;
			}
		}
		sc.close();
	}
}