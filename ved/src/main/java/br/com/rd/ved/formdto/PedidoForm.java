package br.com.rd.ved.formdto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import com.sun.istack.NotNull;

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

public class PedidoForm {
	
	@NotNull
	@NotEmpty
	private Date data;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	@NotNull
	@NotEmpty
	private Integer cliente;
	private Cliente cliente2;
	
	@NotNull
	@NotEmpty
	private Integer cupomDesconto;
	private CupomDesconto cupomDesconto2;
	
	@NotNull
	@NotEmpty
	private Integer pedidoStatus;
	private PedidoStatus pedidoStatus2;
	
	@NotNull
	@NotEmpty
	private Integer frete;
	private Frete frete2;
	
	@NotNull
	@NotEmpty
	private Integer enderecos;
	private Endereco endereco2;


	public PedidoForm(@NotEmpty String data,@NotEmpty String cliente, String cupomDesconto,
			@NotEmpty String pedidoStatus, @NotEmpty String frete, @NotEmpty String enderecos) throws ParseException {
		this.data = formato.parse(data);
		this.cliente = Integer.parseInt(cliente);
		this.cupomDesconto = Integer.parseInt(cupomDesconto);
		this.pedidoStatus = Integer.parseInt(pedidoStatus);
		this.frete = Integer.parseInt(frete);
		this.enderecos = Integer.parseInt(enderecos);
	}

	

	public PedidoForm(@NotEmpty Date data, Cliente cliente2, CupomDesconto cupomDesconto2, PedidoStatus pedidoStatus2,
			Frete frete2, Endereco endereco2) {
		this.data = data;
		this.cliente2 = cliente2;
		this.cupomDesconto2 = cupomDesconto2;
		this.pedidoStatus2 = pedidoStatus2;
		this.frete2 = frete2;
		this.endereco2 = endereco2;
	}



	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public SimpleDateFormat getFormato() {
		return formato;
	}

	public void setFormato(SimpleDateFormat formato) {
		this.formato = formato;
	}


	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Integer getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(Integer cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}

	public Integer getPedidoStatus() {
		return pedidoStatus;
	}

	public void setPedidoStatus(Integer pedidoStatus) {
		this.pedidoStatus = pedidoStatus;
	}

	public Integer getFrete() {
		return frete;
	}

	public void setFrete(Integer frete) {
		this.frete = frete;
	}

	public Integer getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(Integer enderecos) {
		this.enderecos = enderecos;
	}
	
	public Pedido converter(PedidoRepository pedidoRepository, 
							ClienteRepository clienteRepository,
							CupomDescontoRepository cupomDescontoRepository,
							PedidoStatusRepository pedidoStatusRepository,
							FreteRepository freteRepository,
							EnderecoRepository enderecoRepository) { 
		
		Optional<Cliente> cliente = clienteRepository.findById(this.cliente);
		Optional<CupomDesconto> cupomDesconto = cupomDescontoRepository.findById(this.cupomDesconto);
		Optional<PedidoStatus> pedidoStatus = pedidoStatusRepository.findById(this.pedidoStatus);
		Optional<Frete> frete = freteRepository.findById(this.frete);
		Optional<Endereco> endereco = enderecoRepository.findById(this.enderecos);
		Pedido pedido = new Pedido(data, cliente.get(), cupomDesconto.get(), pedidoStatus.get(), frete.get(), endereco.get());
				
		return pedido;

	}
	
	public Pedido converter1(PedidoRepository pedidoRepository) { 
		return new Pedido(data, cliente2, cupomDesconto2, pedidoStatus2, frete2, endereco2); } } 

