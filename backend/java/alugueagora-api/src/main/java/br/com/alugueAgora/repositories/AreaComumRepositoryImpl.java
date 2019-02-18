package br.com.alugueAgora.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.alugueAgora.domain.AreaComum;
import br.com.alugueAgora.domain.AreaComum;

@Transactional
@Repository
public class AreaComumRepositoryImpl implements AreaComumRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<AreaComum> listAll() {
		try {
			String hql = "FROM AreaComum as im ORDER BY im.codigoAreaComum";
			return (List<AreaComum>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public AreaComum getById(Long id) {
		try {
			return entityManager.find(AreaComum.class, id);
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
	public AreaComum save(AreaComum imAreaComum) {
		try {
			AreaComum novoAreaComum = new AreaComum();
			novoAreaComum.setDescricaoAreaComum(imAreaComum.getDescricaoAreaComum());
			entityManager.persist(novoAreaComum);
			entityManager.flush();
			return novoAreaComum;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public AreaComum update(AreaComum imAreaComum) {
		try {
			AreaComum novoAreaComum = getById(imAreaComum.getCodigoAreaComum());
			novoAreaComum.setCodigoAreaComum(imAreaComum.getCodigoAreaComum());
			novoAreaComum.setDescricaoAreaComum(imAreaComum.getDescricaoAreaComum());
			entityManager.merge(novoAreaComum);
			entityManager.flush();
			return novoAreaComum;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;

		}
	}
}
