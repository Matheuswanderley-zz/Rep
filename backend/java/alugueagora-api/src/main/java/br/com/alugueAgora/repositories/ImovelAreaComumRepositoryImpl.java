package br.com.alugueAgora.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.ImovelAreaComum;
import br.com.alugueAgora.domain.ImovelEndereco;
import br.com.alugueAgora.domain.ImovelPagamento;
import br.com.alugueAgora.dto.ImovelAreaComumDTO;

@Repository
@Transactional
public class ImovelAreaComumRepositoryImpl implements ImovelAreaComumRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<ImovelAreaComum> listAll() {
		try {
			String hql = "FROM ImovelAreaComum as im ORDER BY im.codigoimovelareacomum";
			return (List<ImovelAreaComum>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o listAll. MSG ORIGINAL: " + e.getMessage());
			return null;
		}

	}

	@Override
	public ImovelAreaComum getById(Long id) {
		try {
			return entityManager.find(ImovelAreaComum.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getById. MSG ORIGINAL: " + e.getMessage());
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
			logger.error("Ocorreu um erro ao executar o delete. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ImovelAreaComum save(ImovelAreaComum imAreaComum) {

		try {
			ImovelAreaComum novoImAreaComum = new ImovelAreaComum();
			novoImAreaComum.setImovel(imAreaComum.getImovel());
			novoImAreaComum.setValor(imAreaComum.getValor());
			novoImAreaComum.setAreaComum(imAreaComum.getAreaComum());
			entityManager.persist(novoImAreaComum);
			entityManager.flush();
			return novoImAreaComum;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o save. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ImovelAreaComum update(ImovelAreaComum imAreaComum) {
		try {
			ImovelAreaComum novoImAreaComum = getById(imAreaComum.getCodigoimovelareacomum());
			novoImAreaComum.setValor(imAreaComum.getValor());
			novoImAreaComum.setAreaComum(imAreaComum.getAreaComum());
			entityManager.merge(novoImAreaComum);
			entityManager.flush();
			return novoImAreaComum;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o update. MSG ORIGINAL: " + e.getMessage());
			return null;
		}

	}

	@Override
	public List<ImovelAreaComum> getAllByImovel(Long codigoImovel) {
		try {
			Query query = entityManager.createQuery("FROM ImovelAreaComum as iac WHERE iac.imovel = :codigoImovel");
			return query.setParameter("codigoImovel", codigoImovel).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o listAll. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteByImovel(Long codigoImovel) {
		try {
			Query query = entityManager.createQuery("DELETE FROM ImovelAreaComum ip WHERE ip.imovel = :codigoImovel");
			query.setParameter("codigoImovel", codigoImovel);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o deleteByImovel. MSG ORIGINAL: " + e.getMessage());
		}

	}

	@Override
	public void updateList(List<ImovelAreaComum> imovelAreaComum) {
		for (ImovelAreaComum ip : imovelAreaComum) {
			update(ip);
		}
	}
}
