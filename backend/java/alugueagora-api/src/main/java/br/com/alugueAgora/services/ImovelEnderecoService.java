package br.com.alugueAgora.services;


import java.util.List;

import br.com.alugueAgora.domain.ImovelEndereco;
import br.com.alugueAgora.dto.ImovelEnderecoDTO;

public interface ImovelEnderecoService extends CRUDService<ImovelEndereco>{

	List<ImovelEndereco> getAllByImovel(Long codigoImovel);

	void deleteByImovel(Long codigoImovel);

	void updateList(List<ImovelEndereco> imovelEnderecos);
}
