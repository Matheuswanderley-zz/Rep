package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Cliente;
import br.com.alugueAgora.domain.ClienteLogin;
import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.dto.ClienteDTO;
import br.com.alugueAgora.services.ClienteLoginService;
import br.com.alugueAgora.services.ImovelService;
import br.com.alugueAgora.utils.Constantes;

@Component
public class ClienteConvert {

	@Autowired
	private ImovelConvert imovelConvert;
	@Autowired
	private ClienteLoginConvert clienteLoginConvert;
	@Autowired
	private ImovelService imovelServices;
	@Autowired
	private ClienteLoginService clienteLoginService;

	public List<Cliente> convertListDTOToListEntity(List<ClienteDTO> clientesDTO, String dominio) {

		List<Cliente> clientes = new ArrayList<>();

		for (ClienteDTO dto : clientesDTO) {
			clientes.add(convertDtoToEntity(dto, dominio));
		}
		return clientes;
	}

	public List<ClienteDTO> convertListEntityToListDTO(List<Cliente> clientes) {
		List<ClienteDTO> lista = new ArrayList<>();
		for (Cliente cliente : clientes) {
			lista.add(convertEntityToDTO(cliente));
		}
		return lista;
	}

	public ClienteDTO convertEntityToDTO(Cliente cliente) {
		ClienteDTO novoCliente = new ClienteDTO();
		novoCliente.setCodigoCliente(cliente.getCodigoCliente());
		novoCliente.setAvaliacao(cliente.getAvaliacao());
		novoCliente.setBairro(cliente.getBairro());
		novoCliente.setCep(cliente.getCep());
		novoCliente.setCidade(cliente.getCidade());
		novoCliente.setComplemento(cliente.getComplemento());
		novoCliente.setEmail(cliente.getEmail());
		novoCliente.setEstado(cliente.getEstado());
		novoCliente.setLogradouro(cliente.getLogradouro());
		novoCliente.setNomeCliente(cliente.getNomeCliente());
		novoCliente.setNumero(cliente.getNumero());
		novoCliente.setPais(cliente.getPais());
		novoCliente.setRegiao(cliente.getRegiao());
		novoCliente.setSobrenomeCliente(cliente.getSobrenomeCliente());
		novoCliente.setTelefone(cliente.getTelefone());
		novoCliente.setTipoLogradouro(cliente.getTipoLogradouro());
		return novoCliente;
	}

	public Cliente convertDtoToEntity(ClienteDTO dto, String dominio) {
		Cliente novoCliente = new Cliente();

		Imovel imovel = new Imovel();
		List<Imovel> imoveis = new ArrayList<>();
		imovel = imovelServices.getById(dto.getCodigoImovel());
		imoveis.add(imovel);

		ClienteLogin clienteLogin = new ClienteLogin();
		clienteLogin = clienteLoginService.getByPK(dto.getCodigoClienteLogin(),Constantes.USUARIO);
		
		if ("UPDATE".equalsIgnoreCase(dominio)) {
			novoCliente.setCodigoCliente(dto.getCodigoCliente());
			novoCliente.setAvaliacao(dto.getAvaliacao());
			novoCliente.setBairro(dto.getBairro());
			novoCliente.setCep(dto.getCep());
			novoCliente.setCidade(dto.getCidade());
			novoCliente.setComplemento(dto.getComplemento());
			novoCliente.setEmail(dto.getEmail());
			novoCliente.setEstado(dto.getEstado());
			novoCliente.setLogradouro(dto.getLogradouro());
			novoCliente.setNomeCliente(dto.getNomeCliente());
			novoCliente.setNumero(dto.getNumero());
			novoCliente.setPais(dto.getPais());
			novoCliente.setRegiao(dto.getRegiao());
			novoCliente.setSobrenomeCliente(dto.getSobrenomeCliente());
			novoCliente.setTelefone(dto.getTelefone());
			novoCliente.setTipoLogradouro(dto.getTipoLogradouro());
		} else {
			novoCliente.setAvaliacao(dto.getAvaliacao());
			novoCliente.setBairro(dto.getBairro());
			novoCliente.setCep(dto.getCep());
			novoCliente.setCidade(dto.getCidade());
			novoCliente.setComplemento(dto.getComplemento());
			novoCliente.setEmail(dto.getEmail());
			novoCliente.setEstado(dto.getEstado());
			novoCliente.setLogradouro(dto.getLogradouro());
			novoCliente.setNomeCliente(dto.getNomeCliente());
			novoCliente.setNumero(dto.getNumero());
			novoCliente.setPais(dto.getPais());
			novoCliente.setRegiao(dto.getRegiao());
			novoCliente.setSobrenomeCliente(dto.getSobrenomeCliente());
			novoCliente.setTelefone(dto.getTelefone());
			novoCliente.setTipoLogradouro(dto.getTipoLogradouro());
			novoCliente.setClienteLogin(clienteLogin);
			novoCliente.setImoveis(imoveis);
		}

		return novoCliente;
	}

}
