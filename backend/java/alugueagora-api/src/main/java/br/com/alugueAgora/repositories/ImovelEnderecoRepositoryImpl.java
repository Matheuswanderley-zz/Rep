package br.com.alugueAgora.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.ImovelCaracteristica;
import br.com.alugueAgora.domain.ImovelEndereco;
import br.com.alugueAgora.dto.ImovelEnderecoDTO;

@Transactional
@Repository
public class ImovelEnderecoRepositoryImpl implements ImovelEnderecoRepository {
	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<ImovelEndereco> listAll() {
		try {
			String hql = "FROM imovelEndereco as im ORDER BY im.codigoImovelEndereco";
			return (List<ImovelEndereco>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o listAll. MSG ORIGINAL: " + e.getMessage());
			return null;
		}

	}

	@Override
	public ImovelEndereco getById(Long id) {
		try {
			return entityManager.find(ImovelEndereco.class, id);
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
	public ImovelEndereco save(ImovelEndereco imEndereco) {

		try {
			ImovelEndereco novoImEndereco = new ImovelEndereco();
			novoImEndereco.setBairro(imEndereco.getBairro());
			novoImEndereco.setCep(imEndereco.getCep());
			novoImEndereco.setTipoEndereco(imEndereco.getTipoEndereco());
			novoImEndereco.setCidade(imEndereco.getCidade());
			novoImEndereco.setNumero(imEndereco.getNumero());
			novoImEndereco.setComplemento(imEndereco.getComplemento());
			novoImEndereco.setEstado(imEndereco.getEstado());
			novoImEndereco.setLogradouro(imEndereco.getLogradouro());
			novoImEndereco.setTipologradouro(imEndereco.getTipologradouro());
			novoImEndereco.setPais(imEndereco.getPais());
			novoImEndereco.setRegiao(imEndereco.getRegiao());
			novoImEndereco.setImovel(imEndereco.getImovel());
			entityManager.persist(novoImEndereco);
			entityManager.flush();
			return novoImEndereco;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o save. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public ImovelEndereco update(ImovelEndereco imEndereco) {
		try {
			ImovelEndereco novoImEndereco = getById(imEndereco.getCodigoEndereco());
			novoImEndereco.setBairro(imEndereco.getBairro());
			novoImEndereco.setCep(imEndereco.getCep());
			novoImEndereco.setCidade(imEndereco.getCidade());
			novoImEndereco.setNumero(imEndereco.getNumero());
			novoImEndereco.setComplemento(imEndereco.getComplemento());
			novoImEndereco.setEstado(imEndereco.getEstado());
			novoImEndereco.setLogradouro(imEndereco.getLogradouro());
			novoImEndereco.setTipologradouro(imEndereco.getTipologradouro());
			novoImEndereco.setPais(imEndereco.getPais());
			novoImEndereco.setRegiao(imEndereco.getRegiao());

			entityManager.merge(novoImEndereco);
			entityManager.flush();
			return novoImEndereco;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o update. MSG ORIGINAL: " + e.getMessage());
			return null;
		}

	}

	@Override
	public ImovelEndereco saveList(List<ImovelEndereco> enderecos) {
		for (ImovelEndereco edt : enderecos) {
			save(edt);
		}
		return null;
	}

	@Override
	public List<ImovelEndereco> getAllByImovel(Long codigoImovel) {
		try {
			Query query = entityManager.createQuery("FROM ImovelEndereco ie WHERE ie.imovel = :codigoImovel");
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
			Query query = entityManager.createQuery("DELETE FROM ImovelEndereco ie WHERE ie.imovel = :codigoImovel");
			query.setParameter("codigoImovel", codigoImovel);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o deleteByImovel. MSG ORIGINAL: " + e.getMessage());
		}
	}

	@Override
	public void updateList(List<ImovelEndereco> imovelEnderecos) {
		for (ImovelEndereco ip : imovelEnderecos) {
			update(ip);
		}
	}

}
