package br.com.rd.ved.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeProduto;
	private Double preco;
	private String url;
	private String descricao;
	private Double peso;
	
	private Categoria categoria;
	private Marca marca;
	private StatusProduto statusProduto;
	
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
		this.categoria = categoria;
		this.marca = marca;
		this.statusProduto = statusProduto;
	}

	public Produto(String nomeProduto, Double preco, String url, String descricao, Double peso, Categoria categoria,
			Marca marca, StatusProduto statusProduto) {
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.url = url;
		this.descricao = descricao;
		this.peso = peso;
		this.categoria = categoria;
		this.marca = marca;
		this.statusProduto = statusProduto;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public StatusProduto getStatusProduto() {
		return statusProduto;
	}

	public void setStatusProduto(StatusProduto statusProduto) {
		this.statusProduto = statusProduto;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nomeProduto=" + nomeProduto + ", preco=" + preco + ", url=" + url
				+ ", descricao=" + descricao + ", peso=" + peso + ", categoria=" + categoria + ", marca=" + marca
				+ ", statusProduto=" + statusProduto + "]";
	}
	
	
	
}
