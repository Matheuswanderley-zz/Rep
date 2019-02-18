package br.com.alugueAgora.dto;

import lombok.Data;

@Data
public class ClienteDTO {
	private Long codigoCliente;
	private Long avaliacao;
	private String bairro;
	private Long cep;
	private String cidade;
	private String complemento;
	private String email;
	private String estado;
	private String logradouro;
	private String nomeCliente;
	private Long numero;
	private String pais;
	private String regiao;
	private String sobrenomeCliente;
	private Long telefone;
	private String tipoLogradouro;
	private Long codigoImovel;
	private Long codigoClienteLogin;
}
