package br.com.alugueAgora.services;

import java.util.List;

import br.com.alugueAgora.domain.ImovelAreaComum;
import br.com.alugueAgora.dto.ImovelAreaComumDTO;

public interface ImovelAreaComumService extends CRUDService<ImovelAreaComum>{

	List<ImovelAreaComum> getAllByImovel(Long codigoImovel);

	void deleteByImovel(Long codigoImovel);

	void updateList(List<ImovelAreaComum> imovelAreaComum);

}
