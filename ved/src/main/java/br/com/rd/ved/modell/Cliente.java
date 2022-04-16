package br.com.rd.ved.modell;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobreNome;
	private String nomeSocial;
	private String cpf;
	private Date dataNascimento;
	private String email;
	private String telefone;
	private String senha;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String sobreNome, String nomeSocial, String cpf, Date dataNascimento,
			String email, String telefone, String senha) {
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public Cliente(String nome, String sobreNome, String nomeSocial, String cpf, Date dataNascimento,
			String email, String telefone, String senha) {
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

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", nomeSocial=" + nomeSocial
				+ ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email=" + email + ", telefone=" + telefone
				+ ", senha=" + senha + "]";
	}
	
	
	
}
