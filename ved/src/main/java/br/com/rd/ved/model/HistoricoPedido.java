package br.com.rd.ved.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historico_pedidos")
public class HistoricoPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historico_pedido")
	private Integer id;
	@Column(name = "data_pedido")
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
