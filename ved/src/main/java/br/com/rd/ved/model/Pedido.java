package br.com.rd.ved.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rd.ved.enums.StatusPedido;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Integer id;
	
	@Column(name = "data_pedido")
	private LocalDate data;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido status;
	
	@Column(name = "total", precision = 20, scale = 2)
    private BigDecimal total;
	
	@ManyToOne(fetch=FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name="id_cliente", nullable=false)
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name="id_cupomDesconto", nullable=true)
	private CupomDesconto cupomDesconto;
	
	@ManyToOne(fetch=FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name="id_pedidoStatus", nullable=false)
	private PedidoStatus pedidoStatus;
	
	@ManyToOne(fetch=FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name="id_frete", nullable=false)
	private Frete frete;
	
	@ManyToOne(fetch=FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name="id_endereco", nullable=false)
	private Endereco enderecos;
	@JsonIgnore
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itemPedidos;
	@JsonIgnore
	@OneToMany(mappedBy = "pedido")
	private List <NotaFiscal> notafiscal; 
	
	@JsonIgnore
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pagamento", joinColumns = { @JoinColumn(name = "id_pedido") }, inverseJoinColumns = {
			@JoinColumn(name = "id_tipo_pagamento") })
	private List<TipoPagamento> tipoPagamento;
	
	

	public Pedido() {
		super();
	}

	public Pedido(Integer id, LocalDate data, StatusPedido status, BigDecimal total, Cliente cliente,
			CupomDesconto cupomDesconto, PedidoStatus pedidoStatus, Frete frete, Endereco enderecos,
			List<ItemPedido> itemPedidos, List<NotaFiscal> notafiscal, List<TipoPagamento> tipoPagamento) {
		this.id = id;
		this.data = data;
		this.status = status;
		this.total = total;
		this.cliente = cliente;
		this.cupomDesconto = cupomDesconto;
		this.pedidoStatus = pedidoStatus;
		this.frete = frete;
		this.enderecos = enderecos;
		this.itemPedidos = itemPedidos;
		this.notafiscal = notafiscal;
		this.tipoPagamento = tipoPagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
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

	public void setEnderecos(Endereco endereco) {
		this.enderecos = endereco;
	}
	
	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}
			
	public StatusPedido getStatus() {
		return status;
	}


	public void setStatus(StatusPedido status) {
		this.status = status;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public List<NotaFiscal> getNotafiscal() {
		return notafiscal;
	}


	public void setNotafiscal(List<NotaFiscal> notafiscal) {
		this.notafiscal = notafiscal;
	}


	public List<TipoPagamento> getTipoPagamento() {
		return tipoPagamento;
	}


	public void setTipoPagamento(List<TipoPagamento> tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}


	@Override
	public int hashCode() {
		return Objects.hash(data, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", cliente=" + cliente.getNome() + ", cupomDesconto=" + cupomDesconto.getDescricao()
				+ ", pedidoStatus=" + pedidoStatus.getDescricao() + ", frete=" + frete + ", endereco=" + enderecos + "]";
	}

}
