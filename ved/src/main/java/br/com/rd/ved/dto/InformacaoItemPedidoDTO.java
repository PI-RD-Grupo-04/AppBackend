package br.com.rd.ved.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class InformacaoItemPedidoDTO {

	 private String descricaoProduto;
	 private BigDecimal precoUnitario;
	 private Integer quantidade;
	 
	 public InformacaoItemPedidoDTO() {}

	public InformacaoItemPedidoDTO(String descricaoProduto, BigDecimal precoUnitario, Integer quantidade) {
		this.descricaoProduto = descricaoProduto;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricaoProduto, precoUnitario, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InformacaoItemPedidoDTO other = (InformacaoItemPedidoDTO) obj;
		return Objects.equals(descricaoProduto, other.descricaoProduto)
				&& Objects.equals(precoUnitario, other.precoUnitario) && Objects.equals(quantidade, other.quantidade);
	} 
	
	
}
