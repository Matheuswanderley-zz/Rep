//package br.com.alugueAgora.repositories;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.apache.commons.beanutils.PropertyUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import br.com.alugueAgora.domain.Proposta;
//
//@Transactional
//@Repository
//public class PropostaRepositoryImpl implements PropostaRepository {
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Proposta> listAll() {
//		try {
//			String hql = "FROM Proposta as im ORDER BY im.codigoProposta";
//			return (List<Proposta>) entityManager.createQuery(hql).getResultList();
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("Ocorreu um erro ao executar o listAll. MSG ORIGINAL: " + e.getMessage());
//			return null;
//		}
//	}
//
//	@Override
//	public Proposta getById(Long id) {
//		try {
//			return entityManager.find(Proposta.class, id);
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("Ocorreu um erro ao executar o getById. MSG ORIGINAL: " + e.getMessage());
//			return null;
//		}
//	}
//
//	@Override
//	public Long delete(Long id) {
//		try {
//			entityManager.remove(getById(id));
//			entityManager.flush();
//			return id;
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("Ocorreu um erro ao executar o delete. MSG ORIGINAL: " + e.getMessage());
//			return null;
//		}
//	}
//
//	@Override
//	public Proposta save(Proposta proposta) {
//
//		try {
//			Proposta entity = new Proposta();
//			
//			PropertyUtils.copyProperties(entity, proposta);
//
//			entityManager.merge(entity);
//			entityManager.flush();
//			return entity; 
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("Ocorreu um erro ao executar o save. MSG ORIGINAL: " + e.getMessage());
//			return null;
//		}
//	}
//
//	@Override
//	public Proposta update(Proposta proposta) {
//		try {
//			Proposta entity = new Proposta();
//			
//			PropertyUtils.copyProperties(entity, proposta);
//			
//			entityManager.persist(entity);
//			entityManager.flush();
//			return entity;
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("Ocorreu um erro ao executar o update. MSG ORIGINAL: " + e.getMessage());
//			return null;
//		}
//
//	}
//
//}
