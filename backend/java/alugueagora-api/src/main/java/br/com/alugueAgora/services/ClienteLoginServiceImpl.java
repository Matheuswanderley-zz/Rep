package br.com.alugueAgora.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugueAgora.domain.ClienteLogin;
import br.com.alugueAgora.repositories.ClienteLoginRepository;

@Service
public class ClienteLoginServiceImpl implements ClienteLoginService{

	private ClienteLoginRepository clienteLoginRepository;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setClienteLoginRepository(ClienteLoginRepository clienteLoginRepository) {
		this.clienteLoginRepository = clienteLoginRepository;
	}

	@Override
	public List<ClienteLogin> listAll() {
		logger.info("listAll ClienteLogin called");
		return (List<ClienteLogin>) clienteLoginRepository.listAll();
	}

	@Override
	public ClienteLogin getById(Long id) {
		logger.info("getClienteLoginById called");
		return clienteLoginRepository.getById(id);
	}

	@Override
	public ClienteLogin save(ClienteLogin imovel) {
		logger.info("save ClienteLogin called");
		return clienteLoginRepository.save(imovel);
	}

	@Override
	public Long delete(Long id) {
		logger.info("delete ClienteLogin called");
		clienteLoginRepository.delete(id);
		return id;
	}

	@Override
	public ClienteLogin update(ClienteLogin imovel) {
		logger.info("update ClienteLogin called");
		return clienteLoginRepository.update(imovel);
	}

	@Override
	public ClienteLogin getByPK(Long codigoClienteLogin, int acesso) {
		logger.info("getByPK ClienteLogin called");
		return clienteLoginRepository.getByPK(codigoClienteLogin,acesso);
	}


}
