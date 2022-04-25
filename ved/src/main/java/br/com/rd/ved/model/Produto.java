package br.com.rd.ved.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Categoria categoria;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_marca", nullable=false)
	private Marca marca;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_status_produto", nullable=false)
	private StatusProduto statusProduto;
	
	@OneToMany(mappedBy = "produto")
	private List <ItemPedido> itemPedido; 

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
		return categoria;
	}

	public void setIdcategoria(Categoria idcategoria) {
		this.categoria = idcategoria;
	}

	public Marca getIdmarca() {
		return marca;
	}

	public void setIdmarca(Marca idmarca) {
		this.marca = idmarca;
	}

	public StatusProduto getIdstatusProduto() {
		return statusProduto;
	}

	public void setIdstatusProduto(StatusProduto idstatusProduto) {
		this.statusProduto = idstatusProduto;
	}
	
	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nomeProduto=" + nomeProduto + ", preco=" + preco + ", url=" + url
				+ ", descricao=" + descricao + ", peso=" + peso + ", idcategoria=" + categoria + ", idmarca="
				+ marca + ", idstatusProduto=" + statusProduto + "]";
	}


}
