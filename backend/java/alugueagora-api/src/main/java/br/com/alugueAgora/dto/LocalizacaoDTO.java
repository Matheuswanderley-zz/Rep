package br.com.alugueAgora.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class LocalizacaoDTO {

	private Long codigoLocalizacao;
	private String tipoLogradouro;
	private String nomeLogradouro;
	private String nomeBairro;
	private String nomeLocalidade;
	private String nomeEstado;
	private String siglaUF;
	private String cep;
	private String descricaoLocalizacao;
	
}
