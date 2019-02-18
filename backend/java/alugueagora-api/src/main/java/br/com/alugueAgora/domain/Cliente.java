package br.com.alugueAgora.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CLIENTE database table.
 * 
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CLIENTE")
public class Cliente implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLIENTE_SEQ", sequenceName="CLIENTE_SEQ",allocationSize=1,initialValue=0)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CLIENTE_SEQ")
	@Column(name="CODIGO_CLIENTE")
	private Long codigoCliente;
	@Column(name="AVALIACAO")
	private Long avaliacao;
	@Column(name="BAIRRO")
	private String bairro;
	@Column(name="CEP")
	private Long cep;
	@Column(name="CIDADE")
	private String cidade;
	@Column(name="COMPLEMENTO")
	private String complemento;
	@Column(name="EMAIL")
	private String email;
	@Column(name="ESTADO")
	private String estado;
	@Column(name="LOGRADOURO")
	private String logradouro;
	@Column(name="NOME")
	private String nomeCliente;
	@Column(name="NUMERO")
	private Long numero;
	@Column(name="PAIS")
	private String pais;
	@Column(name="REGIAO")
	private String regiao;
	@Column(name="SOBRENOME")
	private String sobrenomeCliente;
	@Column(name="TELEFONE")
	private Long telefone;
	@Column(name="TIPO_LOGRADOURO")
	private String tipoLogradouro;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="IMOVEL_CODIGO_IMOVEL")
	@JsonIgnore
	private List<Imovel> imoveis;

/*	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="CLILOG_CODIGO_CLILOG")
	@JsonIgnore*/
	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumns({
	        @JoinColumn(
	            name = "ACESSO_CODIGO_ACESSO",
	            referencedColumnName = "ACESSO_CODIGO_ACESSO"),
	        @JoinColumn(
	            name = "LOGIN_CODIGO_LOGIN",
	            referencedColumnName = "LOGIN_CODIGO_LOGIN")
	    })
	private ClienteLogin clienteLogin;

}