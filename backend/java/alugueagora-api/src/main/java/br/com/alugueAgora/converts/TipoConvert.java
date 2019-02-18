package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Tipo;
import br.com.alugueAgora.dto.TipoDTO;

@Component
public class TipoConvert {

	public List<Tipo> convertDTOToEntity(List<TipoDTO> dto, String dominio) {
 
		List<Tipo> TipoConvert = new ArrayList<>();

		for (TipoDTO tipo : dto) {
			if ("UPDATE".equalsIgnoreCase(dominio)) {
				TipoConvert.add(new Tipo(tipo.getCodigoTipo(), tipo.getDescricaoTipo()));
			} else {
				TipoConvert.add(new Tipo(tipo.getDescricaoTipo()));
			}
		}
		return TipoConvert;
	}

	public List<TipoDTO> convertEntityToDTO(List<Tipo> lista) {

		List<TipoDTO> listaTipos = new ArrayList<>();

		for (Tipo tipo : lista) {
			listaTipos.add(new TipoDTO(tipo.getCodigoTipo(), tipo.getDescricaoTipo()));
		}
		return listaTipos;
	}

	public TipoDTO convertEntityToDTO(Tipo tipo) {
		TipoDTO dto = new TipoDTO(tipo.getCodigoTipo(), tipo.getDescricaoTipo());
		return dto;
	}

	public Tipo convertDTOtoEntity(TipoDTO dto) {
		Tipo entity = new Tipo(dto.getCodigoTipo(), dto.getDescricaoTipo());
		return entity;
	}
}
