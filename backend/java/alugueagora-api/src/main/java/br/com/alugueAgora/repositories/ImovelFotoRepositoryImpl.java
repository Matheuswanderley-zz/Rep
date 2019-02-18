package br.com.alugueAgora.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alugueAgora.domain.ImovelAreaComum;
import br.com.alugueAgora.domain.ImovelCaracteristica;
import br.com.alugueAgora.domain.ImovelFoto;
import br.com.alugueAgora.dto.ImovelFotoDTO;

@Transactional
@Repository
public class ImovelFotoRepositoryImpl implements ImovelFotoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<ImovelFoto> listAll() {
		try {
			String hql = "FROM ImovelFoto as im ORDER BY im.codigoImovelFoto";
			return (List<ImovelFoto>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o listAll. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ImovelFoto getById(Long id) {
		try {
			return entityManager.find(ImovelFoto.class, id);
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
	public ImovelFoto save(ImovelFoto imFoto) {
		try {
			ImovelFoto novoImovelFoto = new ImovelFoto();
			novoImovelFoto.setFoto(imFoto.getFoto());
			//novoImovelFoto.setImovel(imFoto.getImovel());
			entityManager.persist(novoImovelFoto);
			entityManager.flush();
			return novoImovelFoto;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o save. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ImovelFoto update(ImovelFoto imFoto) {
		try {
			ImovelFoto novoImovelFoto = getById(imFoto.getCodigoImovelFoto());
			novoImovelFoto.setFoto(imFoto.getFoto());
			entityManager.merge(imFoto);
			entityManager.flush();
			return novoImovelFoto;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o update. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<ImovelFoto> getAllByImovel(Long codigoImovel) {
		try {
			Query query = entityManager.createQuery("FROM ImovelFoto if WHERE if.imovel = :codigoImovel");
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
			Query query = entityManager.createQuery("DELETE FROM ImovelFoto if WHERE if.imovel = :codigoImovel");
			query.setParameter("codigoImovel", codigoImovel);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o deleteByImovel. MSG ORIGINAL: " + e.getMessage());
		}
	}

	@Override
	public void updateList(List<ImovelFoto> imovelFotos) {
		for (ImovelFoto ip : imovelFotos) {
			update(ip);
		}
	}

}
