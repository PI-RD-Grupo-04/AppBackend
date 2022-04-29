package br.com.rd.ved.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.CupomDesconto;
import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.model.Frete;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.PedidoStatus;

public class PedidoDTO {

	private Integer id;
	private Date data;
	private Cliente cliente;
	private CupomDesconto cupomDesconto;
	private PedidoStatus pedidoStatus;
	private Frete frete;
	private Endereco enderecos;

	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.data = pedido.getData();
		this.cliente = pedido.getCliente();
		this.cupomDesconto = pedido.getCupomDesconto();
		this.pedidoStatus = pedido.getPedidoStatus();
		this.frete = pedido.getFrete();
		this.enderecos = pedido.getEnderecos();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public CupomDesconto getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(CupomDesconto cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}

	public PedidoStatus getPedidoStatus() {
		return pedidoStatus;
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		this.pedidoStatus = pedidoStatus;
	}

	public Frete getFrete() {
		return frete;
	}

	public void setFrete(Frete frete) {
		this.frete = frete;
	}

	public Endereco getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco enderecos) {
		this.enderecos = enderecos;
	}

	public static List<PedidoDTO> converter(List<Pedido> pedidos) {
		return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}
}
