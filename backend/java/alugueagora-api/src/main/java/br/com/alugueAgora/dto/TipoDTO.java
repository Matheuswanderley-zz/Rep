package br.com.alugueAgora.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class TipoDTO {

	private String version;
	private String transactionId;
	
	@NonNull
	private Long codigoTipo;
	@NonNull
	private String descricaoTipo;

}
