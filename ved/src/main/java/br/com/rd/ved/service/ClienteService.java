package br.com.rd.ved.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.ved.model.Cliente;
import br.com.rd.ved.repository.ClienteRepository;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	private Boolean sistema = true;

	private Integer id;
	private String nomeCliente;
	private String sobreNomeCliente;
	private String nomeSocial;
	private String cpf;
	private Date dataNascimento;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private String email;
	private String telefone;
	private String senha;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public void iniciar(Scanner sc) throws ParseException {
		int acao;
		while (sistema) {
			System.out.println("Qual a ação que será realizada em Cliente");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			acao = sc.nextInt();

			switch (acao) {
			case 1:
				salvar(sc);
				break;
			case 2:
				atualizar(sc);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(sc);
				break;
			default:
				sistema = false;
				break;
			}
		}
	}

	private void deletar(Scanner sc) {
		int id;
		System.out.println("Informe o ID do Cliente a ser Deletado");

		id = sc.nextInt();

		clienteRepository.deleteById(id);

		System.out.println("Cliente deletado com sucesso");

	}

	private void visualizar() {
		Iterable<Cliente> clientes = clienteRepository.findAll();
		clientes.forEach(cliente -> System.out.println(cliente));
	}

	private void atualizar(Scanner sc) {

		System.out.println("Informe o Id do registro a ser atualizado");
		id = sc.nextInt();

		System.out.println("Informe o nome para o Cliente");
		nomeCliente = sc.nextLine();

		System.out.println("Informe o sobre Nome para o Cliente");
		sobreNomeCliente = sc.nextLine();

		System.out.println("Informe o nome Social para o Cliente");
		nomeSocial = sc.nextLine();

		System.out.println("Informe a nova email para o Cliente");
		email = sc.next();

		System.out.println("Informe a nova telefone para o Cliente");
		telefone = sc.next();

		System.out.println("Informe a nova senha para o Cliente");
		senha = sc.next();

		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNomeCliente(nomeCliente);
		cliente.setSobreNome(sobreNomeCliente);
		cliente.setNomeSocial(nomeSocial);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		cliente.setSenha(senha);

		clienteRepository.save(cliente);

		System.out.println("Cliente Atualizado com Sucesso");

	}

	private void salvar(Scanner sc) throws ParseException {
		
	
		System.out.println("Informe o nome para o Cliente");
		sc.nextLine();
		nomeCliente = sc.nextLine();
		

		System.out.println("Informe o sobre Nome para o Cliente");
		sobreNomeCliente = sc.nextLine();

		System.out.println("Informe o nome Social para o Cliente");
		nomeSocial = sc.nextLine();

		System.out.println("Informe o cpf do Cliente");
		cpf = sc.nextLine();

		System.out.println("Informe a data de nascimento do Cliente (--/--/----)");
		String dt = sc.nextLine();
		dataNascimento = formato.parse(dt);

		System.out.println("Informe seu email para o Cliente");
		email = sc.nextLine();

		System.out.println("Informe o telefone do Cliente");
		telefone = sc.nextLine();

		System.out.println("Informe uma senha para o Cliente");
		senha = sc.nextLine();

		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNomeCliente(nomeCliente);
		cliente.setSobreNome(sobreNomeCliente);
		cliente.setNomeSocial(nomeSocial);
		cliente.setDataNascimento(dataNascimento);
		cliente.setCpf(cpf);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		cliente.setSenha(senha);

		clienteRepository.save(cliente);

		System.out.println("Cliente Salvo com Sucesso");

	}

}
