package br.com.rd.ved.dto;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import br.com.rd.ved.model.Cliente;


public class ClienteDTO {
	@NotBlank
	private Integer id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobreNome;
	
	@NotBlank
	private String nomeSocial;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private Date dataNascimento;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String senha;
	
	
		

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


	


	public ClienteDTO() {
	
	}
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		sobreNome = obj.getSobreNome();
		nomeSocial = obj.getNomeSocial();
		cpf = obj.getCpf();
		dataNascimento = obj.getDataNascimento();
		email = obj.getEmail();
		telefone = obj.getTelefone();
		senha = obj.getSenha();
}
}
