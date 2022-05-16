package br.com.rd.ved.formdto;

import java.util.List;
import java.util.Optional;

import br.com.rd.ved.dto.ItemPedidoDTO;
import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.PedidoProdutoID;
import br.com.rd.ved.model.Produto;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.ProdutoRepository;

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

	public Integer getProduto() {
		return produto;
	}

	public void setProduto(Integer produto) {
		this.produto = produto;
	}

	public Integer getPedido() {
		return pedido;
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

	public ItemPedido converter(ProdutoRepository produtoRepository, PedidoRepository pedidoRepository) {
		PedidoProdutoID compost = new PedidoProdutoID();
		Optional<Produto> produto = produtoRepository.findById(compost.getIdPedido());
		Optional<Pedido> pedido = pedidoRepository.findById(compost.getIdProduto());
		
		ItemPedido itemPedido = new ItemPedido(pedido.get(), produto.get(), quantidade, porcentagemIcms, valorIcms);
		itemPedido.setProduto(produto.get());
		itemPedido.setPedido(pedido.get());
		return itemPedido;
	}

}
