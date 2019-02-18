package br.com.alugueAgora.dto;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Resource
@AllArgsConstructor
public class ImovelAreaComumDTO {
	private Long codigoImovelAreaComum;
	private Long valor;
	private Long codigoAreaComum;
	private Long codigoImovel;

}
