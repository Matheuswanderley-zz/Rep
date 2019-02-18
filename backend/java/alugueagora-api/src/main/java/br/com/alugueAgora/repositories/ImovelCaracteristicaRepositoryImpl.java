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
import br.com.alugueAgora.domain.ImovelCaracteristica;
import br.com.alugueAgora.dto.ImovelCaracteristicaDTO;

@Transactional
@Repository
public class ImovelCaracteristicaRepositoryImpl implements ImovelCaracteristicaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<ImovelCaracteristica> listAll() {
		try {
			String hql = "FROM imovelCaracteristica as im ORDER BY im.codigoImovelCaracteristica";
			return (List<ImovelCaracteristica>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o listAll. MSG ORIGINAL: " + e.getMessage());
			return null;
		}

	}

	@Override
	public ImovelCaracteristica getById(Long id) {
		try {
			return entityManager.find(ImovelCaracteristica.class, id);
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
	public ImovelCaracteristica save(ImovelCaracteristica imCaracteristica) {

		try {
			ImovelCaracteristica novoImCaracteristica = new ImovelCaracteristica();
			novoImCaracteristica.setImovel(imCaracteristica.getImovel());
			novoImCaracteristica.setValor(imCaracteristica.getValor());
			novoImCaracteristica.setCaracteristica(imCaracteristica.getCaracteristica());
			entityManager.persist(novoImCaracteristica);
			entityManager.flush();
			return novoImCaracteristica;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o save. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ImovelCaracteristica update(ImovelCaracteristica imCaracteristica) {
		try {
			ImovelCaracteristica novoImCaracteristica = getById(imCaracteristica.getCodigoimovelcaracteristicas());
			novoImCaracteristica.setValor(imCaracteristica.getValor());
			novoImCaracteristica.setCaracteristica(imCaracteristica.getCaracteristica());
			entityManager.merge(novoImCaracteristica);
			entityManager.flush();
			return novoImCaracteristica;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o update. MSG ORIGINAL: " + e.getMessage());
			return null;
		}

	}

	@Override
	public List<ImovelCaracteristica> getAllByImovel(Long codigoImovel) {
		try {
			Query query = entityManager.createQuery("FROM ImovelCaracteristica ic WHERE ic.imovel = :codigoImovel");
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
			Query query = entityManager.createQuery("DELETE FROM ImovelCaracteristica ic WHERE ic.imovel = :codigoImovel");
			query.setParameter("codigoImovel", codigoImovel);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o deleteByImovel. MSG ORIGINAL: " + e.getMessage());
		}
	}

	@Override
	public void updateList(List<ImovelCaracteristica> imovelCaracteristicas) {
		for (ImovelCaracteristica ip : imovelCaracteristicas) {
			update(ip);
		}
	}
}
