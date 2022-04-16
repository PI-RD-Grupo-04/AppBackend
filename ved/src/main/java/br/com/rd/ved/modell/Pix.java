package br.com.rd.ved.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pixes")
public class Pix {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigoPix;
	
	public Pix() {
		super();
	}

	public Pix(Integer id, String codigoPix) {
		this.id = id;
		this.codigoPix = codigoPix;
	}

	public Pix(String codigoPix) {
		this.codigoPix = codigoPix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoPix() {
		return codigoPix;
	}

	public void setCodigoPix(String codigoPix) {
		this.codigoPix = codigoPix;
	}

	@Override
	public String toString() {
		return "Pix [id=" + id + ", codigoPix=" + codigoPix + "]";
	}
	
	
	
}