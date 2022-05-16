package br.com.rd.ved.formdto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.rd.ved.dto.PixDTO;
import br.com.rd.ved.model.Pix;

public class PixForm {

	private Integer id;

	@NotNull
	@NotEmpty
	private String codigoPix;
	@NotNull
	@NotEmpty
	private String QRcodePix;

	public Integer getId() {
		return id;
	}

	public String getCodigoPix() {
		return codigoPix;
	}

	public String getQRcodePix() {
		return QRcodePix;
	}

	public void setQRcodePix(String qRcodePix) {
		this.codigoPix = qRcodePix;
	}

	public void setCodigoPix(String codigoPix) {
		this.codigoPix = codigoPix;
	}

	public String getQRcode() {
		return QRcodePix;
	}

	public PixForm(Pix pix) {
		this.id = pix.getId();
		this.codigoPix = pix.getCodigoPix();
		this.QRcodePix = pix.getCodigoPix();
	}

	public static List<PixDTO> converter(List<Pix> pixs) {
		return pixs.stream().map(PixDTO::new).collect(Collectors.toList());
	}

}
