package br.com.rd.ved.formdto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.dto.ClientePedidoDTO;
import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.CupomDesconto;
import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.model.Frete;
import br.com.rd.ved.model.Pedido;


public class ClientePedidoForm {

	private Date data;
	private Cliente cliente;
	private CupomDesconto cupomDesconto;
	private Frete frete;
	private Endereco enderecos;

	public ClientePedidoForm(Date data, Cliente cliente, CupomDesconto cupomDesconto, Frete frete, Endereco enderecos) {
		this.data = data;
		this.cliente = cliente;
		this.cupomDesconto = cupomDesconto;
		this.frete = frete;
		this.enderecos = enderecos;
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

//	public static List<ClientePedidoForm> converter(List<Pedido> pedidos) {
//		return pedidos.stream().map(ClientePedidoForm::new).collect(Collectors.toList());
//	}

}
