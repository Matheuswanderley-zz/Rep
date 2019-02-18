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

import br.com.alugueAgora.converts.CaracteristicasConvert;
import br.com.alugueAgora.domain.Caracteristica;
import br.com.alugueAgora.dto.AreaComumDTO;
import br.com.alugueAgora.dto.CaracteristicasDTO;
import br.com.alugueAgora.repositories.CaracteristicasRepository;
import br.com.alugueAgora.transactions.ApiResponse;
import br.com.alugueAgora.transactions.Data;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "Caracteristica", value = "alugueAgora", description = "Serviços da API de Caracteristica")
@RequestMapping(value = "/api/caracteristica", produces = MediaType.APPLICATION_JSON_VALUE)
public class CaracteristicasController {

	private CaracteristicasConvert convert;
	private CaracteristicasRepository caracteristicasRepository;

	@Autowired
	public CaracteristicasController(CaracteristicasConvert convert,
			CaracteristicasRepository caracteristicasRepository) {
		this.caracteristicasRepository = caracteristicasRepository;
		this.convert = convert;
	}

	@GetMapping("/{transactionId}/{version}")
	public Data<CaracteristicasDTO> get(@PathVariable String transactionId, @PathVariable String version) {
		Data<CaracteristicasDTO> data = new Data<CaracteristicasDTO>();
		List<CaracteristicasDTO> lista = convert.convertEntityToDTO(caracteristicasRepository.listAll());
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}

	@GetMapping("/{transactionId}/{version}/{id}")
	public Data<CaracteristicasDTO> get(@PathVariable String transactionId, @PathVariable String version,
			@PathVariable Long id) throws Exception {
		CaracteristicasDTO carac = convert.convertEntityToDTO(caracteristicasRepository.getById(id));
		Data<CaracteristicasDTO> data = new Data<CaracteristicasDTO>();
		List<CaracteristicasDTO> lista = new ArrayList<CaracteristicasDTO>();
		lista.add(carac);
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}

	@PostMapping
	public Data<ApiResponse> post(@RequestBody final Caracteristica caracteristicas) {
		CaracteristicasDTO dto = convert.convertEntityToDTO(caracteristicasRepository.save(caracteristicas));
		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(dto.getCodigoCaracteristicas());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setTransactionId(dto.getTransactionId());
		data.setVersion(dto.getVersion());
		data.setData(apiResponse);
		return data;
	}

	@PutMapping("/{id}")
	public Data<ApiResponse> put(@PathVariable("id") final long id, @RequestBody Caracteristica caracteristicas) {
		CaracteristicasDTO dto = convert.convertEntityToDTO(caracteristicasRepository.save(caracteristicas));
		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(dto.getCodigoCaracteristicas());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setTransactionId(dto.getTransactionId());
		data.setVersion(dto.getVersion());
		data.setData(apiResponse);
		return data;
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<CaracteristicasDTO> delete(@PathVariable("id") final Long id) {
		caracteristicasRepository.delete(id);
		return new ResponseEntity<CaracteristicasDTO>(HttpStatus.NO_CONTENT);
	}
}
