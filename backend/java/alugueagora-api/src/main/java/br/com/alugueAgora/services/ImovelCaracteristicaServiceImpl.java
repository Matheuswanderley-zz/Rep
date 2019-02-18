package br.com.alugueAgora.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugueAgora.domain.ImovelCaracteristica;
import br.com.alugueAgora.dto.ImovelCaracteristicaDTO;
import br.com.alugueAgora.repositories.ImovelCaracteristicaRepository;

@Service
public class ImovelCaracteristicaServiceImpl implements ImovelCaracteristicaService {
	private ImovelCaracteristicaRepository imovelCaracteristicaRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setImovelCaracteristicaRepository(ImovelCaracteristicaRepository imovelCaracteristicaRepository) {
		this.imovelCaracteristicaRepository = imovelCaracteristicaRepository;
	}

	@Override
	public List<ImovelCaracteristica> listAll() {
		logger.info("listAll Caracteristica called");
		return (List<ImovelCaracteristica>) imovelCaracteristicaRepository.listAll();
	}

	@Override
	public ImovelCaracteristica getById(Long id) {
		logger.info("get Caracteristica By Id called");
		return imovelCaracteristicaRepository.getById(id);
	}

	@Override
	public ImovelCaracteristica save(ImovelCaracteristica domainObject) {
		logger.info("save Caracteristica called");
		return imovelCaracteristicaRepository.save(domainObject);
	}

	@Override
	public Long delete(Long id) {
		logger.info("delete Caracteristica called");
		imovelCaracteristicaRepository.delete(id);
		return id;
	}

	@Override
	public ImovelCaracteristica update(ImovelCaracteristica domainObject) {
		logger.info("save Caracteristica called");
		return imovelCaracteristicaRepository.update(domainObject);
	}

	@Override
	public List<ImovelCaracteristica> getAllByImovel(Long codigoImovel) {
		logger.info("getAllByImovel Caracteristica called");
		return imovelCaracteristicaRepository.getAllByImovel(codigoImovel);
	}

	@Override
	public void deleteByImovel(Long codigoImovel) {
		logger.info("deleteByImovel Caracteristica called");
		imovelCaracteristicaRepository.deleteByImovel(codigoImovel);
	}

	@Override
	public void updateList(List<ImovelCaracteristica> imovelCaracteristicas) {
		logger.info("updateByImovel Caracteristica called");
		imovelCaracteristicaRepository.updateList(imovelCaracteristicas);
	}
}