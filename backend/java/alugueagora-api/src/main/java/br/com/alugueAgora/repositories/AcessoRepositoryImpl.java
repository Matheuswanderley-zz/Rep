package br.com.alugueAgora.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.alugueAgora.domain.Acesso;
import br.com.alugueAgora.domain.Login;

@Transactional
@Repository
public class AcessoRepositoryImpl implements AcessoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Acesso> listAll() {
		try {
			String hql = "FROM Acesso as im ORDER BY im.codigoAcesso";
			return (List<Acesso>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o listAll MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Acesso getById(Long id) {
		try {
			return entityManager.find(Acesso.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getById MSG ORIGINAL: " + e.getMessage());
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
			logger.error("Ocorreu um erro ao executar o delete MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Acesso save(Acesso imAcesso) {
		try {
			Acesso novoAcesso = new Acesso();
			novoAcesso.setTipoAcesso(imAcesso.getTipoAcesso());
			entityManager.persist(novoAcesso);
			entityManager.flush();
			return novoAcesso;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o save MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Acesso update(Acesso imAcesso) {
		try {
			Acesso novoAcesso = getById(imAcesso.getCodigoAcesso());
			novoAcesso.setCodigoAcesso(imAcesso.getCodigoAcesso());
			novoAcesso.setTipoAcesso(imAcesso.getTipoAcesso());
			entityManager.merge(novoAcesso);
			entityManager.flush();
			return novoAcesso;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o update. MSG ORIGINAL: " + e.getMessage());
			return null;

		}
	}

	@Override
	public Acesso findByTipoAcesso(String tipoAcesso) {
		try {
			Acesso acesso = new Acesso();
			Query query = entityManager.createQuery("FROM Acesso a WHERE a.tipoAcesso = :tipoAcesso");
			acesso = (Acesso) query.setParameter("tipoAcesso", tipoAcesso).getSingleResult();
			return acesso;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o findByTipoAcesso MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}
}
