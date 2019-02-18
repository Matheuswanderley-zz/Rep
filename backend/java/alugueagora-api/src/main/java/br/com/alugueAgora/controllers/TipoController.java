package br.com.alugueAgora.controllers;

import java.util.ArrayList;
import java.util.List;

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

import br.com.alugueAgora.converts.TipoConvert;
import br.com.alugueAgora.domain.Tipo;
import br.com.alugueAgora.dto.AreaComumDTO;
import br.com.alugueAgora.dto.TipoDTO;
import br.com.alugueAgora.repositories.TipoRepository;
import br.com.alugueAgora.transactions.ApiResponse;
import br.com.alugueAgora.transactions.Data;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "Tipo", value = "alugueAgora", description = "Serviços da API de Tipo")
@RequestMapping(value = "/api/tipo", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoController {

	private TipoConvert convert;
	private TipoRepository tipoRepository;

	@Autowired
	public TipoController(TipoConvert convert, TipoRepository tipoRepository) {
		this.tipoRepository = tipoRepository;
		this.convert = convert;
	}

	@GetMapping("/{transactionId}/{version}")
	public Data<TipoDTO> get(@PathVariable String transactionId, @PathVariable String version) {
		Data<TipoDTO> data = new Data<TipoDTO>();
		List<TipoDTO> lista = convert.convertEntityToDTO(tipoRepository.listAll());
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}

	@GetMapping("/{transactionId}/{version}/{id}")
	public Data<TipoDTO> get(@PathVariable String transactionId, @PathVariable String version, @PathVariable Long id)
			throws Exception {
		TipoDTO tip = convert.convertEntityToDTO(tipoRepository.getById(id));
		Data<TipoDTO> data = new Data<TipoDTO>();
		List<TipoDTO> lista = new ArrayList<TipoDTO>();
		lista.add(tip);
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}

	@PostMapping
	public Data<ApiResponse> post(@RequestBody final Tipo tipo) {
		TipoDTO dto = convert.convertEntityToDTO(tipoRepository.save(tipo));
		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(dto.getCodigoTipo());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setTransactionId(dto.getTransactionId());
		data.setVersion(dto.getVersion());
		data.setData(apiResponse);
		return data;
	}

	@PutMapping("/{id}")
	public Data<ApiResponse> put(@PathVariable("id") final long id, @RequestBody Tipo tipo) {
		TipoDTO dto = convert.convertEntityToDTO(tipoRepository.save(tipo));
		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(dto.getCodigoTipo());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setTransactionId(dto.getTransactionId());
		data.setVersion(dto.getVersion());
		data.setData(apiResponse);
		return data;
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<TipoDTO> delete(@PathVariable("id") final Long id) {
		tipoRepository.delete(id);
		return new ResponseEntity<TipoDTO>(HttpStatus.NO_CONTENT);
	}
}
