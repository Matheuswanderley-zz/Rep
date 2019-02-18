package br.com.alugueAgora.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.alugueAgora.domain.Negocio;

@Transactional
@Repository
public class NegocioRepositoryImpl implements NegocioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Negocio> listAll() {
		try {
			String hql = "FROM Negocio as im ORDER BY im.codigoNegocio";
			return (List<Negocio>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Negocio getById(Long id) {
		try {
			return entityManager.find(Negocio.class, id);
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
	public Negocio save(Negocio imNegocio) {
		try {
			Negocio novoNegocio = new Negocio();
			novoNegocio.setDescricaoNegocio(imNegocio.getDescricaoNegocio());
			entityManager.persist(novoNegocio);
			entityManager.flush();
			return novoNegocio;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Negocio update(Negocio imNegocio) {
		try {
			Negocio novoNegocio = getById(imNegocio.getCodigoNegocio());
			novoNegocio.setCodigoNegocio(imNegocio.getCodigoNegocio());
			novoNegocio.setDescricaoNegocio(imNegocio.getDescricaoNegocio());
			entityManager.merge(novoNegocio);
			entityManager.flush();
			return novoNegocio;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;

		}
	}
}
