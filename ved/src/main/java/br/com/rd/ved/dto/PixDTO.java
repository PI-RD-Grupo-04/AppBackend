package br.com.rd.ved.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.ved.model.Pix;

public class PixDTO {

	private Integer id;
	private String codigoPix;
	private Pix quantidade;
	private Pix preco;
	private Pix produto;
	private Pix pedido;

	public Integer getId() {
		return id;
	}

	public String getCodigoPix() {
		return codigoPix;
	}

	public PixDTO(Pix pix) {

		this.codigoPix = pix.getCodigoPix();
		this.quantidade = pix.getQuantidade();
		this.preco = pix.getPreco();
		this.produto = pix.getProduto().getPreco();
		this.pedido = pix.getPedido();
	}

	public Pix getQuantidade() {
		return quantidade;
	}

	public Pix getPreco() {
		return preco;
	}

	public Pix getPedido() {
		return pedido;
	}

	public Pix getProduto() {
		return produto;
	}

	public static List<PixDTO> converter(List<Pix> pixs) {
		return pixs.stream().map(PixDTO::new).collect(Collectors.toList());
	}

}