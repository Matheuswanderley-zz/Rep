package br.com.alugueAgora.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class AcessoDTO {
	private Long codigoAcesso;
	@NonNull
	private String tipoAcesso;
	//@JsonIgnore
	//@NonNull
	//private List<LoginDTO> logins;
}
