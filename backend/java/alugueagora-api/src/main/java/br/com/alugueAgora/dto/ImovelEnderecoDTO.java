package br.com.alugueAgora.dto;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Resource
public class ImovelEnderecoDTO {
	private Long codigoEndereco;
	private String bairro;
	private Long cep;
	private Long tipoEndereco;
	private String cidade;
	private String complemento;
	private String estado;
	private String logradouro;
	private Long numero;
	private String pais;
	private String regiao;
	private String tipoLogradouro;
	private Long codigoImovel;

}
