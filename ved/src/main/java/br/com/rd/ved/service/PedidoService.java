package br.com.rd.ved.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.CupomDesconto;
import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.model.Frete;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.PedidoStatus;
import br.com.rd.ved.repository.ClienteRepository;
import br.com.rd.ved.repository.CupomDescontoRepository;
import br.com.rd.ved.repository.EnderecoRepository;
import br.com.rd.ved.repository.FreteRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.PedidoStatusRepository;

@Service
public class PedidoService {
	private final PedidoRepository pedidoRepository;
	private final CupomDescontoRepository cupomDescontoRepository;
	private final FreteRepository freteRepository;
	private final EnderecoRepository enderecoRepository;
	private final PedidoStatusRepository pedidoStatusRepository;
	private final ClienteRepository clienteRepository;
	
	private Boolean sistema = true;
	
	private Integer id;
	private Date data;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private CupomDesconto cupomDesconto;
	private PedidoStatus pedidoStatus;
	private Frete frete;
	private Endereco endereco;
	
	
	
	public PedidoService(PedidoRepository pedidoRepository,CupomDescontoRepository cupomDescontoRepository, FreteRepository freteRepository,EnderecoRepository enderecoRepository,PedidoStatusRepository pedidoStatusRepository, ClienteRepository clienteRepository) {
		this.pedidoRepository = pedidoRepository;
		this.cupomDescontoRepository = cupomDescontoRepository;
		this.freteRepository = freteRepository;
		this.enderecoRepository = enderecoRepository;
		this.pedidoStatusRepository = pedidoStatusRepository;
		this.clienteRepository = clienteRepository;
		
	}
	
	
	public void iniciar(Scanner sc) throws ParseException {
		int acao;
		while (sistema) {
			System.out.println("Qual a ação que será realizada em Pedido");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			acao = sc.nextInt();

			switch (acao) {
			case 1:
				salvar(sc);
				break;
			case 2:
				atualizar(sc);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(sc);
				break;
			default:
				sistema = false;
				break;
			}
		}
	}

	private void deletar(Scanner sc) {
		int id;
		System.out.println("Informe o ID do pedido a ser Deletado");

		id = sc.nextInt();

		pedidoRepository.deleteById(id);

		System.out.println("Pedido deletado com sucesso!");

	}

	private void visualizar() {
		Iterable<Pedido> pedidos = pedidoRepository.findAll();
		pedidos.forEach(pedido -> System.out.println(pedido));
	}

	private void atualizar(Scanner sc) throws ParseException {

		System.out.println("Informe o Id do pedido a ser atualizado");
		id = sc.nextInt();
		
//		System.out.println("Informe a data do pedido (--/--/----)");
//		String dt = sc.nextLine();
//		data = formato.parse(dt);
//
//		System.out.println("Informe a qual cliente o pedido pertence");
//		Integer clienteId = Integer.parseInt(sc.nextLine());
//
//		System.out.println("Informe o cupom de desconto ");
//		Integer cupomDescontoId = Integer.parseInt(sc.nextLine());
//		
//		System.out.println("Informe o status do pedido ");
//		Integer pedidoStatus = Integer.parseInt(sc.nextLine());
//		
//		System.out.println("Informe o frete ");
//		Integer freteId = Integer.parseInt(sc.nextLine());
		
		System.out.println("Informe o endereço ");
		Integer enderecoId = Integer.parseInt(sc.nextLine());
		
		Pedido pedido = pedidoRepository.findById(id).get();
		//Pedido pedido = new Pedido();
		pedido.setData(data);
		
//		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//		pedido.setCliente(cliente.get());
//				
//		Optional<CupomDesconto> cupomDesconto = cupomDescontoRepository.findById(cupomDescontoId);
//		pedido.setCupomDesconto(cupomDesconto.get());
//				
//		Optional<Frete> frete = freteRepository.findById(freteId);
//		pedido.setFrete(frete.get());
//		
		Optional<Endereco> endereco = enderecoRepository.findById(enderecoId);
		pedido.setEndereco(endereco.get());
//		
//		Optional<PedidoStatus> pedidostatus = pedidoStatusRepository.findById(pedidoStatus);
//		pedido.setPedidoStatus(pedidostatus.get());

		pedidoRepository.save(pedido);
		
		
		System.out.println("Cupom de Desconto Atualizado com Sucesso");

	}

	private void salvar(Scanner sc) throws ParseException {

		System.out.println("Informe o Id do pedido a ser atualizado");
		id = sc.nextInt();
		
		System.out.println("Informe a data do pedido (--/--/----)");
		String dt = sc.nextLine();
		data = formato.parse(dt);

//		System.out.println("Informe a qual cliente o pedido pertence");
//		Integer clienteId = Integer.parseInt(sc.nextLine());

		System.out.println("Informe o cupom de desconto ");
		Integer cupomDescontoId = Integer.parseInt(sc.nextLine());
		
		System.out.println("Informe o status do pedido ");
		Integer pedidoStatus = Integer.parseInt(sc.nextLine());
		
		System.out.println("Informe o frete ");
		Integer freteId = Integer.parseInt(sc.nextLine());
		
		System.out.println("Informe o endereço ");
		Integer enderecoId = Integer.parseInt(sc.nextLine());
		
		
		Pedido pedido = new Pedido();
		pedido.setData(data);
		
//		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//		pedido.setCliente(cliente.get());
		
		Optional<CupomDesconto> cupomDesconto = cupomDescontoRepository.findById(cupomDescontoId);
		pedido.setCupomDesconto(cupomDesconto.get());
				
		Optional<Frete> frete = freteRepository.findById(freteId);
		pedido.setFrete(frete.get());
		
		Optional<Endereco> endereco = enderecoRepository.findById(enderecoId);
		pedido.setEndereco(endereco.get());
		
		Optional<PedidoStatus> pedidostatus = pedidoStatusRepository.findById(pedidoStatus);
		pedido.setPedidoStatus(pedidostatus.get());

		pedidoRepository.save(pedido);

		System.out.println("Pedido Salvo com Sucesso");

	}

}

