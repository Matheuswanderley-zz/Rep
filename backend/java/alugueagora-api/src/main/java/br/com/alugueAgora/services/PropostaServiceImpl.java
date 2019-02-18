package br.com.alugueAgora.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugueAgora.domain.Proposta;
import br.com.alugueAgora.repositories.PropostaRepository;

@Service
public class PropostaServiceImpl implements PropostaService {
	
	private PropostaRepository repository;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setPropostaRepository(PropostaRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Proposta> listAll() {
		logger.info("listAllPropostas called");
		return (List<Proposta>) repository.findAll();
	}

	@Override
	public Proposta getById(Long id) {
		logger.info("getPropostaById called");
		return repository.findOne(id);
	}

	@Override
	public Proposta save(Proposta proposta) {
		logger.info("saveProposta called");
		return repository.save(proposta);
	}

	@Override
	public Long delete(Long id) {
		logger.info("deleteProposta called");
		repository.delete(id);
		return id;
	}

	@Override
	public Proposta update(Proposta proposta) {
		logger.info("update called");
		return repository.save(proposta);
	}
}
