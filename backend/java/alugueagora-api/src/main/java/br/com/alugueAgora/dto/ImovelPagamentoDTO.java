package br.com.alugueAgora.dto;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Resource
@AllArgsConstructor
public class ImovelPagamentoDTO {
	private Long codigoPagamento;
	private Date dataPagamento;
	private Long statusPagamento;
	private Long valorPagamento;
	private Long codigoImovel;

}
