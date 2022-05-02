package br.com.rd.ved.formdto;


import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.rd.ved.model.Bandeira;
import br.com.rd.ved.model.Cartao;
import br.com.rd.ved.repository.CartaoRepository;


public class ClienteCartaoForm {

		@NotNull
		@NotEmpty
		private String numeroCartao;
		@NotNull
		@NotEmpty
		private String nomeTitular;
		@NotNull
		@NotEmpty
		private String cpfTitular;
		@NotNull
		@NotEmpty
		private Integer diaVencimento;
		@NotNull
		@NotEmpty
		private Integer anoVencimento;
		@NotNull
		@NotEmpty
		private Bandeira idBandeira;
		
		
		public String getNumeroCartao() {
			return numeroCartao;
		}
		public void setNumeroCartao(String numeroCartao) {
			this.numeroCartao = numeroCartao;
		}
		public String getNomeTitular() {
			return nomeTitular;
		}
		public void setNomeTitular(String nomeTitular) {
			this.nomeTitular = nomeTitular;
		}
		public String getCpfTitular() {
			return cpfTitular;
		}
		public void setCpfTitular(String cpfTitular) {
			this.cpfTitular = cpfTitular;
		}
		public Integer getDiaVencimento() {
			return diaVencimento;
		}
		public void setDiaVencimento(Integer diaVencimento) {
			this.diaVencimento = diaVencimento;
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
		
		
		public ClienteCartaoForm(@NotEmpty String numeroCartao, @NotEmpty String nomeTitular,
				@NotEmpty String cpfTitular, @NotEmpty Integer diaVencimento, @NotEmpty Integer anoVencimento,
				@NotEmpty Bandeira idBandeira) {
			super();
			this.numeroCartao = numeroCartao;
			this.nomeTitular = nomeTitular;
			this.cpfTitular = cpfTitular;
			this.diaVencimento = diaVencimento;
			this.anoVencimento = anoVencimento;
			this.idBandeira = idBandeira;
		}
		
		    public Cartao converter(CartaoRepository cartaoRepository) {
			Cartao cartao = cartaoRepository.findByNumeroCartao(this.getNumeroCartao());
			return cartao;
		
		    
		    

		}
	}
