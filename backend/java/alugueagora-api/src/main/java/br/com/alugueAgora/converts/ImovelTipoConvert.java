package br.com.alugueAgora.converts;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.ImovelTipo;
import br.com.alugueAgora.dto.ImovelTipoDTO;

@Component
public class ImovelTipoConvert {

	public ImovelTipo convertDTOtoEntity(ImovelTipoDTO imTipoDTO) {
		ImovelTipo imTipo = new ImovelTipo();
		imTipo.setCodigoImovelTipo(imTipoDTO.getCodigoImovelTipo());
		imTipo.setCodigoTipo(imTipoDTO.getCodigoTipo());
		return imTipo;
	}

	public ImovelTipoDTO convertEntityToDTO(ImovelTipo imovelTipo) {
		ImovelTipoDTO dto = new ImovelTipoDTO();
		dto.setCodigoImovelTipo(imovelTipo.getCodigoImovelTipo());
		dto.setCodigoTipo(imovelTipo.getCodigoTipo());
		return dto;
	}
}
