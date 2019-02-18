package br.com.alugueAgora.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PropostaDTO {

	private Long codigoProposta;

	private String cidade;

	private String bairro;

	private Long quantidadeBanheiros;

	private Long quantidadeDormitorios;

	private Long quantidadeSuites;

	private Long quantidadeGaragem;

	private Long valorProposta;

	private String observacao;

	private ImovelDTO imovelPermutaDto;

	private TipoDTO tipoDto;

}
