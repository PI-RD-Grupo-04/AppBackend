<<<<<<< HEAD
package br.com.rd.ved.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pix")
public class Pix {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pix")
	private Integer id;
	@Column(name = "codigo_pix")
	private String codigoPix;

	@Column(name = "QR_code")
	private String QRcode;

	@OneToMany(mappedBy = "pix", fetch = FetchType.LAZY)
	private List<TipoPagamento> tipoPagamento;

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

	public void setQRcode(String qRcode) {
		QRcode = qRcode;
	}

	@Override
	public String toString() {
		return "Pix [id=" + id + ", codigoPix=" + codigoPix + ", QRcode=" + QRcode + ", tipoPagamento=" + tipoPagamento
				+ "]";
	}

}
=======
package br.com.rd.ved.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pix")
public class Pix {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pix")
	private Integer id;
	
	@Column(name="codigo_pix")
	private String codigoPix;
	
	@Column(name="img")
	private String img;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pix")
	private List <HistoricoPagamento> HistoricoPagamento; 
		
	public Pix() {
		super();
	}

	public Pix(Integer id, String codigoPix) {
		this.id = id;
		this.codigoPix = codigoPix;
	}

	public Pix(String codigoPix, String img) {
		this.codigoPix = codigoPix;
		this.img = img;
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
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<HistoricoPagamento> getHistoricoPagamento() {
		return HistoricoPagamento;
	}

	public void setHistoricoPagamento(List<HistoricoPagamento> historicoPagamento) {
		HistoricoPagamento = historicoPagamento;
	}
	

}
>>>>>>> 6b06640e8620ce85588d71bf9f6a50d2fcb6f281
