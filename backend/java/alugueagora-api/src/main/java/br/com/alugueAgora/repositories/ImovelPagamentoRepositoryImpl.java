package br.com.alugueAgora.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alugueAgora.domain.ImovelFoto;
import br.com.alugueAgora.domain.ImovelPagamento;
import br.com.alugueAgora.dto.ImovelPagamentoDTO;

@Transactional
@Repository
public class ImovelPagamentoRepositoryImpl implements ImovelPagamentoRepository {
	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<ImovelPagamento> listAll() {
		try {
			String hql = "FROM ImovelPagamento as im ORDER BY im.codigoImovelPagamento";
			return (List<ImovelPagamento>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ImovelPagamento getById(Long id) {
		try {

			return entityManager.find(ImovelPagamento.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Long delete(Long id) {
		try {
			entityManager.remove(getById(id));
			entityManager.flush();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ImovelPagamento save(ImovelPagamento imPagamento) {
		try {
			ImovelPagamento novoImovelPagamento = new ImovelPagamento();
			novoImovelPagamento.setDatapagamento(imPagamento.getDatapagamento());
			novoImovelPagamento.setImovel(imPagamento.getImovel());
			novoImovelPagamento.setValorpagamento(imPagamento.getValorpagamento());
			novoImovelPagamento.setStatuspagamento(imPagamento.getStatuspagamento());
			entityManager.persist(novoImovelPagamento);
			entityManager.flush();
			return novoImovelPagamento;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ImovelPagamento update(ImovelPagamento imPagamento) {
		try {
			ImovelPagamento novoImovelPagamento = getById(imPagamento.getCodigopagamento());
			novoImovelPagamento.setDatapagamento(imPagamento.getDatapagamento());
			novoImovelPagamento.setImovel(imPagamento.getImovel());
			novoImovelPagamento.setValorpagamento(imPagamento.getValorpagamento());
			novoImovelPagamento.setStatuspagamento(imPagamento.getStatuspagamento());
			entityManager.merge(imPagamento);
			entityManager.flush();
			return novoImovelPagamento;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;

		}
	}

	@Override
	public List<ImovelPagamento> getAllByImovel(Long codigoImovel) {
		try {
			Query query = entityManager.createQuery("FROM ImovelPagamento ip WHERE ip.imovel = :codigoImovel");
			return query.setParameter("codigoImovel", codigoImovel).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteByImovel(Long codigoImovel) {
		try {
			Query query = entityManager.createQuery("DELETE FROM ImovelPagamento ip WHERE ip.imovel = :codigoImovel");
			query.setParameter("codigoImovel", codigoImovel);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o deleteByImovel. MSG ORIGINAL: " + e.getMessage());
		}
	}

	@Override
	public void updateList(List<ImovelPagamento> imovelPagamentos) {
		for(ImovelPagamento ip : imovelPagamentos) {
			update(ip);
		}
	}

}
