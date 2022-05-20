package br.com.rd.ved.formdto;


public class ItemPedidoForm {

	private String quantidade;
	private String porcentagemIcms;
	private String valorIcms;
	private String produto;
	private String pedido;
	
	public ItemPedidoForm() {}
	

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getPorcentagemIcms() {
		return porcentagemIcms;
	}

	public void setPorcentagemIcms(String porcentagemIcms) {
		this.porcentagemIcms = porcentagemIcms;
	}

	public String getValorIcms() {
		return valorIcms;
	}

	public void setValorIcms(String valorIcms) {
		this.valorIcms = valorIcms;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

<<<<<<< HEAD
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
	
	

=======
>>>>>>> f3a18c271a986d09b2d0cc8d0993ad51ac0eda39
}
