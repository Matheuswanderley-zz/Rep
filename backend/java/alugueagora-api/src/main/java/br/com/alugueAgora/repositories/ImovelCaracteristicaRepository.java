package br.com.alugueAgora.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.alugueAgora.domain.ImovelCaracteristica;
import io.swagger.annotations.Api;

public interface ImovelCaracteristicaRepository extends CRUDRepository<ImovelCaracteristica> {

	List<ImovelCaracteristica> getAllByImovel(Long codigoImovel);

	void deleteByImovel(Long codigoImovel);

	void updateList(List<ImovelCaracteristica> imovelCaracteristicas);

}
