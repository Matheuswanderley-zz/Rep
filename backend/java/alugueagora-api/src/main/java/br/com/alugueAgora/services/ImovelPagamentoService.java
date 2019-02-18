package br.com.alugueAgora.services;

import java.util.List;

import br.com.alugueAgora.domain.ImovelPagamento;
import br.com.alugueAgora.dto.ImovelPagamentoDTO;

public interface ImovelPagamentoService extends CRUDService<ImovelPagamento>{

	List<ImovelPagamento> getAllByImovel(Long codigoImovel);

	void deleteByImovel(Long codigoImovel);

	void updateList(List<ImovelPagamento> imovelPagamentos);

}
