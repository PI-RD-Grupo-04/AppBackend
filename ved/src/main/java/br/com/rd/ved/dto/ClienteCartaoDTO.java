package br.com.rd.ved.dto;

import br.com.rd.ved.model.Bandeira;
import br.com.rd.ved.model.Cartao;

public class ClienteCartaoDTO {

	

	private String numeroCartao;
	private Integer anoVencimento;
	private Integer diaVencimento;
	private Bandeira idBandeira;
	
	
	
	ClienteCartaoDTO (Cartao cartao){
		this.numeroCartao = cartao.getNumeroCartao();
		this.anoVencimento = cartao.getAnoVencimento();
		this.diaVencimento = cartao.getDiaVencimento();
		this.idBandeira = cartao.getBandeiraId();
		
	}
	
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public Integer getAnoVencimento() {
		return anoVencimento;
	}
	public void setAnoVencimento(Integer anoVencimento) {
		this.anoVencimento = anoVencimento;
	}
	public Bandeira getIdBandeira() {
		return idBandeira;
	}
	public void setIdBandeira(Bandeira idBandeira) {
		this.idBandeira = idBandeira;
	}
	public Integer getDiaVencimento() {
		return diaVencimento;
	}
	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}
	
	
	
	
}
