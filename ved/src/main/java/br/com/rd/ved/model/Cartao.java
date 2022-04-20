package br.com.rd.ved.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="cartoes")
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cartao")
	private Integer id;
	@Column(name="numeracao_cartao", nullable = false)
	private String numeroCartao;
	@Column(name="nome_titular", nullable = false)
	private String nomeTitular;
	@Column(name="cpf_titular", nullable = false)
	private String cpfTitular;
	@Column(name="dia_vencimento", nullable = false)
	private Integer diaVencimento;
	@Column(name="ano_vencimento" , nullable = false)
	private Integer anoVencimento;

//	@Column(name="id_bandeira", nullable = false)
	@Transient
	private Bandeira bandeiraId;

	public Cartao() {
		super();
	}

	public Cartao(String numeroCartao, String nomeTitular, String cpfTitular, Integer diaVencimento,
			Integer anoVencimento, Bandeira bandeiraId) {
		this.numeroCartao = numeroCartao;
		this.nomeTitular = nomeTitular;
		this.cpfTitular = cpfTitular;
		this.diaVencimento = diaVencimento;
		this.anoVencimento = anoVencimento;
		this.bandeiraId = bandeiraId;
	}

	public Cartao(Integer id, String numeroCartao, String nomeTitular, String cpfTitular, Integer diaVencimento,
			Integer anoVencimento, Bandeira bandeiraId) {
		this.id = id;
		this.numeroCartao = numeroCartao;
		this.nomeTitular = nomeTitular;
		this.cpfTitular = cpfTitular;
		this.diaVencimento = diaVencimento;
		this.anoVencimento = anoVencimento;
		this.bandeiraId = bandeiraId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Bandeira getBandeiraId() {
		return bandeiraId;
	}

	public void setBandeiraId(Bandeira bandeiraId) {
		this.bandeiraId = bandeiraId;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", numeroCartao=" + numeroCartao + ", nomeTitular=" + nomeTitular + ", cpfTitular="
				+ cpfTitular + ", diaVencimento=" + diaVencimento + ", anoVencimento=" + anoVencimento + ", bandeiraId="
				+ bandeiraId + "]";
	}
	
}