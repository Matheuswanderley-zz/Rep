package br.com.alugueAgora.services;

import br.com.alugueAgora.domain.ClienteLogin;

public interface ClienteLoginService extends CRUDService<ClienteLogin>{

	ClienteLogin getByPK(Long codigoClienteLogin, int acesso);

}
