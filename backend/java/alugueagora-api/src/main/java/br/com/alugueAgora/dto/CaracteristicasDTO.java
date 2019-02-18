package br.com.alugueAgora.dto;

import javax.annotation.Resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Resource
@AllArgsConstructor
@RequiredArgsConstructor
public class CaracteristicasDTO {
	private String version;
	private String transactionId;
	
	@NonNull
	private Long codigoCaracteristicas;
	@NonNull 
	private String descricaoCaracterisicas;
}
