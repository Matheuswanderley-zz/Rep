package br.com.alugueAgora.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.alugueAgora.domain.Cliente;
import br.com.alugueAgora.domain.ClienteLogin;
import br.com.alugueAgora.domain.ClienteLoginPK;
import br.com.alugueAgora.domain.Imovel;

@Transactional
@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Cliente> listAll() {
		try {
			String hql = "FROM Cliente as im ORDER BY im.codigoCliente";
			return (List<Cliente>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o listAll cliente MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Cliente getById(Long id) {
		try {
			return entityManager.find(Cliente.class, id);
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
	public Cliente save(Cliente imCliente) {
		try {
			ClienteLoginPK pk = new ClienteLoginPK();
			ClienteLogin clienteLogin = new ClienteLogin();
			pk.setCodigoAcesso(imCliente.getClienteLogin().getPk().getCodigoAcesso());
			pk.setCodigoLogin(imCliente.getClienteLogin().getPk().getCodigoLogin());
			
			List<Imovel> imoveis = new ArrayList<>();
			imoveis = imCliente.getImoveis();
			
			Cliente novoCliente = new Cliente();
			novoCliente.setAvaliacao(imCliente.getAvaliacao());
			novoCliente.setBairro(imCliente.getBairro());
			novoCliente.setCep(imCliente.getCep());
			novoCliente.setCidade(imCliente.getCidade());
			novoCliente.setClienteLogin(clienteLogin);
			novoCliente.setComplemento(imCliente.getComplemento());
			novoCliente.setEmail(imCliente.getEmail());
			novoCliente.setEstado(imCliente.getEstado());
			novoCliente.setImoveis(imoveis);
			novoCliente.setLogradouro(imCliente.getLogradouro());
			novoCliente.setNomeCliente(imCliente.getNomeCliente());
			novoCliente.setNumero(imCliente.getNumero());
			novoCliente.setPais(imCliente.getPais());
			novoCliente.setRegiao(imCliente.getRegiao());
			novoCliente.setSobrenomeCliente(imCliente.getSobrenomeCliente());
			novoCliente.setTelefone(imCliente.getTelefone());
			novoCliente.setTipoLogradouro(imCliente.getTipoLogradouro());
			entityManager.persist(novoCliente);
			entityManager.flush();
			return novoCliente;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o save Cliente MSG ORIGINAL: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Cliente update(Cliente imCliente) {
		try {
			ClienteLogin clienteLogin = new ClienteLogin();
			clienteLogin = imCliente.getClienteLogin();
			
			List<Imovel> imoveis = new ArrayList<>();
			imoveis = imCliente.getImoveis();
			
			Cliente novoCliente = getById(imCliente.getCodigoCliente());
			novoCliente.setCodigoCliente(imCliente.getCodigoCliente());
			novoCliente.setAvaliacao(imCliente.getAvaliacao());
			novoCliente.setBairro(imCliente.getBairro());
			novoCliente.setCep(imCliente.getCep());
			novoCliente.setCidade(imCliente.getCidade());
			novoCliente.setClienteLogin(clienteLogin);
			novoCliente.setComplemento(imCliente.getComplemento());
			novoCliente.setEmail(imCliente.getEmail());
			novoCliente.setEstado(imCliente.getEstado());
			novoCliente.setImoveis(imoveis);
			novoCliente.setLogradouro(imCliente.getLogradouro());
			novoCliente.setNomeCliente(imCliente.getNomeCliente());
			novoCliente.setNumero(imCliente.getNumero());
			novoCliente.setPais(imCliente.getPais());
			novoCliente.setRegiao(imCliente.getRegiao());
			novoCliente.setSobrenomeCliente(imCliente.getSobrenomeCliente());
			novoCliente.setTelefone(imCliente.getTelefone());
			novoCliente.setTipoLogradouro(imCliente.getTipoLogradouro());
			entityManager.merge(novoCliente);
			entityManager.flush();
			return novoCliente;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro ao executar o update Cliente MSG ORIGINAL: " + e.getMessage());
			return null;

		}
	}
}
