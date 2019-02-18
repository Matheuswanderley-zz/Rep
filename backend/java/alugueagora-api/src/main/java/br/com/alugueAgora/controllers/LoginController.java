package br.com.alugueAgora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alugueAgora.converts.LoginConvert;
import br.com.alugueAgora.domain.Login;
import br.com.alugueAgora.dto.LoginDTO;
import br.com.alugueAgora.services.LoginService;
import br.com.alugueAgora.transactions.ApiResponse;
import br.com.alugueAgora.transactions.Data;
import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "Login", value = "alugueAgora", description = "Serviços da API de Login")
@RequestMapping(value = "/api/login",produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {
	
    private LoginService loginService;
	private LoginConvert convert;
    
    @Autowired
    public LoginController(LoginService loginService,LoginConvert convert) {
    	this.loginService = loginService;
    	this.convert = convert;
    }

	@GetMapping("/{transactionId}/{version}")
	public Data<LoginDTO> get(@PathVariable String transactionId, @PathVariable String version) {
		Data<LoginDTO> data = new Data<LoginDTO>();
		List<LoginDTO> lista = convert.convertListEntityToListDTO(loginService.listAll());
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}

	@GetMapping("/{transactionId}/{version}/{email}")
	public Data<LoginDTO> getEmail(
									@PathVariable String transactionId, 
									@PathVariable String version,
									@PathVariable String email) throws Exception {
		LoginDTO login = convert.convertEntityToDTO(loginService.findByUsername(email));
		Data<LoginDTO> data = new Data<LoginDTO>();
		List<LoginDTO> lista = new ArrayList<LoginDTO>();
		lista.add(login);
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}
	
	@PostMapping
	public Data<ApiResponse> post(@RequestBody Data<LoginDTO> dto) throws Exception {
        
		if(!validaExisteUsuario(dto)) {
			throw new Exception(String.format("The username already exist", dto.getData().get(0).getUsername()));
		}
		
		Login login = loginService.save(encripitPassword(convert.convertDTOtoEntity(dto.getData().get(0),"SAVE")));
		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(login.getCodigoLogin());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setData(apiResponse);
		return data;
	}


	@PutMapping
	public Data<ApiResponse> put(@RequestBody Data<LoginDTO> dto) {
		Login login = loginService.update(encripitPassword(convert.convertDTOtoEntity(dto.getData().get(0),"UPDATE")));
		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(login.getCodigoLogin());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setData(apiResponse);
		return data;
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<LoginDTO> delete(@PathVariable("id") final Long id) {
		loginService.delete(id);
		return new ResponseEntity<LoginDTO>(HttpStatus.NO_CONTENT);
	}
    
	private Login encripitPassword(Login login) {
		String encoded = new BCryptPasswordEncoder().encode(login.getPassword());
		login.setPassword(encoded); 
		return login;
	}

	private Boolean validaExisteUsuario(Data<LoginDTO> dto){
		Login user = loginService.findByUsername(dto.getData().get(0).getUsername());
		if(user == null) {
			return false;
		}
		return true;
	}
}
