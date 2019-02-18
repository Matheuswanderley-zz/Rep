package br.com.alugueAgora.converts;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.ImovelNegocio;
import br.com.alugueAgora.dto.ImovelNegocioDTO;

@Component
public class ImovelNegocioConvert {

	public ImovelNegocio convertDTOtoEntity(ImovelNegocioDTO dto) {
		ImovelNegocio imNegocio = new ImovelNegocio();
		imNegocio.setCodigoImovelNegocio(dto.getCodigoImovelNegocio());
		imNegocio.setCodigoNegocio(dto.getNegocioCodigoNegocio());
		return imNegocio;
	}

	public ImovelNegocioDTO convertEntityToDTO(ImovelNegocio imovelNegocio) {
		ImovelNegocioDTO dto = new ImovelNegocioDTO();
		dto.setCodigoImovelNegocio(imovelNegocio.getCodigoImovelNegocio());
		dto.setNegocioCodigoNegocio(imovelNegocio.getCodigoNegocio());
		return dto;
	}

}
