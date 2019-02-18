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
import br.com.alugueAgora.domain.ImovelNegocio;
import br.com.alugueAgora.domain.ImovelTipo;

@Transactional
@Repository
public class ImovelRepositoryImpl implements ImovelRepository {
	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Imovel> listAll() {
		try {
			return (List<Imovel>) entityManager.createNamedQuery("Imovel.listAll").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o listAll. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Imovel getById(Long id) {
		try {
			return entityManager.find(Imovel.class, id);
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
	public Imovel save(Imovel imovel) {

		try {
			Imovel novoImovel = new Imovel();
			novoImovel.setAnuncio(imovel.getAnuncio());
			novoImovel.setAnuncioDestaque(imovel.getAnuncioDestaque());
			novoImovel.setAreaImovel(imovel.getAreaImovel());
			novoImovel.setCelular(imovel.getCelular());
			novoImovel.setDataRegistro(imovel.getDataRegistro());
			novoImovel.setDescricaoImovel(imovel.getDescricaoImovel());
			novoImovel.setTituloImovel(imovel.getTituloImovel());
			novoImovel.setDisponibilidade(imovel.getDisponibilidade());
			novoImovel.setEmail(imovel.getEmail());
			novoImovel.setEnvioPlaca(imovel.getEnvioPlaca());
			novoImovel.setImovelPlaca(imovel.getImovelPlaca());
			novoImovel.setImovelNegocio(imovel.getImovelNegocio());
			novoImovel.setImovelTipo(imovel.getImovelTipo());
			entityManager.persist(novoImovel);
			entityManager.flush();
			return novoImovel;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o save. MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Imovel update(Imovel imovel) {
		try {
			Imovel novoImovel = getById(imovel.getCodigoImovel());
			novoImovel.setAnuncioDestaque(imovel.getAnuncioDestaque());
			novoImovel.setAreaImovel(imovel.getAreaImovel());
			novoImovel.setCelular(imovel.getCelular());
			novoImovel.setDataRegistro(imovel.getDataRegistro());
			novoImovel.setDescricaoImovel(imovel.getDescricaoImovel());
			novoImovel.setTituloImovel(imovel.getTituloImovel());
			novoImovel.setDisponibilidade(imovel.getDisponibilidade());
			novoImovel.setEmail(imovel.getEmail());
			novoImovel.setEnvioPlaca(imovel.getEnvioPlaca());
			novoImovel.setImovelPlaca(imovel.getImovelPlaca());
			novoImovel.setImovelNegocio(imovel.getImovelNegocio());
			novoImovel.setImovelTipo(imovel.getImovelTipo());
			entityManager.merge(novoImovel);
			entityManager.flush();
			return novoImovel;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o update. MSG ORIGINAL: " + e.getMessage());
			return null;
		}

	}

	@Override
	public List<Imovel> findBy(Long tipo, Long negocio, Long quantidadeBanheiros, Long quantidadeDormitorios,
			Long quantidadeSuites, Long quantidadeGaragem) {
		try {
			
			ImovelTipo imovelTipo = null;
			if (tipo != null) {
				imovelTipo = new ImovelTipo();
				imovelTipo.setCodigoImovelTipo(tipo);
			}
			
			ImovelNegocio imovelNegocio = null;
			if (negocio != null) {
				imovelNegocio = new ImovelNegocio();
				imovelNegocio.setCodigoImovelNegocio(negocio);
			}
			
			Query query = entityManager.createNamedQuery("Imovel.findBy")
					.setParameter("imovelTipo", imovelTipo)
					.setParameter("imovelNegocio", imovelNegocio)
					.setParameter("quantidadeBanheiros", quantidadeBanheiros)
					.setParameter("quantidadeDormitorios", quantidadeDormitorios)
					.setParameter("quantidadeSuites", quantidadeSuites)
					.setParameter("quantidadeGaragem", quantidadeGaragem)
					;
			
			return (List<Imovel>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o findBy(Long tipo, Finalidade finalidade, Long quantidadeBanheiros, Long quantidadeDormitorios, Long quantidadeSuites, Long quantidadeGaragem). MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

}
