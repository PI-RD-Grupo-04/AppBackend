package br.com.rd.ved.modell;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="historicoPedidos")
public class HistoricoPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataPedido;
	
	private Pedido pedido;
	
	private PedidoStatus pedidoStatus;

	public HistoricoPedido() {
		super();
	}

	public HistoricoPedido(Integer id, Date dataPedido, Pedido pedido, PedidoStatus pedidoStatus) {
		this.id = id;
		this.dataPedido = dataPedido;
		this.pedido = pedido;
		this.pedidoStatus = pedidoStatus;
	}

	public HistoricoPedido(Date dataPedido, Pedido pedido, PedidoStatus pedidoStatus) {
		this.dataPedido = dataPedido;
		this.pedido = pedido;
		this.pedidoStatus = pedidoStatus;
	}

	@Override
	public String toString() {
		return "HistoricoPedido [id=" + id + ", dataPedido=" + dataPedido + ", pedido=" + pedido + ", pedidoStatus="
				+ pedidoStatus + "]";
	}
	
	
}
