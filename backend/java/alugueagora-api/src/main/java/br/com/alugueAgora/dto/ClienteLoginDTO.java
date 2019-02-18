package br.com.alugueAgora.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ClienteLoginDTO {

	ClienteDTO cliente;
	LoginDTO login;
	AcessoDTO acesso;
}
