package br.com.rd.ved.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id_cliente")
	private Integer id;
	@Column(name = "nome_cliente") 
	@Size(max = 50)
	private String nomeCliente;
	@Column(name = "sobrenomeCliente")
	@Size(max = 50)
	private String sobreNome;
	@Column(name = "nome_social")
	@Size(max = 30)
	private String nomeSocial;
	@Column(name = "cpf")
	@Size(max = 16)
	private String cpf;
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	@Column(name = "email")
	@Size(max = 30)
	private String email;
	@Column(name = "telefone")
	@Size(max = 16)
	private String telefone;
	@Column(name = "senha")
	private String senha;
	

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nomeCliente, String sobreNome, String nomeSocial, String cpf, Date dataNascimento,
			String email, String telefone, String senha) {
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.sobreNome = sobreNome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public Cliente(String nomeCliente, String sobreNome, String nomeSocial, String cpf, Date dataNascimento, String email,
			String telefone, String senha) {
		this.nomeCliente = nomeCliente;
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

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nome) {
		this.nomeCliente = nome;
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

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nomeCliente + ", sobreNome=" + sobreNome + ", nomeSocial=" + nomeSocial
				+ ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email=" + email + ", telefone=" + telefone
				+ ", senha=" + senha + "]";
	}

}
