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
//@Table(name="fornecedores")
//public class Fornecedor {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id_fornecedor")
//	private Integer id;
//	@Column(name="razao_social")
//	@Size(max = 50)
//	private String razaoSocial;
//	@Column(name="cnpj")
//	@Size(max = 20)
//	private String cnpj;
//	@Column(name="email")
//	@Size(max = 30)
//	private String email;
//	
//	public Fornecedor() {
//		super();
//	}
//
//	public Fornecedor(Integer id, String razaoSocial, String cnpj, String email) {
//		this.id = id;
//		this.razaoSocial = razaoSocial;
//		this.cnpj = cnpj;
//		this.email = email;
//	}
//
//	public Fornecedor(String razaoSocial, String cnpj, String email) {
//		this.razaoSocial = razaoSocial;
//		this.cnpj = cnpj;
//		this.email = email;
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
//	public String getRazaoSocial() {
//		return razaoSocial;
//	}
//
//	public void setRazaoSocial(String razaoSocial) {
//		this.razaoSocial = razaoSocial;
//	}
//
//	public String getCnpj() {
//		return cnpj;
//	}
//
//	public void setCnpj(String cnpj) {
//		this.cnpj = cnpj;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	@Override
//	public String toString() {
//		return "Fornecedor [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", email=" + email + "]";
//	}
//	
//	
//	
//	
//}
