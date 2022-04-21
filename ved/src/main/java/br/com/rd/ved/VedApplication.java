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
import br.com.rd.ved.service.ClienteService;
import br.com.rd.ved.service.CupomDescontoService;
import br.com.rd.ved.service.EnderecoService;
import br.com.rd.ved.service.FornecedorService;
import br.com.rd.ved.service.FreteService;
import br.com.rd.ved.service.HistoricoPedidoService;
import br.com.rd.ved.service.ItemPedidoService;
import br.com.rd.ved.service.MarcaService;
import br.com.rd.ved.service.NotaFiscalService;
import br.com.rd.ved.service.PedidoService;
import br.com.rd.ved.service.PedidoStatusService;
import br.com.rd.ved.service.PixService;
import br.com.rd.ved.service.ProdutoService;
import br.com.rd.ved.service.ReceitaService;
import br.com.rd.ved.service.SerieService;
import br.com.rd.ved.service.StatusProdutoService;
import br.com.rd.ved.service.TipoFreteService;
import br.com.rd.ved.service.TipoPagamentoService;
import br.com.rd.ved.service.UfService;
import br.com.rd.ved.service.UsuarioService;

@EnableJpaRepositories 
@SpringBootApplication

public class VedApplication implements CommandLineRunner  {
	
	private Boolean sistema = true;
	private final ArmazenamentoService armazenamentoService;
	private final BandeiraService bandeiraService;
	private final BoletoService boletoService;
	private final CartaoService cartaoService;
	private final CategoriaService categoriaService;
	private final ClienteService clienteService;
	private final CupomDescontoService cupomDescontoService;
	private final EnderecoService enderecoService;
	private final FornecedorService fornecedorService;
	private final FreteService freteService;
	private final HistoricoPedidoService historicoPedidoService;
	private final ItemPedidoService itemPedidoService;
	private final MarcaService marcaService;
	private final NotaFiscalService notaFiscalService;
	private final PedidoService pedidoService;
	private final PedidoStatusService pedidoStatusService;
	private final PixService pixService;
	private final ProdutoService produtoService;
	private final ReceitaService receitaService;
	private final SerieService serieService;
	private final StatusProdutoService statusProdutoService;
	private final TipoFreteService tipoFreteService;
	private final TipoPagamentoService tipoPagamentoService;
	private final UfService ufService;
	private final UsuarioService usuarioService;

	

	public VedApplication(ArmazenamentoService armazenamentoService, BandeiraService bandeiraService,
			BoletoService boletoService, CartaoService cartaoService, CategoriaService categoriaService,
			ClienteService clienteService, CupomDescontoService cupomDescontoService, EnderecoService enderecoService,
			FornecedorService fornecedorService, FreteService freteService,
			HistoricoPedidoService historicoPedidoService, ItemPedidoService itemPedidoService,
			MarcaService marcaService, NotaFiscalService notaFiscalService, PedidoService pedidoService,
			PedidoStatusService pedidoStatusService, PixService pixService, ProdutoService produtoService,
			ReceitaService receitaService, SerieService serieService, StatusProdutoService statusProdutoService,
			TipoFreteService tipoFreteService, TipoPagamentoService tipoPagamentoService, UfService ufService,
			UsuarioService usuarioService) {
		this.armazenamentoService = armazenamentoService;
		this.bandeiraService = bandeiraService;
		this.boletoService = boletoService;
		this.cartaoService = cartaoService;
		this.categoriaService = categoriaService;
		this.clienteService = clienteService;
		this.cupomDescontoService = cupomDescontoService;
		this.enderecoService = enderecoService;
		this.fornecedorService = fornecedorService;
		this.freteService = freteService;
		this.historicoPedidoService = historicoPedidoService;
		this.itemPedidoService = itemPedidoService;
		this.marcaService = marcaService;
		this.notaFiscalService = notaFiscalService;
		this.pedidoService = pedidoService;
		this.pedidoStatusService = pedidoStatusService;
		this.pixService = pixService;
		this.produtoService = produtoService;
		this.receitaService = receitaService;
		this.serieService = serieService;
		this.statusProdutoService = statusProdutoService;
		this.tipoFreteService = tipoFreteService;
		this.tipoPagamentoService = tipoPagamentoService;
		this.ufService = ufService;
		this.usuarioService = usuarioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(VedApplication.class, args);
	}
   
	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int acao;

		while (sistema) {
			System.out.println("\n\nQual a ação que será executada?");
			System.out.println("0 - Sair");
			System.out.println("1 - Armazenamento");
			System.out.println("2 - Bandeira");
			System.out.println("3 - Boleto");
			System.out.println("4 - Cartão");
			System.out.println("5 - Categoria");
			System.out.println("6 - Cliente");
			System.out.println("7 - Cupom-Desconto");
			System.out.println("8 - Endereço");
			System.out.println("9 - Fornecedor");
			System.out.println("10 - Frete");
			System.out.println("11 - Historico-Pedido");
			System.out.println("12 - Item-Pedido");
			System.out.println("13 - Marca");
			System.out.println("14 - Nota-Fiscal");
			System.out.println("15 - Pedido");
			System.out.println("16 - Pedido-Status");
			System.out.println("17 - Pix");
			System.out.println("18 - Produto");
			System.out.println("19 - Receita");
			System.out.println("20 - Serie");
			System.out.println("21 - Status-Produto");
			System.out.println("22 - Tipo-Frete");
			System.out.println("23 - Tipo-Pagamento");
			System.out.println("24 - UF");
			System.out.println("25 - Usuario");
			System.out.print(">>>");
	
			acao = Integer.parseInt(sc.nextLine());

			switch(acao) {
			case 1:
				armazenamentoService.iniciar(sc);
				break;
			case 2:
				bandeiraService.iniciar(sc);
				break;
			case 3:
				boletoService.iniciar(sc);
				break;
			case 4:
				cartaoService.iniciar(sc);
				break;
			case 5:
				categoriaService.iniciar(sc);
				break;
			case 6:
				System.out.println("funcionou");
				break;
			case 7:
				cupomDescontoService.iniciar(sc);			
				break;
			case 8:
				enderecoService.iniciar(sc);
				break;
			case 9:
				fornecedorService.iniciar(sc);
				break;
			case 10:
				System.out.println("funcionou");
				break;
			case 11:
				System.out.println("funcionou");
				break;
			case 12:
				System.out.println("funcionou");
				break;
			case 13:
				marcaService.iniciar(sc);
				break;
			case 14:
				System.out.println("funcionou");
				break;
			case 15:
				System.out.println("funcionou");
				break;
			case 16:
				System.out.println("funcionou");
				break;
			case 17:
				pixService.iniciar(sc);
				break;
			case 18:
				System.out.println("funcionou");
				break;
			case 19:
				receitaService.iniciar(sc);
				break;
			case 20:
				serieService.iniciar(sc);
				break;
			case 21:
				statusProdutoService.iniciar(sc);
				break;
			case 22:
				tipoFreteService.iniciar(sc);
				break;
			case 23:
				System.out.println("funcionou");
				break;
			case 24:
				ufService.iniciar(sc);
				break;
			case 25:
				System.out.println("funcionou");
				break;
			default:
			       System.out.println("Número inválido");
		}
	}
		sc.close();
	}
}


