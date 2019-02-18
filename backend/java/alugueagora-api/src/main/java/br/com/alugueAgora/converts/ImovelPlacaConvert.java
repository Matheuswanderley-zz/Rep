package br.com.alugueAgora.converts;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.ImovelPlaca;
import br.com.alugueAgora.dto.ImovelPlacaDTO;

@Component
public class ImovelPlacaConvert {

	public ImovelPlaca convertDTOtoEntity(ImovelPlacaDTO dto) {
		ImovelPlaca imPlaca = new ImovelPlaca();
		imPlaca.setCodigoImovelplaca(dto.getCodigoPlaca());
		imPlaca.setQrcode(dto.getQrCode());
		return imPlaca;
	}

	public ImovelPlacaDTO convertEntityToDTO(ImovelPlaca imovelPlaca) {
		ImovelPlacaDTO dto = new ImovelPlacaDTO();
		dto.setCodigoPlaca(imovelPlaca.getCodigoImovelplaca());
		dto.setQrCode(imovelPlaca.getQrcode());
		return dto;
	}
}
