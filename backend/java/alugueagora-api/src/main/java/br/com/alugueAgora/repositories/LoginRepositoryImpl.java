package br.com.alugueAgora.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alugueAgora.domain.Acesso;
import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.Login;
import br.com.alugueAgora.domain.Tipo;

@Transactional
@Repository
public class LoginRepositoryImpl implements LoginRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Login> listAll() {
		try {
			String hql = "FROM Login as l";
			return (List<Login>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o listAll. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Login getById(Long id) {
		try {
			return entityManager.find(Login.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getById. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Login save(Login login) {
		try {
			Login novoLogin = new Login();
			novoLogin.setDataLogin(login.getDataLogin());
			novoLogin.setEmail(login.getEmail());
			novoLogin.setPassword(login.getPassword());
			novoLogin.setAcessos(login.getAcessos());
			novoLogin.setDataAcesso(login.getDataAcesso());
			entityManager.persist(novoLogin);
			entityManager.flush();
			return novoLogin;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o save. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Login update(Login login) {
		try {
			Login novoLogin = new Login();
			novoLogin.setCodigoLogin(login.getCodigoLogin());
			novoLogin.setDataLogin(login.getDataLogin());
			novoLogin.setEmail(login.getEmail());
			novoLogin.setPassword(login.getPassword());
			novoLogin.setAcessos(login.getAcessos());
			entityManager.persist(novoLogin);
			entityManager.flush();
			return novoLogin;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o update. MSG ORIGINAL: " + e.getMessage());
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

	public Login findByUsername(String email) {
		List<Login> logins = new ArrayList<>();
		Login login = new Login();
		try {
			Query query = entityManager.createQuery("select l from Login l where l.email = :email");
			logins = query.setParameter("email", email).getResultList();
			
			for(Login l : logins) {
				login = l;
			}
			return login;
		} catch (NoResultException  e) {
			logger.error("Ocorreu um erro ao executar o listAll. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

}
