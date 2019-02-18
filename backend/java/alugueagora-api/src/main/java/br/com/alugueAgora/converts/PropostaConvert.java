package br.com.alugueAgora.converts;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.Proposta;
import br.com.alugueAgora.dto.PropostaDTO;
import br.com.alugueAgora.enumerations.DominioConverter;

@Component
public class PropostaConvert {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ImovelConvert imovelConvert;

	@Autowired
	TipoConvert tipoConvert;

	/**
	 * Metodo para converter um DTO em uma Entidade, no dominio deve ser passado
	 * update ou save para que haja uma validação dos dados que serao setados na
	 * entidade para serem persistidos na base.
	 * 
	 * @param dto
	 * @param dominio
	 * @return Proposta
	 */
	public Proposta convertDTOtoEntity(PropostaDTO dto, DominioConverter dominioConverter) {
		Proposta proposta = new Proposta();

		try {
			PropertyUtils.copyProperties(proposta, dto);

			if (null != dto.getImovelPermutaDto()) {
				Imovel imovelPermuta = new Imovel();
				imovelPermuta.setCodigoImovel(dto.getImovelPermutaDto().getCodigoImovel());
				proposta.setImovelPermuta(imovelPermuta);
			}
				
			if (null != dto.getTipoDto()) {
				proposta.setTipo(tipoConvert.convertDTOtoEntity(dto.getTipoDto()));
			}
		
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o convertEntityToDTO. MSG ORIGINAL: " + e.getMessage());
			return null;
		}

		return proposta;
	}

	public PropostaDTO convertEntityToDTO(Proposta entity) {
		PropostaDTO dto = new PropostaDTO();

		try {
			PropertyUtils.copyProperties(dto, entity);

			if (null != entity.getImovelPermuta()) {
				dto.setImovelPermutaDto(imovelConvert.convertEntityToDTO(entity.getImovelPermuta()));
			}

			if (null != entity.getTipo()) {
				dto.setTipoDto(tipoConvert.convertEntityToDTO(entity.getTipo()));
			}

		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o convertEntityToDTO. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
		
		return dto;
	}
}
