package br.com.rd.ved.formdto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.model.CupomDesconto;
import br.com.rd.ved.model.Endereco;
import br.com.rd.ved.model.Frete;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.PedidoStatus;
import br.com.rd.ved.repository.PedidoRepository;

public class PedidoForm {
	
	@NotNull
	@NotEmpty
	private Date data;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	@NotNull
	@NotEmpty
	private Cliente cliente;
	
	
	private CupomDesconto cupomDesconto;
	
	@NotNull
	@NotEmpty
	private PedidoStatus pedidoStatus;
	
	@NotNull
	@NotEmpty
	private Frete frete;
	
	@NotNull
	@NotEmpty
	private Endereco enderecos;

	public PedidoForm(@NotEmpty String data, SimpleDateFormat formato, @NotEmpty Cliente cliente,
			CupomDesconto cupomDesconto, @NotEmpty PedidoStatus pedidoStatus, @NotEmpty Frete frete,
			@NotEmpty Endereco enderecos) throws ParseException {
		this.data = formato.parse(data);
		this.formato = formato;
		this.cliente = cliente;
		this.cupomDesconto = cupomDesconto;
		this.pedidoStatus = pedidoStatus;
		this.frete = frete;
		this.enderecos = enderecos;
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
	
	public Pedido converter(PedidoRepository pedidoRepository) { 		
		return new Pedido(data, cliente, cupomDesconto, pedidoStatus, frete, enderecos);

	}	
}
