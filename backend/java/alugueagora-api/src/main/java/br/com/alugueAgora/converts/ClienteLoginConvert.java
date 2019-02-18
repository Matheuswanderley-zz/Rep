package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.ClienteLogin;
import br.com.alugueAgora.domain.ClienteLoginPK;
import br.com.alugueAgora.dto.AcessoDTO;
import br.com.alugueAgora.dto.ClienteDTO;
import br.com.alugueAgora.dto.ClienteLoginDTO;
import br.com.alugueAgora.dto.LoginDTO;

@Component
public class ClienteLoginConvert {

	@Autowired
	AcessoConvert acessoConvert;
	@Autowired
	LoginConvert loginConvert;
	@Autowired
	ClienteConvert clienteConvert;
	
	/**
	 * Metodo para converter um DTO em uma Entidade, no dominio deve ser passado
	 * update ou save para que haja uma validação dos dados que serao setados na
	 * entidade para serem persistidos na base.
	 * 
	 * @param dto
	 * @param dominio
	 * @return ClienteLogin
	 */
	public ClienteLogin convertDTOtoEntity(ClienteLoginDTO dto, String dominio) {
		
		ClienteLoginPK pk = new ClienteLoginPK();
		ClienteLogin clienteLogin = new ClienteLogin();
		clienteLogin.setPk(pk);
		
		AcessoDTO acesso = new AcessoDTO();
		LoginDTO login = new LoginDTO();
		ClienteDTO cliente = new ClienteDTO();
		
		if(dto.getAcesso() != null) {
			acesso = dto.getAcesso();
		}else if(dto.getLogin()!= null) {
			login = dto.getLogin();
		}else if(dto.getCliente()!= null) {
			cliente = dto.getCliente();
		}
		
		dto.getAcesso();
		if("SAVE".equalsIgnoreCase(dominio)) {
			clienteLogin.getPk().setCodigoAcesso(acessoConvert.convertDTOtoEntity(acesso,dominio));
			clienteLogin.getPk().setCodigoLogin(loginConvert.convertDTOtoEntity(login,dominio));
			clienteLogin.setCodigoCliente(clienteConvert.convertDtoToEntity(cliente,dominio));
		}else {
			clienteLogin.getPk().setCodigoAcesso(acessoConvert.convertDTOtoEntity(acesso,dominio));
			clienteLogin.getPk().setCodigoLogin(loginConvert.convertDTOtoEntity(login,dominio));
			clienteLogin.setCodigoCliente(clienteConvert.convertDtoToEntity(cliente,dominio));
		}

		return clienteLogin;
	}

	public ClienteLoginDTO convertEntityToDTO(ClienteLogin clienteLogin) {
		ClienteLoginDTO dto = new ClienteLoginDTO();
		dto.setAcesso(acessoConvert.convertEntityToDTO(clienteLogin.getPk().getCodigoAcesso()));
		dto.setLogin(loginConvert.convertEntityToDTO(clienteLogin.getPk().getCodigoLogin()));
		dto.setCliente(clienteConvert.convertEntityToDTO(clienteLogin.getCodigoCliente()));
		return dto;
	}

	public List<ClienteLogin> convertListaDTOtoListaEntity(List<ClienteLoginDTO> dto, String dominio) {
		List<ClienteLogin> lista = new ArrayList<>();
		for(ClienteLoginDTO imDto : dto) {
			lista.add(convertDTOtoEntity(imDto, dominio));	
		}
		return lista; 
	}
	
	public List<ClienteLoginDTO> convertListaEntityToListaDTO(List<ClienteLogin> clienteLogins) {
		List<ClienteLoginDTO> lista = new ArrayList<>();
		for(ClienteLogin im : clienteLogins) {
			lista.add(convertEntityToDTO(im));	
		}
		return lista; 
	}
}
