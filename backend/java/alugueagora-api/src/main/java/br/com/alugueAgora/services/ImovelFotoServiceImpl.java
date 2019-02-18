package br.com.alugueAgora.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugueAgora.domain.ImovelFoto;
import br.com.alugueAgora.dto.ImovelFotoDTO;
import br.com.alugueAgora.repositories.ImovelFotoRepository;

@Service
public class ImovelFotoServiceImpl implements ImovelFotoService {

	private ImovelFotoRepository imovelFotoRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setImovelRepository(ImovelFotoRepository imovelFotoRepository) {
		this.imovelFotoRepository = imovelFotoRepository;
	}

	@Override
	public List<ImovelFoto> listAll() {
		logger.info("listAll ImovelFoto called");
		return (List<ImovelFoto>) imovelFotoRepository.listAll();
	}

	@Override
	public ImovelFoto getById(Long id) {
		logger.info("getImovelFotoById called");
		return imovelFotoRepository.getById(id);
	}

	@Override
	public ImovelFoto save(ImovelFoto imovel) {
		logger.info("save ImovelFoto called");
		return imovelFotoRepository.save(imovel);
	}

	@Override
	public Long delete(Long id) {
		logger.info("delete ImovelFoto called");
		imovelFotoRepository.delete(id);
		return id;
	}

	@Override
	public ImovelFoto update(ImovelFoto imovel) {
		logger.info("update ImovelFoto called");
		return imovelFotoRepository.update(imovel);
	}

	@Override
	public List<ImovelFoto> getAllByImovel(Long codigoImovel) {
		logger.info("getAllByImovel ImovelFoto called");
		return imovelFotoRepository.getAllByImovel(codigoImovel);
	}

	@Override
	public void deleteByImovel(Long codigoImovel) {
		logger.info("deleteByImovel ImovelFoto called");
		imovelFotoRepository.deleteByImovel(codigoImovel);		
	}

	@Override
	public void updateList(List<ImovelFoto> imovelFotos) {
		logger.info("updateByImovel ImovelFoto called");
		imovelFotoRepository.updateList(imovelFotos);		
	}

}
