package br.com.rd.ved.service;

import java.text.ParseException;
import java.util.Scanner;
import org.springframework.stereotype.Service;
import br.com.rd.ved.model.Fornecedor;
import br.com.rd.ved.repository.FornecedorRepository;

@Service
public class FornecedorService {
	private final FornecedorRepository fornecedorRepository;
	private Boolean sistema = true;

	private Integer id;
	private String razaoSocial;
	private String cnpj;
	private String email;

	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
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
		System.out.println("Informe o ID do Fornecedor a ser Deletado");

		id = sc.nextInt();

		fornecedorRepository.deleteById(id);

		System.out.println("Fornecedor deletado com sucesso!");

	}

	private void visualizar() {
		Iterable<Fornecedor> fornecedores = fornecedorRepository.findAll();
		fornecedores.forEach(fornecedor -> System.out.println(fornecedor));
	}

	private void atualizar(Scanner sc) {

		System.out.println("Informe o Id do fornecedor a ser atualizado");
		id = sc.nextInt();

		System.out.println("Informe o nome para o Fornecedor");
		razaoSocial = sc.nextLine();

		System.out.println("Informe o cnpj do Fornecedor");
		cnpj = sc.nextLine();

		System.out.println("Informe o email do Fornecedor");
		email = sc.next();

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(id);
		fornecedor.setCnpj(cnpj);
		fornecedor.setEmail(email);

		fornecedorRepository.save(fornecedor);

		System.out.println("Fornecedor Atualizado com Sucesso");

	}

	private void salvar(Scanner sc) throws ParseException {

		System.out.println("Informe a razão social do fornecedor");
		sc.nextLine();
		razaoSocial = sc.nextLine();

		System.out.println("Informe o cnpj do fornecedor");
		cnpj = sc.nextLine();

		System.out.println("Informe o email do fornecedor");
		email = sc.nextLine();

		Fornecedor fornecedor = new Fornecedor();
		// fornecedor.setId(id);
		fornecedor.setRazaoSocial(razaoSocial);
		fornecedor.setCnpj(cnpj);
		fornecedor.setEmail(email);

		fornecedorRepository.save(fornecedor);

		System.out.println("Fornecedor Salvo com Sucesso");

	}

}
