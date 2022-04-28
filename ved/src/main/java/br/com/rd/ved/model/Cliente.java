package br.com.rd.ved.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer id;
	
	@NotBlank
	@Column(name = "nome", nullable = false, length = 3)
	@Size(max = 50)
	private String nome;
	
	@NotBlank
	@Column(name = "sobrenome", nullable = false)
	@Size(max = 50)
	private String sobreNome;
	
	@Column(name = "nome_social")
	@Size(max = 30)
	private String nomeSocial;
	
	@NotBlank
	@Column(name = "cpf", nullable = false)
	@Size(max = 16)
	private String cpf;
	
	@NotBlank
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;
	@NotBlank
	@Column(name = "email", nullable = false)
	@Size(max = 30)
	private String email;
	
	@NotBlank
	@Column(name = "telefone", nullable = false)
	@Size(max = 16)
	private String telefone;
	
	@NotBlank
	@Column(name = "senha", nullable = false)
	private String senha;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;

	
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cliente_cartao", joinColumns = {
	@JoinColumn(name = "id_cliente") }, inverseJoinColumns = { @JoinColumn(name = "id_cartao") })
	private List<Cartao>cartoes;

	
	public Cliente() {
		super();
	}

	public Cliente(String nome, String sobreNome, String nomeSocial, String cpf, Date dataNascimento, String email,
			String telefone, String senha) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", nomeSocial=" + nomeSocial
				+ ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email=" + email + ", telefone=" + telefone
				+ ", senha=" + senha + "]";
	}

}