package br.com.alugueAgora.dto;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.ImovelTipo;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Component
public class ImovelTipoDTO {
	private Long codigoImovelTipo;
	private Long codigoTipo;

}
