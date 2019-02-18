package br.com.alugueAgora.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugueAgora.domain.Localizacao;
import br.com.alugueAgora.repositories.LocalizacaoRepository;

@Service
public class LocalizacaoServiceImpl implements LocalizacaoService {
	private LocalizacaoRepository localizacaoRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public void setLocalizacaoRepository(LocalizacaoRepository localizacaoRepository) {
		this.localizacaoRepository = localizacaoRepository;
	}
		
	@Override
	public List<Localizacao> listAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Localizacao getById(Long id) {
		logger.info("getLocalizacaoById called");
		return localizacaoRepository.getById(id);
	}
	@Override
	public Localizacao save(Localizacao domainObject) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Localizacao update(Localizacao domainObject) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Localizacao getByCep(String cep) {
		logger.info("getLocalizacaoByCEP called");
		return localizacaoRepository.getByCep(cep);
	}

	@Override
	public List<Localizacao> getByDescricao(String descricaoLocalizacao) {
		logger.info("getLocalizacaoByDescricao called");
		return localizacaoRepository.getByDescricao(descricaoLocalizacao);
	}
	
	
}
