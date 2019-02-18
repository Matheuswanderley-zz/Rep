package br.com.alugueAgora.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.alugueAgora.domain.Tipo;


@Transactional
@Repository
public class TipoRepositoryImpl implements TipoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Tipo> listAll() {
		try {
			String hql = "FROM Tipo as im ORDER BY im.codigoTipo";
			return (List<Tipo>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Tipo getById(Long id) {
		try {
			return entityManager.find(Tipo.class, id);
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
	public Tipo save(Tipo imTipo) {
		try {
			Tipo novoTipo = new Tipo();
			novoTipo.setDescricaoTipo(imTipo.getDescricaoTipo());
			entityManager.persist(novoTipo);
			entityManager.flush();
			return novoTipo;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Tipo update(Tipo imTipo) {
		try {
			Tipo novoTipo = getById(imTipo.getCodigoTipo());
			novoTipo.setCodigoTipo(imTipo.getCodigoTipo());
			novoTipo.setDescricaoTipo(imTipo.getDescricaoTipo());
			entityManager.merge(novoTipo);
			entityManager.flush();
			return novoTipo;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;

		}
	}
}
