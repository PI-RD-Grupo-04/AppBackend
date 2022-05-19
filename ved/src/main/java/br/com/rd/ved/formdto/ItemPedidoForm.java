package br.com.rd.ved.formdto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import br.com.rd.ved.dto.ItemPedidoDTO;
import br.com.rd.ved.model.ItemPedido;
import br.com.rd.ved.model.Pedido;
import br.com.rd.ved.model.Produto;
import br.com.rd.ved.repository.ItemPedidoRepository;
import br.com.rd.ved.repository.PedidoRepository;
import br.com.rd.ved.repository.ProdutoRepository;

public class ItemPedidoForm {

	private Integer quantidade;
	private Double porcentagemIcms;
	private Double valorIcms;
	private Integer produto;
	private Integer pedido;
	
	public ItemPedidoForm() {}
	
	public ItemPedidoForm(String quantidade, String porcentagemIcms, String valorIcms, String produto,
			String pedido) {
		this.quantidade = Integer.parseInt(quantidade);
		this.porcentagemIcms = Double.parseDouble(porcentagemIcms);
		this.valorIcms = Double.parseDouble(porcentagemIcms);
		this.produto = Integer.parseInt(produto);
		this.pedido = Integer.parseInt(pedido);
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


	public List<ItemPedidoDTO> cadastrarItemPedido(ItemPedido itemPedido, Pedido pedido, Produto produto,
			ItemPedidoRepository itemPedidoRepository, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
		
		Set<ItemPedido> itemPedidos;
		
		itemPedidos = pedido.getItemPedidos();
		itemPedidos = produto.getItemPedido();
		itemPedidos.add(itemPedido);
		pedido.setItemPedido(itemPedidos);
		produto.setItemPedido(itemPedidos);
		itemPedidoRepository.saveAll(Arrays.asList(itemPedido));
		return ItemPedidoDTO.converter(itemPedidos);
		
	}

	public ItemPedido converter(ProdutoRepository produtoRepository, PedidoRepository pedidoRepository) {
		Optional<Produto> produto = produtoRepository.findById(this.produto);
		Optional<Pedido> pedido = pedidoRepository.findById(this.pedido);
		
		ItemPedido itemPedido = new ItemPedido(pedido.get(), produto.get(), quantidade, porcentagemIcms, valorIcms);
		return itemPedido;
	}

}
