package br.com.alugueAgora.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.alugueAgora.converts.NegocioConvert;
import br.com.alugueAgora.domain.Negocio;
import br.com.alugueAgora.dto.AreaComumDTO;
import br.com.alugueAgora.dto.CaracteristicasDTO;
import br.com.alugueAgora.dto.ImovelDTO;
import br.com.alugueAgora.dto.NegocioDTO;
import br.com.alugueAgora.repositories.NegocioRepository;
import br.com.alugueAgora.transactions.ApiRequest;
import br.com.alugueAgora.transactions.ApiResponse;
import br.com.alugueAgora.transactions.Data;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "Negocio", value = "alugueAgora", description = "Serviços da API de Negocio")
@RequestMapping(value = "/api/negocio", produces = MediaType.APPLICATION_JSON_VALUE)
public class NegocioController {

	private NegocioConvert convert;
	private NegocioRepository negocioRepository;

	@Autowired
	public NegocioController(NegocioConvert convert, NegocioRepository negocioRepository) {
		this.negocioRepository = negocioRepository;
		this.convert = convert;
	}

	@GetMapping("/{transactionId}/{version}")
	public Data<NegocioDTO> get(@PathVariable String transactionId, @PathVariable String version) {
		Data<NegocioDTO> data = new Data<NegocioDTO>();
		List<NegocioDTO> lista = convert.convertEntityToDTO(negocioRepository.listAll());
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}

	@GetMapping("/{transactionId}/{version}/{id}")
	public Data<NegocioDTO> get(@PathVariable String transactionId, @PathVariable String version, @PathVariable Long id)
			throws Exception {
		NegocioDTO dto = convert.convertEntityToDTO(negocioRepository.getById(id));
		Data<NegocioDTO> data = new Data<NegocioDTO>();
		List<NegocioDTO> lista = new ArrayList<NegocioDTO>();
		lista.add(dto);
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}

	@PostMapping
	public Data<ApiResponse> post(HttpServletRequest header, @RequestBody Data<Negocio> negocio) {
		NegocioDTO dto = convert.convertEntityToDTO(negocioRepository.save(negocio.getData().get(0)));
		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(dto.getCodigoNegocio());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setTransactionId(dto.getTransactionId());
		data.setVersion(dto.getVersion());
		data.setData(apiResponse);
		return data;
	}

	@PutMapping
	public Data<ApiResponse> put(HttpServletRequest header, @RequestBody Data<Negocio> negocio) {
		NegocioDTO dto = convert.convertEntityToDTO(negocioRepository.update(negocio.getData().get(0)));
		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(dto.getCodigoNegocio());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setTransactionId(dto.getTransactionId());
		data.setVersion(dto.getVersion());
		data.setData(apiResponse);
		return data;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<NegocioDTO> delete(HttpServletRequest header, @RequestBody ApiRequest request,
			@PathVariable("id") final Long id) {
		negocioRepository.delete(id);
		return new ResponseEntity<NegocioDTO>(HttpStatus.NO_CONTENT);
	}
}
