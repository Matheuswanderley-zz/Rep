package br.com.alugueAgora.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;



/**
 * The persistent class for the IMOVEL_ENDERECO database table.
 * 
 */
@Entity
@Getter @Setter
@RequiredArgsConstructor 
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
@Table(name="IMOVEL_ENDERECO")
public class ImovelEndereco implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IMOVEL_ENDERECO_SEQ", sequenceName="IMOVEL_ENDERECO_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="IMOVEL_ENDERECO_SEQ")
	@Column(name="CODIGO_IMOVEL_ENDERECO")
	private Long codigoEndereco;
	@NonNull @Column(name="BAIRRO")
	private String bairro;
	@NonNull @Column(name="CEP")
	private Long cep;
	@NonNull @Column(name="TIPO_ENDERECO")
	private Long tipoEndereco;
	@NonNull @Column(name="CIDADE")
	private String cidade;
	@NonNull @Column(name="COMPLEMENTO")
	private String complemento;
	@NonNull @Column(name="ESTADO")
	private String estado;
	@NonNull @Column(name="LOGRADOURO")
	private String logradouro;
	@NonNull @Column(name="NUMERO")
	private Long numero;
	@NonNull @Column(name="PAIS")
	private String pais;
	@NonNull @Column(name="REGIAO")
	private String regiao;
	@NonNull @Column(name="TIPO_LOGRADOURO")
	private String tipologradouro;
	@ManyToOne(optional = false) @NonNull
	@JoinColumn(name="CODIGO_IMOVEL")
	private Imovel imovel;
	
}