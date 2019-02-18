package br.com.alugueAgora.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.Localizacao;

@Transactional
@Repository
public class LocalizacaoRepositoryImpl implements LocalizacaoRepository {
	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Localizacao> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Localizacao getById(Long id) {
		try {
			return entityManager.find(Localizacao.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getById. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Localizacao save(Localizacao domainObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Localizacao update(Localizacao domainObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Localizacao getByCep(String cep) {
		try {
			String hql = "SELECT l FROM Localizacao AS l WHERE l.cep =:cep ";
			return (Localizacao) entityManager.createQuery(hql).setParameter("cep", cep).getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getByCep. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Localizacao> getByDescricao(String descricao) {
		try {
			String hql = "SELECT l FROM Localizacao AS l WHERE upper(l.descricaoLocalizacao) LIKE :descricao ";
			return (List<Localizacao>) entityManager.createQuery(hql).setParameter("descricao", "%"+descricao.toUpperCase()+"%").getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getByCep. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	

}
