package br.com.alugueAgora.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugueAgora.domain.ImovelAreaComum;
import br.com.alugueAgora.dto.ImovelAreaComumDTO;
import br.com.alugueAgora.repositories.ImovelAreaComumRepository;

@Service
public class ImovelAreaComumServiceImpl implements ImovelAreaComumService {
	private ImovelAreaComumRepository imovelAreaComumRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setImovelAreaComumRepository(ImovelAreaComumRepository imovelAreaComumRepository) {
		this.imovelAreaComumRepository = imovelAreaComumRepository;
	}

	@Override
	public List<ImovelAreaComum> listAll() {
		logger.info("listAll AreaComum called");
		return (List<ImovelAreaComum>) imovelAreaComumRepository.listAll();
	}

	@Override
	public ImovelAreaComum getById(Long id) {
		logger.info("get AreaComum By Id called");
		return imovelAreaComumRepository.getById(id);
	}

	@Override
	public ImovelAreaComum save(ImovelAreaComum domainObject) {
		logger.info("save AreaComum called");
		return imovelAreaComumRepository.save(domainObject);
	}

	@Override
	public Long delete(Long id) {
		logger.info("delete AreaComum called");
		imovelAreaComumRepository.delete(id);
		return id;
	}

	@Override
	public ImovelAreaComum update(ImovelAreaComum domainObject) {
		logger.info("save AreaComum called");
		return imovelAreaComumRepository.update(domainObject);
	}

	@Override
	public List<ImovelAreaComum> getAllByImovel(Long codigoImovel) {
		logger.info("save getAllByImovel called");
		return imovelAreaComumRepository.getAllByImovel(codigoImovel);
	}

	@Override
	public void deleteByImovel(Long codigoImovel) {
		logger.info("deleteByImovel AreaComum called");
		imovelAreaComumRepository.deleteByImovel(codigoImovel);
	}

	@Override
	public void updateList(List<ImovelAreaComum> imovelAreaComum) {
		logger.info("updateByImovel AreaComum called");
		imovelAreaComumRepository.updateList(imovelAreaComum);
	}
}