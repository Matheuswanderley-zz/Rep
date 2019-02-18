package br.com.alugueAgora.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import br.com.alugueAgora.config.SpringMongoConfig;
import br.com.alugueAgora.converts.LocalizacaoConvert;
import br.com.alugueAgora.domain.Localizacao;
import br.com.alugueAgora.dto.LocalizacaoDTO;
import br.com.alugueAgora.mongodb.repository.LocalizacaoRepository;
import br.com.alugueAgora.services.LocalizacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("localizacao")
@Api(tags = "Localizacao", value = "alugueAgora", description = "Operações dos serviços de Localizacao")
public class LocalizacaoController {
	
	@Autowired
	private LocalizacaoConvert localizacaoConvert;
	@Autowired
	private LocalizacaoService localizacaoService;
	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	@Autowired
	private SpringMongoConfig springMongoConfig;
		
	@ApiOperation(value = "Procure uma localidade pelo CEP - Mongo",response = LocalizacaoDTO.class)
    @RequestMapping(
    		value = "/mongo/cep/{cep}", 
    		method= RequestMethod.GET, 
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<LocalizacaoDTO> showLocalizacaoByCEP(@PathVariable String cep){
		try {
			LocalizacaoDTO localizacaoDTO = localizacaoConvert.convertEntityToDTO(localizacaoRepository.findByCep(cep));
			return new ResponseEntity<LocalizacaoDTO>(localizacaoDTO, HttpStatus.CREATED);
		} catch (Exception e) {
	    	System.out.println("Error no Método showLocalizacaoByCEP."+e.getCause());
			return new ResponseEntity<LocalizacaoDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
		
	@ApiOperation(value = "Procure uma localidade pela descricao da localizacao - Mongo",response = LocalizacaoDTO.class)
    @RequestMapping(
    		value = "/mongo/descricao/{descricao}", 
    		method= RequestMethod.GET, 
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<LocalizacaoDTO>> showLocalizacaoByDescricao(@PathVariable String descricao){
		try {
			
			DBCollection collection = springMongoConfig.mongo().getDB("alugueAgoraDB").getCollection("localizacao");
		  	 
		  	DBObject ref = new BasicDBObject();
		  	ref.put("descricaoLocalizacao", Pattern.compile(".*"+descricao+".*" , Pattern.CASE_INSENSITIVE));
		  	DBCursor cursor = collection.find(ref);
		  	 		  	 
		  	 Gson gson = new Gson(); // Or use new GsonBuilder().create();
		  	 Localizacao localizacao = null;
		     List<LocalizacaoDTO> listaLocalizacoesDTO = new ArrayList<>();
		     LocalizacaoDTO dto = null;
		     while (cursor.hasNext()) {
		  		localizacao = gson.fromJson(cursor.next().toString(), Localizacao.class); // deserializes json into target2
		  		dto = new LocalizacaoDTO();
				dto = localizacaoConvert.convertEntityToDTO(localizacao);
				listaLocalizacoesDTO.add(dto);
		  	  }
	        return new ResponseEntity<List<LocalizacaoDTO>>(listaLocalizacoesDTO, HttpStatus.CREATED);
		} catch (Exception e) {
	    	System.out.println("Error no Método showLocalizacaoByCEP."+e.getCause());
	    	return new ResponseEntity<List<LocalizacaoDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Procure uma localidade pelo CEP - Oracle.",response = LocalizacaoDTO.class)
    @RequestMapping(
    		value = "/oracle/cep/{cep}", 
    		method= RequestMethod.GET, 
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<LocalizacaoDTO> showLocalizacaoByCEPOracle(@PathVariable String cep){
		try {
			LocalizacaoDTO localizacaoDTO =  localizacaoConvert.convertEntityToDTO(localizacaoService.getByCep(cep));
			return new ResponseEntity<LocalizacaoDTO>(localizacaoDTO, HttpStatus.CREATED);
		} catch (Exception e) {
	    	System.out.println("Error no Método showLocalizacaoByCEP."+e.getCause());
			return new ResponseEntity<LocalizacaoDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Procure uma localidade pela descricao da localizacao - Oracle.",response = LocalizacaoDTO.class)
    @RequestMapping(
    		value = "/oracle/descricao/{descricao}", 
    		method= RequestMethod.GET, 
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<LocalizacaoDTO>> showLocalizacaoByDescricaoOracle(@PathVariable String descricao){
		try {

			List<Localizacao> localizacoes = (List<Localizacao>) localizacaoService.getByDescricao(descricao);
			List<LocalizacaoDTO> listaLocalizacoesDTO = new ArrayList<>();
			for(Localizacao localizacao : localizacoes) {
				LocalizacaoDTO dto = new LocalizacaoDTO();
				dto = localizacaoConvert.convertEntityToDTO(localizacao);
				listaLocalizacoesDTO.add(dto);
			}
			
	        return new ResponseEntity<List<LocalizacaoDTO>>(listaLocalizacoesDTO, HttpStatus.CREATED);
		} catch (Exception e) {
	    	System.out.println("Error no Método showLocalizacaoByCEP."+e.getCause());
	    	return new ResponseEntity<List<LocalizacaoDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}