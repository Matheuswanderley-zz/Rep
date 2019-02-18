package br.com.alugueAgora.dto;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.ImovelNegocio;
import lombok.Data;

@Data
@Component
public class ImovelNegocioDTO {
	private Long codigoImovelNegocio;
	private Long negocioCodigoNegocio;

}
