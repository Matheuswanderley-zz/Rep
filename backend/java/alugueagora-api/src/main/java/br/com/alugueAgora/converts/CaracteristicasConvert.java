package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.Caracteristica;
import br.com.alugueAgora.dto.CaracteristicasDTO;

@Component
public class CaracteristicasConvert {

	public List<Caracteristica> convertDTOToEntity(List<CaracteristicasDTO> dto, Caracteristica imovel,
			String dominio) {

		List<Caracteristica> caracteristicasConvert = new ArrayList<>();

		for (CaracteristicasDTO carac : dto) {
			if ("UPDATE".equalsIgnoreCase(dominio)) {
				caracteristicasConvert.add(new Caracteristica(carac.getCodigoCaracteristicas(), carac.getDescricaoCaracterisicas()));
			} else {
				caracteristicasConvert
						.add(new Caracteristica(carac.getDescricaoCaracterisicas()));
			}
		}
		return caracteristicasConvert;
	}

	public List<CaracteristicasDTO> convertEntityToDTO(List<Caracteristica> caracteristicas) {

		List<CaracteristicasDTO> listaCaracteristicas = new ArrayList<>();

		for (Caracteristica carac : caracteristicas) {
			listaCaracteristicas.add(new CaracteristicasDTO(carac.getCodigoCaracteristicas(),
					carac.getDescricaoCaracteristicas()));
		}
		return listaCaracteristicas;
	}

	public CaracteristicasDTO convertEntityToDTO(Caracteristica carac) {
		CaracteristicasDTO dto = new CaracteristicasDTO(carac.getCodigoCaracteristicas(),carac.getDescricaoCaracteristicas());
		return dto;
	}
}
