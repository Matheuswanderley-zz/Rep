package br.com.alugueAgora.repositories;

import java.util.List;

import br.com.alugueAgora.domain.ImovelPagamento;
import br.com.alugueAgora.dto.ImovelPagamentoDTO;

public interface ImovelPagamentoRepository extends CRUDRepository<ImovelPagamento> {

	List<ImovelPagamento> getAllByImovel(Long codigoImovel);

	void deleteByImovel(Long codigoImovel);

	void updateList(List<ImovelPagamento> imovelPagamentos);

}
