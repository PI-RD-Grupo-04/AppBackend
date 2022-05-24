package br.com.rd.ved.formdto;

import br.com.rd.ved.model.Pix;

public class PixForm {
	private Integer id;
	private String QRcode;
	private String codigoPix;

	public Integer getId() {
		return id;
	}

	public PixForm(Integer id, String codigoPix, String qRcodePix) {
		this.id = id;
		this.codigoPix = codigoPix;
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

//	public Pix converter() {
//		return new Pix(codigoPix, QRcode);
//	}
}
