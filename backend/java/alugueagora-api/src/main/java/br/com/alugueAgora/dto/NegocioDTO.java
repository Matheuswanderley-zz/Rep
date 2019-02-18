package br.com.alugueAgora.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class NegocioDTO {
	
	private String version;
	private String transactionId;
	
	@NonNull
	private Long codigoNegocio;
	@NonNull
	private String descricaoNegocio;
}
