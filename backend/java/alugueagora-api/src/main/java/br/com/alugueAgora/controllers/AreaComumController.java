package br.com.alugueAgora.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alugueAgora.converts.AreaComumConvert;
import br.com.alugueAgora.dto.AreaComumDTO;
import br.com.alugueAgora.repositories.AreaComumRepository;
import br.com.alugueAgora.transactions.ApiResponse;
import br.com.alugueAgora.transactions.Data;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "AreaComum", value = "alugueAgora", description = "Serviços da API de Area Comum")
@RequestMapping(value = "/api/areaComum",  produces = MediaType.APPLICATION_JSON_VALUE)
public class AreaComumController {
	
	private AreaComumConvert convert;
	private AreaComumRepository areaComumRepository;

	@Autowired
	public AreaComumController(AreaComumRepository AreaComumsRepository,AreaComumConvert convert) {
		this.areaComumRepository = AreaComumsRepository;
		this.convert = convert;
	}
	
	@PreAuthorize("hasAuthority('USUARIO')")
	@GetMapping("/{transactionId}/{version}")
	public Data<AreaComumDTO> get(@PathVariable String transactionId,@PathVariable String version) {
		Data<AreaComumDTO> data = new Data<AreaComumDTO>();
		List<AreaComumDTO> lista = convert.convertEntityToDTO(areaComumRepository.listAll());
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}

	@GetMapping("/{transactionId}/{version}/{id}")
	public Data<AreaComumDTO> get(@PathVariable String transactionId,@PathVariable String version,@PathVariable Long id) throws Exception{
		AreaComumDTO dto = convert.convertEntityToDTO(areaComumRepository.getById(id));
		Data<AreaComumDTO> data = new Data<AreaComumDTO>();
		List<AreaComumDTO> lista = new ArrayList<AreaComumDTO>();
		lista.add(dto);
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}

	@PostMapping
	public Data<ApiResponse> post(@RequestBody final Data<AreaComumDTO> dto) {
		AreaComumDTO acomum = convert.convertEntityToDTO(areaComumRepository.save(convert.convertDTOtoEntity(dto.getData().get(0),"SAVE")));
		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(acomum.getCodigoAreaComum());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setTransactionId(dto.getTransactionId());
		data.setVersion(dto.getVersion());
		data.setData(apiResponse);
		return data;
	}

	@PutMapping
	public Data<ApiResponse> put(@RequestBody final Data<AreaComumDTO> dto) {
		AreaComumDTO acomum = convert.convertEntityToDTO(areaComumRepository.save(convert.convertDTOtoEntity(dto.getData().get(0),"UPDATE")));
		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(acomum.getCodigoAreaComum());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setTransactionId(dto.getTransactionId());
		data.setVersion(dto.getVersion());
		data.setData(apiResponse);
		return data;
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<AreaComumDTO> delete(@PathVariable("id") final Long id) {
		areaComumRepository.delete(id);
		return new ResponseEntity<AreaComumDTO>(HttpStatus.NO_CONTENT);
	}
}
