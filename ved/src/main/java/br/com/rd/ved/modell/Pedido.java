package br.com.rd.ved.modell;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	
	private Cliente cliente;
	
	private CupomDesconto cupomDesconto;
	
	private PedidoStatus pedidoStatus;
	
	private Frete frete;
	
	private Endereco endereco;

	public Pedido() {
		super();
	}

	public Pedido(Integer id, Date data, Cliente cliente, CupomDesconto cupomDesconto, PedidoStatus pedidoStatus,
			Frete frete, Endereco endereco) {
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.cupomDesconto = cupomDesconto;
		this.pedidoStatus = pedidoStatus;
		this.frete = frete;
		this.endereco = endereco;
	}

	public Pedido(Date data, Cliente cliente, CupomDesconto cupomDesconto, PedidoStatus pedidoStatus, Frete frete,
			Endereco endereco) {
		this.data = data;
		this.cliente = cliente;
		this.cupomDesconto = cupomDesconto;
		this.pedidoStatus = pedidoStatus;
		this.frete = frete;
		this.endereco = endereco;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", cliente=" + cliente + ", cupomDesconto=" + cupomDesconto
				+ ", pedidoStatus=" + pedidoStatus + ", frete=" + frete + ", endereco=" + endereco + "]";
	}
	
	
}