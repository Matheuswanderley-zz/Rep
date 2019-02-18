package br.com.alugueAgora.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alugueAgora.converts.ImovelAreaComumConvert;
import br.com.alugueAgora.converts.ImovelCaracteristicaConvert;
import br.com.alugueAgora.converts.ImovelConvert;
import br.com.alugueAgora.converts.ImovelEnderecoConvert;
import br.com.alugueAgora.converts.ImovelFotoConvert;
import br.com.alugueAgora.converts.ImovelNegocioConvert;
import br.com.alugueAgora.converts.ImovelPagamentoConvert;
import br.com.alugueAgora.converts.ImovelPlacaConvert;
import br.com.alugueAgora.converts.ImovelTipoConvert;
import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.ImovelNegocio;
import br.com.alugueAgora.domain.ImovelTipo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class ImovelDTO {

	private Long codigoImovel;
	private Long anuncio;
	private Long anuncioDestaque;
	private Long areaImovel;
	private Long celular;
	private Date dataRegistro;
	private String descricaoImovel;
	private String tituloImovel;
	private Long disponibilidade;
	private String email;
	private Long envioPlaca;
	private Long oportunidade;
	private Long preferido;
	private Long quantidadeBanheiros;
	private Long quantidadeDormitorios;
	private Long quantidadeGaragem;
	private Long quantidadeSuites;
	private Long telefone1;
	private Long telefone2;
	private Long valorCondominio;
	private Long valorImovel;
	private Long valorIptu;
	private Long valorPacote;
	private Long codigoCliente;

	private ImovelNegocioDTO imovelNegocio = new ImovelNegocioDTO();
	private ImovelTipoDTO imovelTipo = new ImovelTipoDTO();
	private ImovelPlacaDTO imovelPlaca = new ImovelPlacaDTO();
	private List<ImovelAreaComumDTO> imovelAreaComum = new ArrayList<ImovelAreaComumDTO>();
	private List<ImovelCaracteristicaDTO> imovelCaracteristicas = new ArrayList<ImovelCaracteristicaDTO>();
	private List<ImovelEnderecoDTO> imovelEnderecos = new ArrayList<ImovelEnderecoDTO>();
	private List<ImovelFotoDTO> imovelFotos = new ArrayList<ImovelFotoDTO>();
	private List<ImovelPagamentoDTO> imovelPagamentos = new ArrayList<ImovelPagamentoDTO>();

}
