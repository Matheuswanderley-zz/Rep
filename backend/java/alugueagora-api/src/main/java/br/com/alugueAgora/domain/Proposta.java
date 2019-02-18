package br.com.alugueAgora.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the IMOVEL database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROPOSTA")
public class Proposta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PROPOSTA_SEQ", sequenceName = "PROPOSTA_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PROPOSTA_SEQ")
	@Column(name = "CODIGO_PROPOSTA")
	private Long codigoProposta;

	@ManyToOne
	@JoinColumn(name = "IMOVEL_TIPO")
	private Tipo tipo;

	@Column(name = "CIDADE")
	private String cidade;

	@Column(name = "BAIRRO")
	private String bairro;
	
	@Column(name = "QUANTIDADE_BANHEIROS")
	private Long quantidadeBanheiros;
	
	@Column(name = "QUANTIDADE_DORMITORIOS")
	private Long quantidadeDormitorios;
	
	@Column(name = "QUANTIDADE_SUITES")
	private Long quantidadeSuites;
	
	@Column(name = "QUANTIDADE_GARAGEM")
	private Long quantidadeGaragem;
	
	@Column(name = "VALOR_PROPOSTA")
	private Long valorProposta;
	
	@Column(name = "OBSERVACAO")
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "IMOVEL_PERMUTA")
	private Imovel imovelPermuta;

}