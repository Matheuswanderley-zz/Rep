package br.com.alugueAgora.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.alugueAgora.domain.Caracteristica;

@Transactional
@Repository
public class CaracteristicasRepositoryImpl implements CaracteristicasRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Caracteristica> listAll() {
		try {
			String hql = "FROM Caracteristica as im ORDER BY im.codigoCaracteristicas";
			return (List<Caracteristica>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Caracteristica getById(Long id) {
		try {
			return entityManager.find(Caracteristica.class, id);
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
	public Caracteristica save(Caracteristica imCaracteristica) {
		try {
			Caracteristica novoCaracteristica = new Caracteristica();
			novoCaracteristica.setDescricaoCaracteristicas(imCaracteristica.getDescricaoCaracteristicas());
			entityManager.persist(novoCaracteristica);
			entityManager.flush();
			return novoCaracteristica;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Caracteristica update(Caracteristica imCaracteristica) {
		try {
			Caracteristica novoCaracteristica = getById(imCaracteristica.getCodigoCaracteristicas());
			novoCaracteristica.setCodigoCaracteristicas(imCaracteristica.getCodigoCaracteristicas());
			novoCaracteristica.setDescricaoCaracteristicas(imCaracteristica.getDescricaoCaracteristicas());
			entityManager.merge(novoCaracteristica);
			entityManager.flush();
			return novoCaracteristica;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getAllByImovel. MSG ORIGINAL: " + e.getMessage());
			return null;

		}
	}
}

