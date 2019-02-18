package br.com.alugueAgora.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugueAgora.domain.Cliente;
import br.com.alugueAgora.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	private ClienteRepository clienteRepository;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setClienteRepository(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public List<Cliente> listAll() {
		logger.info("listAll Cliente called");
		return (List<Cliente>) clienteRepository.listAll();
	}

	@Override
	public Cliente getById(Long id) {
		logger.info("getClienteById called");
		return clienteRepository.getById(id);
	}

	@Override
	public Cliente save(Cliente imovel) {
		logger.info("save Cliente called");
		return clienteRepository.save(imovel);
	}

	@Override
	public Long delete(Long id) {
		logger.info("delete Cliente called");
		clienteRepository.delete(id);
		return id;
	}

	@Override
	public Cliente update(Cliente imovel) {
		logger.info("update Cliente called");
		return clienteRepository.update(imovel);
	}

}
