package br.com.alugueAgora.repositories;

import java.util.List;

import br.com.alugueAgora.domain.ImovelEndereco;

public interface ImovelEnderecoRepository  extends CRUDRepository<ImovelEndereco> {
	ImovelEndereco saveList(List<ImovelEndereco> enderecos);

	List<ImovelEndereco> getAllByImovel(Long codigoImovel);

	void deleteByImovel(Long codigoImovel);

	void updateList(List<ImovelEndereco> imovelEnderecos);
}
