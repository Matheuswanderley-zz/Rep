package br.com.alugueAgora.services;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugueAgora.domain.ImovelEndereco;
import br.com.alugueAgora.dto.ImovelEnderecoDTO;
import br.com.alugueAgora.repositories.ImovelEnderecoRepository;
import br.com.alugueAgora.services.ImovelEnderecoService;

@Service
public class ImovelEnderecoServiceImpl implements ImovelEnderecoService{
	private ImovelEnderecoRepository imovelEnderecoRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setImovelEnderecoRepository(ImovelEnderecoRepository imovelEnderecoRepository) {
		this.imovelEnderecoRepository = imovelEnderecoRepository;
	}

	@Override
	public List<ImovelEndereco> listAll() {
		logger.info("listAll endereco called");
		return (List<ImovelEndereco>) imovelEnderecoRepository.listAll();
	}

	@Override
	public ImovelEndereco getById(Long id) {
		logger.info("get endereco By Id called");
		return imovelEnderecoRepository.getById(id);
	}

	@Override
	public ImovelEndereco save(ImovelEndereco domainObject) {
		logger.info("save endereco called");
		return imovelEnderecoRepository.save(domainObject);
	}

	@Override
	public Long delete(Long id) {
		logger.info("delete endereco called");
		imovelEnderecoRepository.delete(id);
		return id;
	}

	@Override
	public ImovelEndereco update(ImovelEndereco domainObject) {
		logger.info("save endereco called");
		return imovelEnderecoRepository.update(domainObject);
	}

	@Override
	public List<ImovelEndereco> getAllByImovel(Long codigoImovel) {
		logger.info("getAllByImovel endereco called");
		return imovelEnderecoRepository.getAllByImovel(codigoImovel);
	}

	@Override
	public void deleteByImovel(Long codigoImovel) {
		logger.info("deleteByImovel endereco called");
		imovelEnderecoRepository.deleteByImovel(codigoImovel);		
	}

	@Override
	public void updateList(List<ImovelEndereco> imovelEnderecos) {
		logger.info("updateByImovel endereco called");
		imovelEnderecoRepository.updateList(imovelEnderecos);		
	}
}