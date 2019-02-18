package br.com.alugueAgora.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ImovelPlacaDTO {
	private Long codigoPlaca;
	private String qrCode;
}
