package br.com.alugueAgora.repositories;

import java.util.List;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.alugueAgora.domain.ImovelAreaComum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


public interface ImovelAreaComumRepository extends CRUDRepository<ImovelAreaComum> {

	@Override
	@ApiOperation("Operações na entidade de Area Comum")
	@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = ImovelAreaComum.class) })
	ImovelAreaComum save(ImovelAreaComum address);
	
	List<ImovelAreaComum> getAllByImovel(Long codigoImovel);

	void deleteByImovel(Long codigoImovel);

	void updateList(List<ImovelAreaComum> imovelAreaComum);

}
