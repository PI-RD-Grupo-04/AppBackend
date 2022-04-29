package br.com.rd.ved.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

	private Date dataNascimento;

	@NotBlank
	private String email;

	@NotBlank
	private String telefone;

	@NotBlank
	private String senha;

	public ClienteDTO() {

	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getSenha() {
		return senha;
	}

	public ClienteDTO(Cliente obj) {
		nome = obj.getNome();
		sobreNome = obj.getSobreNome();
		nomeSocial = obj.getNomeSocial();
		cpf = obj.getCpf();
		dataNascimento = obj.getDataNascimento();
		email = obj.getEmail();
		telefone = obj.getTelefone();
	}

	public static List<ClienteDTO> converter(List<Cliente> cliente) {

		return cliente.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

}
