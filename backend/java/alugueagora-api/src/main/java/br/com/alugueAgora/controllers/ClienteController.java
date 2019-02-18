package br.com.alugueAgora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alugueAgora.converts.ClienteConvert;
import br.com.alugueAgora.converts.ClienteLoginConvert;
import br.com.alugueAgora.converts.LoginConvert;
import br.com.alugueAgora.domain.Cliente;
import br.com.alugueAgora.domain.ClienteLogin;
import br.com.alugueAgora.dto.ClienteDTO;
import br.com.alugueAgora.services.ClienteLoginService;
import br.com.alugueAgora.services.ClienteService;
import br.com.alugueAgora.transactions.ApiResponse;
import br.com.alugueAgora.transactions.Data;
import br.com.alugueAgora.utils.Constantes;
import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "Cliente", value = "alugueAgora", description = "Serviços da API de Cliente")
@RequestMapping(value = "/api/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

	private ClienteService clienteService;
	private ClienteConvert convertCliente;
	private ClienteLoginService cliLogService;
	private ClienteLoginConvert convertClienteLogin;

	@Autowired
	public ClienteController(ClienteService clienteService, ClienteConvert convertCliente,ClienteLoginService cliLogService,ClienteLoginConvert convertClienteLogin) {
		this.clienteService = clienteService;
		this.convertCliente = convertCliente;
		this.cliLogService = cliLogService;
		this.convertClienteLogin = convertClienteLogin;
	}

	@GetMapping("/{transactionId}/{version}")
	public Data<ClienteDTO> get(@PathVariable String transactionId, @PathVariable String version) {
		Data<ClienteDTO> data = new Data<ClienteDTO>();
		List<ClienteDTO> lista = convertCliente.convertListEntityToListDTO(clienteService.listAll());
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}

	@GetMapping("/{transactionId}/{version}/{id}")
	public Data<ClienteDTO> get(@PathVariable String transactionId, @PathVariable String version, @PathVariable Long id) {
		ClienteDTO cliente = convertCliente.convertEntityToDTO(clienteService.getById(id));
		Data<ClienteDTO> data = new Data<ClienteDTO>();
		List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		lista.add(cliente);
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}

	@PostMapping
	public Data<ApiResponse> post(@RequestBody Data<ClienteDTO> dto) {
		Cliente cliente = clienteService.save(convertCliente.convertDtoToEntity(dto.getData().get(0), "SAVE"));
		
		ClienteLogin cliLog = cliLogService.getByPK(dto.getData().get(0).getCodigoClienteLogin(), Constantes.USUARIO);
		cliLog.setCodigoCliente(cliente);
		cliLogService.update(cliLog);
		
		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(cliente.getCodigoCliente());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setData(apiResponse);
		return data;
	}

	@PutMapping
	public Data<ApiResponse> put(@RequestBody Data<ClienteDTO> dto) {
		Cliente cliente = clienteService.update(convertCliente.convertDtoToEntity((dto.getData().get(0)), "UPDATE"));
		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(cliente.getCodigoCliente());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setData(apiResponse);
		return data;
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<ClienteDTO> delete(@PathVariable("id") final Long id) {
		clienteService.delete(id);
		return new ResponseEntity<ClienteDTO>(HttpStatus.NO_CONTENT);
	}
}
