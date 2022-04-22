package br.com.rd.ved.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer id;
	@Column(name = "nome_produto")
	@Size(max = 50)
	private String nomeProduto;
	@Column(name = "preco")
	private Double preco;
	@Column(name = "imagem_url")
	private String url;
	@Column(name = "descricao_produto")
	private String descricao;
	@Size(max = 100)
	@Column(name = "peso_kilo")
	private Double peso;
	
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_categoria", nullable=false)
	private Categoria idcategoria;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_marca", nullable=false)
	private Marca idmarca;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_status_produto", nullable=false)
	private StatusProduto idstatusProduto;

	public Produto() {
		super();
	}

	public Produto(Integer id, String nomeProduto, Double preco, String url, String descricao, Double peso,
			Categoria categoria, Marca marca, StatusProduto statusProduto) {
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.url = url;
		this.descricao = descricao;
		this.peso = peso;
		this.idcategoria = categoria;
		this.idmarca = marca;
		this.idstatusProduto = statusProduto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Categoria getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Categoria idcategoria) {
		this.idcategoria = idcategoria;
	}

	public Marca getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(Marca idmarca) {
		this.idmarca = idmarca;
	}

	public StatusProduto getIdstatusProduto() {
		return idstatusProduto;
	}

	public void setIdstatusProduto(StatusProduto idstatusProduto) {
		this.idstatusProduto = idstatusProduto;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nomeProduto=" + nomeProduto + ", preco=" + preco + ", url=" + url
				+ ", descricao=" + descricao + ", peso=" + peso + ", idcategoria=" + idcategoria + ", idmarca="
				+ idmarca + ", idstatusProduto=" + idstatusProduto + "]";
	}


}
