package br.com.rd.ved.dto;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Pedido;
public class PedidoDTO {

	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private Date data;	
	private Integer cliente;
	private Integer cupomDesconto;
	private Integer pedidoStatus;
	private Integer frete;
	private Integer enderecos;
	
	public PedidoDTO(Pedido pedido) {		
		this.data = pedido.getData();
		this.cliente = pedido.getCliente().getId();
		this.cupomDesconto = pedido.getCupomDesconto().getId();
		this.pedidoStatus = pedido.getPedidoStatus().getId();
		this.frete = pedido.getFrete().getId();
		this.enderecos = pedido.getEnderecos().getId();
	}
	
	
	public String getData() { 
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String hoje = formato.format(data); 
		return hoje ; 
	} 

	public void setData(Date data) {
		this.data = data;
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

	public static List<PedidoDTO> converter(List<Pedido> pedidos) {
		return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}
}
