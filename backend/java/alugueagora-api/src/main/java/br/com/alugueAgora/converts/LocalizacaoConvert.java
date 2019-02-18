package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Localizacao;
import br.com.alugueAgora.domain.Tipo;
import br.com.alugueAgora.dto.LocalizacaoDTO;
import br.com.alugueAgora.dto.TipoDTO;

@Component
public class LocalizacaoConvert {


	/**
	 * Metodo para converter um DTO em uma Entidade, no dominio deve ser passado
	 * update ou save para que haja uma validação dos dados que serao setados na
	 * entidade para serem persistidos na base.
	 * 
	 * @param dto
	 * @param dominio
	 * @return Localizacao
	 */
	public Localizacao convertDTOtoEntity(LocalizacaoDTO dto, String dominio) {
		Localizacao localizacao = new Localizacao();
		localizacao.setCodigoLocalizacao(dto.getCodigoLocalizacao());
		localizacao.setTipoLogradouro(dto.getTipoLogradouro());
		localizacao.setNomeLogradouro(dto.getNomeLogradouro());
		localizacao.setNomeBairro(dto.getNomeBairro());
		localizacao.setNomeLocalidade(dto.getNomeLocalidade());
		localizacao.setNomeEstado(dto.getNomeEstado());
		localizacao.setSiglaUF(dto.getSiglaUF());
		localizacao.setCep (dto.getCep());
		localizacao.setDescricaoLocalizacao(dto.getDescricaoLocalizacao());

		return localizacao;
	}

	public LocalizacaoDTO convertEntityToDTO(Localizacao localizacao) {
		LocalizacaoDTO dto = new LocalizacaoDTO();
		dto.setCodigoLocalizacao(localizacao.getCodigoLocalizacao());
		dto.setTipoLogradouro(localizacao.getTipoLogradouro());
		dto.setNomeLogradouro(localizacao.getNomeLogradouro());
		dto.setNomeBairro(localizacao.getNomeBairro());
		dto.setNomeLocalidade(localizacao.getNomeLocalidade());
		dto.setNomeEstado(localizacao.getNomeEstado());
		dto.setSiglaUF(localizacao.getSiglaUF());
		dto.setCep (localizacao.getCep());
		dto.setDescricaoLocalizacao(localizacao.getDescricaoLocalizacao());

		return dto;
	}
	
	
	
}
