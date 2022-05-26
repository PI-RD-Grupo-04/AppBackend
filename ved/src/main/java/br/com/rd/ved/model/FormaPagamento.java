package br.com.rd.ved.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "forma_pagamento")
public class FormaPagamento {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_forma_pagamento")
	private Integer id;
	
	private BigDecimal valorTotal;
	
	private String formaPagamento;
	
	private BigDecimal parcelas;
	
}
