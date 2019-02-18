package br.com.alugueAgora.services;

import java.util.List;

import br.com.alugueAgora.domain.ImovelCaracteristica;
import br.com.alugueAgora.dto.ImovelCaracteristicaDTO;

public interface ImovelCaracteristicaService extends CRUDService<ImovelCaracteristica> {

	List<ImovelCaracteristica> getAllByImovel(Long codigoImovel);

	void deleteByImovel(Long codigoImovel);

	void updateList(List<ImovelCaracteristica> imovelCaracteristicas);

}
