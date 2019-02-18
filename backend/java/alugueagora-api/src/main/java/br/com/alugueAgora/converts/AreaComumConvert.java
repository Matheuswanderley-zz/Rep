package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.AreaComum;
import br.com.alugueAgora.dto.AreaComumDTO;

@Component
public class AreaComumConvert {

	public List<AreaComum> convertDTOToEntity(List<AreaComumDTO> dto, AreaComum imovel, String dominio) {

		List<AreaComum> AreaComumConvert = new ArrayList<>();

		for (AreaComumDTO carac : dto) {
			if ("UPDATE".equalsIgnoreCase(dominio)) {
				AreaComumConvert.add(new AreaComum(carac.getCodigoAreaComum(), carac.getDescricaoAreaComum()));
			} else {
				AreaComumConvert.add(new AreaComum(carac.getDescricaoAreaComum()));
			}
		}
		return AreaComumConvert;
	}

	public List<AreaComumDTO> convertEntityToDTO(List<AreaComum> AreaComums) {

		List<AreaComumDTO> listaAreaComums = new ArrayList<>();

		for (AreaComum carac : AreaComums) {
			listaAreaComums.add(new AreaComumDTO(carac.getCodigoAreaComum(), carac.getDescricaoAreaComum()));
		}
		return listaAreaComums;
	}

	public AreaComumDTO convertEntityToDTO(AreaComum carac) {
		AreaComumDTO dto = new AreaComumDTO(carac.getCodigoAreaComum(), carac.getDescricaoAreaComum());
		return dto;
	}

	public AreaComum convertDTOtoEntity(AreaComumDTO dto, String dominio) {
		AreaComum acomum = new AreaComum();
		if ("UPDATE".equalsIgnoreCase(dominio)) {
			acomum = new AreaComum(dto.getCodigoAreaComum(), dto.getDescricaoAreaComum());
		} else {
			acomum = new AreaComum(dto.getDescricaoAreaComum());
		}
		return acomum;
	}
}