package br.com.alugueAgora.dto;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Resource
@AllArgsConstructor
public class ImovelCaracteristicaDTO {

	private Long codigoImovelCaracteristicas;
	private Long valor;
	private Long codigoCaracteristicas;
	private Long codigoImovel;


}
