package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.ImovelNegocio;
import br.com.alugueAgora.domain.ImovelPlaca;
import br.com.alugueAgora.domain.ImovelTipo;
import br.com.alugueAgora.dto.ImovelDTO;
import br.com.alugueAgora.dto.ImovelNegocioDTO;
import br.com.alugueAgora.dto.ImovelTipoDTO;
import br.com.alugueAgora.dto.TipoDTO;
import scala.annotation.meta.setter;

@Component
public class ImovelConvert {

	@Autowired
	ImovelNegocioDTO imovelNegocioDTO;
	@Autowired
	ImovelTipoDTO imovelTipoDTO;
	
	@Autowired
	ImovelNegocioConvert imovelNegocioConvert;
	@Autowired
	ImovelTipoConvert imovelTipoConvert;
	@Autowired
	ImovelPlacaConvert imovelPlacaConvert;
	
	@Autowired
	ImovelPagamentoConvert imovelPagamentoConvert;
	@Autowired
	ImovelEnderecoConvert imovelEnderecoConvert;
	@Autowired
	ImovelAreaComumConvert imovelAreComumConvert;
	@Autowired
	ImovelCaracteristicaConvert imovelCaracteristicasConvert;
	@Autowired
	ImovelFotoConvert imovelFotosConvert;

	
	/**
	 * Metodo para converter um DTO em uma Entidade, no dominio deve ser passado
	 * update ou save para que haja uma validação dos dados que serao setados na
	 * entidade para serem persistidos na base.
	 * 
	 * @param dto
	 * @param dominio
	 * @return Imovel
	 */
	public Imovel convertDTOtoEntity(ImovelDTO dto, String dominio) {
		Imovel imovel = new Imovel();
		imovel.setCodigoImovel(dto.getCodigoImovel());
		imovel.setAnuncio(dto.getAnuncio());
		imovel.setAnuncioDestaque(dto.getAnuncioDestaque());
		imovel.setAreaImovel(dto.getAreaImovel());
		imovel.setCelular(dto.getCelular());
		imovel.setDataRegistro(dto.getDataRegistro());
		imovel.setDescricaoImovel(dto.getDescricaoImovel());
		imovel.setTituloImovel(dto.getTituloImovel());
		imovel.setDisponibilidade(dto.getDisponibilidade());
		imovel.setEmail(dto.getEmail());
		imovel.setEnvioPlaca(dto.getEnvioPlaca());

		if("SAVE".equalsIgnoreCase(dominio)) {
			imovel.setImovelNegocio(new ImovelNegocio(dto.getImovelNegocio().getNegocioCodigoNegocio()));
			imovel.setImovelTipo(new ImovelTipo(dto.getImovelTipo().getCodigoTipo()));
			imovel.setImovelPlaca(new ImovelPlaca(dto.getImovelPlaca().getQrCode()));
		}else {
			imovel.setImovelNegocio(imovelNegocioConvert.convertDTOtoEntity(dto.getImovelNegocio()));
			imovel.setImovelTipo(imovelTipoConvert.convertDTOtoEntity(dto.getImovelTipo()));
			imovel.setImovelPlaca(imovelPlacaConvert.convertDTOtoEntity(dto.getImovelPlaca()));
		}

		imovel.setOportunidade(dto.getOportunidade());
		imovel.setPreferido(dto.getPreferido());
		imovel.setQuantidadeBanheiros(dto.getQuantidadeBanheiros());
		imovel.setQuantidadeDormitorios(dto.getQuantidadeDormitorios());
		imovel.setQuantidadeGaragem(dto.getQuantidadeGaragem());
		imovel.setQuantidadeSuites(dto.getQuantidadeSuites());
		imovel.setTelefone1(dto.getTelefone1());
		imovel.setTelefone2(dto.getTelefone2());
		imovel.setValorCondominio(dto.getValorCondominio());
		imovel.setValorImovel(dto.getValorImovel());
		imovel.setValorIptu(dto.getValorIptu());
		imovel.setValorPacote(dto.getValorPacote());

		return imovel;
	}

	public ImovelDTO convertEntityToDTO(Imovel imovel) {
		ImovelDTO dto = new ImovelDTO();
		dto.setCodigoImovel(imovel.getCodigoImovel());
		dto.setAnuncio(imovel.getAnuncio());
		dto.setAnuncioDestaque(imovel.getAnuncioDestaque());
		dto.setAreaImovel(imovel.getAreaImovel());
		dto.setCelular(imovel.getCelular());
		dto.setDataRegistro(imovel.getDataRegistro());
		dto.setDescricaoImovel(imovel.getDescricaoImovel());
		dto.setTituloImovel(imovel.getTituloImovel());
		dto.setDisponibilidade(imovel.getDisponibilidade());
		dto.setEmail(imovel.getEmail());
		dto.setEnvioPlaca(imovel.getEnvioPlaca());

		dto.setImovelNegocio(imovelNegocioConvert.convertEntityToDTO(imovel.getImovelNegocio()));
		dto.setImovelTipo(imovelTipoConvert.convertEntityToDTO(imovel.getImovelTipo()));
		dto.setImovelPlaca(imovelPlacaConvert.convertEntityToDTO(imovel.getImovelPlaca()));

		dto.setImovelAreaComum(imovelAreComumConvert.convertEntityToDTO(imovel.getImovelAreaComum()));
		dto.setImovelCaracteristicas(imovelCaracteristicasConvert.convertEntityToDTO(imovel.getImovelCaracteristica()));
		dto.setImovelEnderecos(imovelEnderecoConvert.convertEntityToDTO(imovel.getImovelEndereco()));
		dto.setImovelFotos(imovelFotosConvert.convertEntityToDTO(imovel.getImovelFoto()));
		dto.setImovelPagamentos(imovelPagamentoConvert.convertEntityToDTO(imovel.getImovelPagamento()));

		dto.setOportunidade(imovel.getOportunidade());
		dto.setPreferido(imovel.getPreferido());
		dto.setQuantidadeBanheiros(imovel.getQuantidadeBanheiros());
		dto.setQuantidadeDormitorios(imovel.getQuantidadeDormitorios());
		dto.setQuantidadeGaragem(imovel.getQuantidadeGaragem());
		dto.setQuantidadeSuites(imovel.getQuantidadeSuites());
		dto.setTelefone1(imovel.getTelefone1());
		dto.setTelefone2(imovel.getTelefone2());
		dto.setValorCondominio(imovel.getValorCondominio());
		dto.setValorImovel(imovel.getValorImovel());
		dto.setValorIptu(imovel.getValorIptu());
		dto.setValorPacote(imovel.getValorPacote());

		return dto;
	}

	public List<Imovel> convertListaDTOtoListaEntity(List<ImovelDTO> dto, String dominio) {
		List<Imovel> lista = new ArrayList<>();
		for(ImovelDTO imDto : dto) {
			lista.add(convertDTOtoEntity(imDto, dominio));	
		}
		return lista; 
	}
	
	public List<ImovelDTO> convertListaEntityToListaDTO(List<Imovel> imoveis) {
		List<ImovelDTO> lista = new ArrayList<>();
		for(Imovel im : imoveis) {
			lista.add(convertEntityToDTO(im));	
		}
		return lista; 
	}
}
