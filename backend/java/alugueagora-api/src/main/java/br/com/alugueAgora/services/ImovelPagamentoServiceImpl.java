package br.com.alugueAgora.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugueAgora.domain.ImovelPagamento;
import br.com.alugueAgora.dto.ImovelPagamentoDTO;
import br.com.alugueAgora.domain.ImovelPagamento;
import br.com.alugueAgora.repositories.ImovelPagamentoRepository;

@Service
public class ImovelPagamentoServiceImpl implements ImovelPagamentoService {
	private ImovelPagamentoRepository imovelPagamentoRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setImovelRepository(ImovelPagamentoRepository imovelPagamentoRepository) {
		this.imovelPagamentoRepository = imovelPagamentoRepository;
	}

	@Override
	public List<ImovelPagamento> listAll() {
		logger.info("listAll ImovelPagamento called");
		return (List<ImovelPagamento>) imovelPagamentoRepository.listAll();
	}

	@Override
	public ImovelPagamento getById(Long id) {
		logger.info("getById ImovelPagamento called");
		return imovelPagamentoRepository.getById(id);
	}

	@Override
	public ImovelPagamento save(ImovelPagamento imovel) {
		logger.info("save ImovelPagamento called");
		return imovelPagamentoRepository.save(imovel);
	}

	@Override
	public Long delete(Long id) {
		logger.info("delete ImovelPagamento called");
		imovelPagamentoRepository.delete(id);
		return id;
	}

	@Override
	public ImovelPagamento update(ImovelPagamento imovel) {
		logger.info("update ImovelPagamento called");
		return imovelPagamentoRepository.update(imovel);
	}

	@Override
	public List<ImovelPagamento> getAllByImovel(Long codigoImovel) {
		logger.info("getAllByImovel ImovelPagamento called");
		return imovelPagamentoRepository.getAllByImovel(codigoImovel);
	}

	@Override
	public void deleteByImovel(Long codigoImovel) {
		logger.info("deleteByImovel ImovelPagamento called");
		imovelPagamentoRepository.deleteByImovel(codigoImovel);		
	}

	@Override
	public void updateList(List<ImovelPagamento> imovelPagamentos) {
		logger.info("updateByImovel ImovelPagamento called");
		imovelPagamentoRepository.updateList(imovelPagamentos);		
	}

}
