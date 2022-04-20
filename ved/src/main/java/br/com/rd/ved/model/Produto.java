//package br.com.rd.ved.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//
//@Entity
//@Table(name = "produtos")
//public class Produto {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_produto")
//	private Integer id;
//	@Column(name = "nome_produto")
//	@Size(max = 50)
//	private String nomeProduto;
//	@Column(name = "preco")
//	private Double preco;
//	@Column(name = "imagem_url")
//	private String url;
//	@Column(name = "descricao_produto")
//	private String descricao;
//	@Size(max = 100)
//	@Column(name = "peso_kilo")
//	private Double peso;
//	@Column(name = "id_categoria")
//	private Categoria categoria;
//	@Column(name = "id_marca")
//	private Marca marca;
//	@Column(name = "id_status_produto")
//	private StatusProduto statusProduto;
//
//	public Produto() {
//		super();
//	}
//
//	public Produto(Integer id, String nomeProduto, Double preco, String url, String descricao, Double peso,
//			Categoria categoria, Marca marca, StatusProduto statusProduto) {
//		this.id = id;
//		this.nomeProduto = nomeProduto;
//		this.preco = preco;
//		this.url = url;
//		this.descricao = descricao;
//		this.peso = peso;
//		this.categoria = categoria;
//		this.marca = marca;
//		this.statusProduto = statusProduto;
//	}
//
//	public Produto(String nomeProduto, Double preco, String url, String descricao, Double peso, Categoria categoria,
//			Marca marca, StatusProduto statusProduto) {
//		this.nomeProduto = nomeProduto;
//		this.preco = preco;
//		this.url = url;
//		this.descricao = descricao;
//		this.peso = peso;
//		this.categoria = categoria;
//		this.marca = marca;
//		this.statusProduto = statusProduto;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getNomeProduto() {
//		return nomeProduto;
//	}
//
//	public void setNomeProduto(String nomeProduto) {
//		this.nomeProduto = nomeProduto;
//	}
//
//	public Double getPreco() {
//		return preco;
//	}
//
//	public void setPreco(Double preco) {
//		this.preco = preco;
//	}
//
//	public String getUrl() {
//		return url;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}
//
//	public String getDescricao() {
//		return descricao;
//	}
//
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}
//
//	public Double getPeso() {
//		return peso;
//	}
//
//	public void setPeso(Double peso) {
//		this.peso = peso;
//	}
//
//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}
//
//	public Marca getMarca() {
//		return marca;
//	}
//
//	public void setMarca(Marca marca) {
//		this.marca = marca;
//	}
//
//	public StatusProduto getStatusProduto() {
//		return statusProduto;
//	}
//
//	public void setStatusProduto(StatusProduto statusProduto) {
//		this.statusProduto = statusProduto;
//	}
//
//	@Override
//	public String toString() {
//		return "Produto [id=" + id + ", nomeProduto=" + nomeProduto + ", preco=" + preco + ", url=" + url
//				+ ", descricao=" + descricao + ", peso=" + peso + ", categoria=" + categoria + ", marca=" + marca
//				+ ", statusProduto=" + statusProduto + "]";
//	}
//
//}
