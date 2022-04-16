package br.com.rd.ved.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="boletos")
public class Boleto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigoBarras;
	
	private Marca marca;

	public Boleto() {
		super();
	}

	public Boleto(Integer id, String codigoBarras, Marca marca) {
		this.id = id;
		this.codigoBarras = codigoBarras;
		this.marca = marca;
	}

	public Boleto(String codigoBarras, Marca marca) {
		this.codigoBarras = codigoBarras;
		this.marca = marca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Boleto [id=" + id + ", codigoBarras=" + codigoBarras + ", marca=" + marca + "]";
	}
	
	
}
