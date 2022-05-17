package br.com.rd.ved.formdto;

import java.util.List;

import br.com.rd.ved.dto.ItemPedidoDTO;
import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.PedidoProdutoID;
import br.com.rd.ved.model.Produto;
import br.com.rd.ved.repository.ItemPedidoRepository;
import br.com.rd.ved.repository.PedidoRepository;

public class ItemPedidoForm {

	private Integer pedido;
	private Integer produto;
	private Integer quantidade;
	private Double porcentagemIcms;
	private Double valorIcms;
	
	public ItemPedidoForm() {}
	
	public ItemPedidoForm(String pedido, String produto, String quantidade, String porcentagemIcms, 
			String valorIcms) {
		this.pedido = Integer.parseInt(pedido);
		this.produto = Integer.parseInt(produto);
		this.quantidade = Integer.parseInt(quantidade);
		this.porcentagemIcms = Double.parseDouble(porcentagemIcms);
		this.valorIcms = Double.parseDouble(porcentagemIcms);		
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPorcentagemIcms() {
		return porcentagemIcms;
	}

	public void setPorcentagemIcms(Double porcentagemIcms) {
		this.porcentagemIcms = porcentagemIcms;
	}

	public Double getValorIcms() {
		return valorIcms;
	}

	public void setValorIcms(Double valorIcms) {
		this.valorIcms = valorIcms;
	}

	
	public Integer getPedido() {
		return pedido;
	}

	public Integer getProduto() {
		return produto;
	}

	public void setProduto(Integer produto) {
		this.produto = produto;
	}


	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}

	public List<ItemPedidoDTO> cadastrarItemPedido(ItemPedido itemPedido, Pedido pedido, PedidoRepository pedidoRepository) {
		List<ItemPedido> itemPedidos;
		itemPedidos = pedido.getItemPedidos();
		itemPedidos.add(itemPedido);
		pedido.setItemPedidos(itemPedidos);
		pedidoRepository.save(pedido);
		return ItemPedidoDTO.converter(itemPedidos);
		
	}

	public ItemPedido converter(ItemPedidoRepository ipr, Pedido pedido, Produto produto) {
		PedidoProdutoID compost = new PedidoProdutoID();
		compost.setIdPedido(pedido.getId());
		compost.setIdProduto(produto.getId());
		
		ItemPedido itemPedido = new ItemPedido(pedido, produto, quantidade, porcentagemIcms, valorIcms);
		ipr.save(itemPedido);
		return itemPedido;
	}

}
