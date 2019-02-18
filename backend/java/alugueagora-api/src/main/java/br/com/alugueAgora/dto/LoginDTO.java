package br.com.alugueAgora.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
	private Long codigoLogin;
	private String username;
	private String password;
	private String dataLogin;
	private String dataAcesso;
	//@JsonIgnore
	//private List<AcessoDTO> acessos;
}
