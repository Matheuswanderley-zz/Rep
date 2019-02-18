package br.com.alugueAgora.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.repositories.ImovelRepository;

@Service
public class ImovelServiceImpl implements ImovelService {
	private ImovelRepository imovelRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setImovelRepository(ImovelRepository imovelRepository) {
		this.imovelRepository = imovelRepository;
	}

	@Override
	public List<Imovel> listAll() {
		logger.info("listAllImoveis called");
		return (List<Imovel>) imovelRepository.listAll();
	}

	@Override
	public Imovel getById(Long id) {
		logger.info("getImovelById called");
		return imovelRepository.getById(id);
	}

	@Override
	public Imovel save(Imovel imovel) {
		logger.info("saveImovel called");
		return imovelRepository.save(imovel);
	}

	@Override
	public Long delete(Long id) {
		logger.info("deleteImovel called");
		imovelRepository.delete(id);
		return id;
	}

	@Override
	public Imovel update(Imovel imovel) {
		logger.info("update called");
		return imovelRepository.update(imovel);
	}

	@Override
	public List<Imovel> findBy(Long tipo, Long negocio, Long quantidadeBanheiros, Long quantidadeDormitorios, Long quantidadeSuites, Long quantidadeGaragem) {
		logger.info("findBy(Long tipo, Long negocio, Long quantidadeBanheiros, Long quantidadeDormitorios, Long quantidadeSuites, Long quantidadeGaragem) called");
		return (List<Imovel>) imovelRepository.findBy(tipo, negocio, quantidadeBanheiros, quantidadeDormitorios, quantidadeSuites, quantidadeGaragem);
	}
}
