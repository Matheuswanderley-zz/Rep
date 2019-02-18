package br.com.alugueAgora.dto;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Resource
@AllArgsConstructor
public class ImovelFotoDTO {
	private Long codigoFoto;
	private String foto;
	private Long codigoImovel;

}
