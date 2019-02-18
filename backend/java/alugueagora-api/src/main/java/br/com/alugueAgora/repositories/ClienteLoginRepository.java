package br.com.alugueAgora.repositories;

import br.com.alugueAgora.domain.ClienteLogin;

public interface ClienteLoginRepository extends CRUDRepository<ClienteLogin> {

	ClienteLogin getByPK(Long codigoClienteLogin, int acesso);

}
