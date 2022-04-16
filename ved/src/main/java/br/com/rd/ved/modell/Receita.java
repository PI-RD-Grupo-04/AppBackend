package br.com.rd.ved.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bandeiras")
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String ingredientes;
	private String preparo;
	
	public Receita() {
		super();
	}

	public Receita(Integer id, String nome, String ingredientes, String preparo) {
		this.id = id;
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.preparo = preparo;
	}

	public Receita(String nome, String ingredientes, String preparo) {
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.preparo = preparo;
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

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getPreparo() {
		return preparo;
	}

	public void setPreparo(String preparo) {
		this.preparo = preparo;
	}

	@Override
	public String toString() {
		return "Receita [id=" + id + ", nome=" + nome + ", ingredientes=" + ingredientes + ", preparo=" + preparo + "]";
	}
	
	
}
