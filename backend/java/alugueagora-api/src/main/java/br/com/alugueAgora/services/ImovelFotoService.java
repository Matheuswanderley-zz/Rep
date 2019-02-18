package br.com.alugueAgora.services;

import java.util.List;

import br.com.alugueAgora.domain.ImovelFoto;
import br.com.alugueAgora.dto.ImovelFotoDTO;

public interface ImovelFotoService extends CRUDService<ImovelFoto> {

	List<ImovelFoto> getAllByImovel(Long codigoImovel);

	void deleteByImovel(Long codigoImovel);

	void updateList(List<ImovelFoto> imovelFotos);

}
