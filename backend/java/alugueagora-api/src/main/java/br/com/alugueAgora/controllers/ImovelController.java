package br.com.alugueAgora.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import br.com.alugueAgora.converts.ImovelAreaComumConvert;
import br.com.alugueAgora.converts.ImovelCaracteristicaConvert;
import br.com.alugueAgora.converts.ImovelConvert;
import br.com.alugueAgora.converts.ImovelEnderecoConvert;
import br.com.alugueAgora.converts.ImovelFotoConvert;
import br.com.alugueAgora.converts.ImovelPagamentoConvert;
import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.dto.ImovelDTO;
import br.com.alugueAgora.services.ImovelService;
import br.com.alugueAgora.transactions.ApiResponse;
import br.com.alugueAgora.transactions.Data;

@RestController
@Api(tags = "Imovel", value = "alugueAgora", description = "Serviços da API de Imovel")
@RequestMapping(value = "/api/imovel",produces = MediaType.APPLICATION_JSON_VALUE)
public class ImovelController {

	private ImovelConvert imovelConvert;
	private ImovelService imovelService;
	private ImovelEnderecoConvert imovelEnderecoConvert;
	private ImovelFotoConvert imovelFotoConvert;
	private ImovelPagamentoConvert imovelPagamentoConvert;
	private ImovelAreaComumConvert imovelAreaComumConvert;
	private ImovelCaracteristicaConvert imovelCaracteristicaConvert;

	@Autowired
	public ImovelController(ImovelService imovelService, ImovelConvert imovelConvert,
			ImovelEnderecoConvert imovelEnderecoConvert, ImovelFotoConvert imovelFotoConvert,
			ImovelPagamentoConvert imovelPagamentoConvert, ImovelAreaComumConvert imovelAreaComumConvert,
			ImovelCaracteristicaConvert imovelCaracteristicaConvert) {
		this.imovelService = imovelService;
		this.imovelConvert = imovelConvert;
		this.imovelEnderecoConvert = imovelEnderecoConvert;
		this.imovelFotoConvert = imovelFotoConvert;
		this.imovelPagamentoConvert = imovelPagamentoConvert;
		this.imovelAreaComumConvert = imovelAreaComumConvert;
		this.imovelCaracteristicaConvert = imovelCaracteristicaConvert;
	}

	@PreAuthorize("hasAuthority('ADMINISTRADOR')")
	@GetMapping("/{transactionId}/{version}")
	public Data<ImovelDTO> get(@PathVariable String transactionId,@PathVariable String version) throws Exception {
		Data<ImovelDTO> data = new Data<ImovelDTO>();
		List<ImovelDTO> dto = new ArrayList<>();
		List<Imovel> listaImovel = imovelService.listAll();
		if(listaImovel.isEmpty()) {
			throw new Exception("No content result!");
		}
		for (Imovel imovel : listaImovel) {
			dto.add(imovelConvert.convertEntityToDTO(imovel));
		}
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(dto);
		return data;
	}

	@GetMapping("/{transactionId}/{version}/{id}")
	public @ResponseBody Data<ImovelDTO> get(@PathVariable String transactionId,@PathVariable String version,@PathVariable Long id) throws Exception{
		Data<ImovelDTO> data = new Data<ImovelDTO>();
		Imovel imovel = imovelService.getById(id);
		if(null == imovel) {
			throw new Exception("No content result!");
		}
		ImovelDTO dto = imovelConvert.convertEntityToDTO(imovel);
		List<ImovelDTO> lista = new ArrayList<>();
		lista.add(dto);
		data.setTransactionId(transactionId);
		data.setVersion(version);
		data.setData(lista);
		return data;
	}

	@PostMapping
	public @ResponseBody Data<ApiResponse> post(@RequestBody Data<ImovelDTO> dto) throws Exception {

		Imovel imovel = imovelService.save(imovelConvert.convertDTOtoEntity(dto.getData().get(0), "SAVE"));
		imovel.setImovelFoto(
				imovelFotoConvert.convertDTOToEntity(dto.getData().get(0).getImovelFotos(), imovel, "SAVE"));
		imovel.setImovelEndereco(
				imovelEnderecoConvert.convertDTOToEntity(dto.getData().get(0).getImovelEnderecos(), imovel, "SAVE"));
		imovel.setImovelPagamento(
				imovelPagamentoConvert.convertDTOToEntity(dto.getData().get(0).getImovelPagamentos(), imovel, "SAVE"));
		imovel.setImovelAreaComum(
				imovelAreaComumConvert.convertDTOToEntity(dto.getData().get(0).getImovelAreaComum(), imovel, "SAVE"));
		imovel.setImovelCaracteristica(imovelCaracteristicaConvert
				.convertDTOToEntity(dto.getData().get(0).getImovelCaracteristicas(), imovel, "SAVE"));
		ImovelDTO imovelDto = imovelConvert.convertEntityToDTO(imovelService.update(imovel));

		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(imovelDto.getCodigoImovel());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setTransactionId(dto.getTransactionId());
		data.setVersion(dto.getVersion());
		data.setData(apiResponse);
		return data;
	}

	@PutMapping("/{id}")
	public @ResponseBody Data<ApiResponse> put(@RequestBody Data<ImovelDTO> dto) throws Exception {

		Imovel imovel = imovelService.update(imovelConvert.convertDTOtoEntity(dto.getData().get(0), "UPDATE"));
		imovel.setImovelFoto(
				imovelFotoConvert.convertDTOToEntity(dto.getData().get(0).getImovelFotos(), imovel, "UPDATE"));
		imovel.setImovelEndereco(
				imovelEnderecoConvert.convertDTOToEntity(dto.getData().get(0).getImovelEnderecos(), imovel, "UPDATE"));
		imovel.setImovelPagamento(imovelPagamentoConvert.convertDTOToEntity(dto.getData().get(0).getImovelPagamentos(),
				imovel, "UPDATE"));
		imovel.setImovelAreaComum(
				imovelAreaComumConvert.convertDTOToEntity(dto.getData().get(0).getImovelAreaComum(), imovel, "UPDATE"));
		imovel.setImovelCaracteristica(imovelCaracteristicaConvert
				.convertDTOToEntity(dto.getData().get(0).getImovelCaracteristicas(), imovel, "UPDATE"));
		ImovelDTO imovelDto = imovelConvert.convertEntityToDTO(imovelService.update(imovel));

		Data<ApiResponse> data = new Data<>();
		List<ApiResponse> apiResponse = new ArrayList<>();
		ApiResponse response = new ApiResponse();
		response.setId(imovelDto.getCodigoImovel());
		response.setMessagem("SUCESSO");
		apiResponse.add(response);
		data.setTransactionId(dto.getTransactionId());
		data.setVersion(dto.getVersion());
		data.setData(apiResponse);
		return data;
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<ImovelDTO> delete(@PathVariable Long id){
		imovelService.delete(id);
		return new ResponseEntity<ImovelDTO>(HttpStatus.NO_CONTENT);
	}

}