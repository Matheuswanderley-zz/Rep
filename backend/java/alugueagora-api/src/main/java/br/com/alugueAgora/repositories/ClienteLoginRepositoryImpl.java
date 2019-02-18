package br.com.alugueAgora.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.alugueAgora.domain.ClienteLogin;
import br.com.alugueAgora.domain.ClienteLoginPK;
import br.com.alugueAgora.domain.Imovel;

@Transactional
@Repository
public class ClienteLoginRepositoryImpl implements ClienteLoginRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<ClienteLogin> listAll() {
		try {
			String hql = "FROM ClienteLogin";
			return (List<ClienteLogin>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o listAll cliente MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ClienteLogin getById(Long id) {
		try {
			return entityManager.find(ClienteLogin.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o getById cliente MSG ORIGINAL: " + e.getMessage());
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
			logger.error("Ocorreu um erro ao executar o delete cliente MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ClienteLogin save(ClienteLogin imClienteLogin) {
		try {
			ClienteLogin novoClienteLogin = new ClienteLogin();
			novoClienteLogin.getPk().setCodigoAcesso(imClienteLogin.getPk().getCodigoAcesso());
			novoClienteLogin.getPk().setCodigoLogin(imClienteLogin.getPk().getCodigoLogin());
			novoClienteLogin.setCodigoCliente(imClienteLogin.getCodigoCliente());
			entityManager.persist(novoClienteLogin);
			entityManager.flush();
			return novoClienteLogin;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o save ClienteLogin MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ClienteLogin update(ClienteLogin imClienteLogin) {
		try {
			ClienteLogin novoClienteLogin = getByPK(imClienteLogin.getPk());
			novoClienteLogin.getPk().setCodigoAcesso(imClienteLogin.getPk().getCodigoAcesso());
			novoClienteLogin.getPk().setCodigoLogin(imClienteLogin.getPk().getCodigoLogin());
			novoClienteLogin.setCodigoCliente(imClienteLogin.getCodigoCliente());
			entityManager.merge(novoClienteLogin);
			entityManager.flush();
			return novoClienteLogin;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o update ClienteLogin MSG ORIGINAL: " + e.getMessage());
			return null;

		}
	}

	private ClienteLogin getByPK(ClienteLoginPK pk) {
		ClienteLogin clienteLogin = new ClienteLogin();
		try {
			String hql = "FROM ClienteLogin cl " + "WHERE cl.pk.codigoAcesso =: codigoAcesso "
					+ "AND cl.pk.codigoLogin =: codigoLogin";
			List<ClienteLogin> lista = entityManager.createQuery(hql).setParameter("codigoAcesso", pk.getCodigoAcesso())
					.setParameter("codigoLogin", pk.getCodigoLogin()).getResultList();
			for (ClienteLogin c : lista) {
				clienteLogin = c;
			}
			return clienteLogin;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o listAll cliente MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ClienteLogin getByPK(Long codigoClienteLogin, int acesso) {
		ClienteLogin clienteLogin = new ClienteLogin();
		try {
			String hql = "FROM ClienteLogin cl " + "WHERE cl.pk.codigoAcesso =: codigoAcesso "
					+ "AND cl.pk.codigoLogin =: codigoLogin";
			List<ClienteLogin> lista = entityManager.createQuery(hql).setParameter("codigoAcesso", acesso)
					.setParameter("codigoLogin", codigoClienteLogin).getResultList();
			for (ClienteLogin c : lista) {
				clienteLogin = c;
			}
			return clienteLogin;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o listAll cliente MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}
}
