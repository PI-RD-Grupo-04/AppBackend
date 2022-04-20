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
//@Table(name = "ufs")
//public class Uf {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_uf")
//	private Integer id;
//	@Column(name = "descricao_uf")
//	@Size(max = 50)
//	private String descricao;
//
//	public Uf() {
//		super();
//	}
//
//	public Uf(Integer id, String descricao) {
//		this.id = id;
//		this.descricao = descricao;
//	}
//
//	public Uf(String descricao) {
//		this.descricao = descricao;
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
//	public String getDescricao() {
//		return descricao;
//	}
//
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}
//
//	@Override
//	public String toString() {
//		return "Uf [id=" + id + ", descricao=" + descricao + "]";
//	}
//
//}
