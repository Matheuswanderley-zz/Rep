package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.ImovelCaracteristica;
import br.com.alugueAgora.dto.ImovelCaracteristicaDTO;

@Component
public class ImovelCaracteristicaConvert {

	public List<ImovelCaracteristica> convertDTOToEntity(List<ImovelCaracteristicaDTO> dto, Imovel imovel,String dominio) {

		List<ImovelCaracteristica> caracteristicas = new ArrayList<>();
		
		for(ImovelCaracteristicaDTO carac : dto) {
			if("UPDATE".equalsIgnoreCase(dominio)) {
				caracteristicas.add(new ImovelCaracteristica( carac.getCodigoImovelCaracteristicas(),
						carac.getValor(),
						carac.getCodigoCaracteristicas(),
						imovel));
			}else {
				caracteristicas.add(new ImovelCaracteristica(	
						carac.getValor(),
						carac.getCodigoCaracteristicas(),
						imovel));
			}
		}
		return caracteristicas;
	}

	public List<ImovelCaracteristicaDTO> convertEntityToDTO(List<ImovelCaracteristica> caracteristicas) {

		List<ImovelCaracteristicaDTO> listaCaracteristicas = new ArrayList<>();
		
		for(ImovelCaracteristica carac : caracteristicas) {
			listaCaracteristicas.add(new ImovelCaracteristicaDTO(	carac.getCodigoimovelcaracteristicas(),
																	carac.getValor(),
																	carac.getCaracteristica(),
																	carac.getImovel().getCodigoImovel()));
		}
		return listaCaracteristicas;
	}
}
