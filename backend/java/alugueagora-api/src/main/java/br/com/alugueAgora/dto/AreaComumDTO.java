package br.com.alugueAgora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class AreaComumDTO {
	//private String version;
	//private String transactionId;
	
	private Long codigoAreaComum;
	@NonNull
	private String descricaoAreaComum;
}
