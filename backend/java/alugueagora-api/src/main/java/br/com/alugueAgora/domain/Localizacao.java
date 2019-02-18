package br.com.alugueAgora.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="LOCALIZACAO")
public class Localizacao implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Id
	@SequenceGenerator(name="LOCALIZACAO_SEQ", sequenceName="LOCALIZACAO_SEQ")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="LOCALIZACAO_SEQ")
	@Column(name="CODIGO_LOCALIZACAO")
	private Long codigoLocalizacao;
	
	@Column(name="TIPO_LOGRADOURO")
	private String tipoLogradouro;
	
	@Column(name="NOME_LOGRADOURO")
	private String nomeLogradouro;
	
	@Column(name="NOME_BAIRRO")
	private String nomeBairro;
	
	@Column(name="NOME_LOCALIDADE")
	private String nomeLocalidade;
	
	@Column(name="NOME_ESTADO")
	private String nomeEstado;
	
	@Column(name="SIGLA_UNIDADE_FEDERATIVA")
	private String siglaUF;
	
	@Column(name="NUMERO_CEP")
	private String cep;
	
	@Column(name="DESCRICAO_LOCALIZACAO")
	private String descricaoLocalizacao;
			
}
