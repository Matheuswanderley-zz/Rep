package br.com.alugueAgora.repositories;

import br.com.alugueAgora.domain.Acesso;

public interface AcessoRepository extends CRUDRepository<Acesso> {

	Acesso findByTipoAcesso(String tipoAcesso);
}
