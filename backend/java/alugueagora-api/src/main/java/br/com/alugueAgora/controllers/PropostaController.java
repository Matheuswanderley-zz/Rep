package br.com.alugueAgora.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alugueAgora.converts.PropostaConvert;
import br.com.alugueAgora.domain.Proposta;
import br.com.alugueAgora.dto.PropostaDTO;
import br.com.alugueAgora.enumerations.DominioConverter;
import br.com.alugueAgora.services.PropostaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("proposta")
@Api(tags = "Proposta", value = "alugueAgora", description = "Operações dos serviços de Proposta")
public class PropostaController {
	
	@Autowired
	private PropostaConvert propostaConvert;
	@Autowired
	private PropostaService propostaService;
	
	@Autowired
	@ApiOperation(value = "Mostrar uma lista de propostas",response = PropostaDTO.class)
    @RequestMapping(
    		method=RequestMethod.GET, 
    		value="/", 
    		produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<PropostaDTO>> listPropostas(){
		try {
			List<Proposta> list = (List<Proposta>) propostaService.listAll();
			List<PropostaDTO> listDto = new ArrayList<>();
			for(Proposta entity : list) {
				PropostaDTO dto = new PropostaDTO();
				dto = propostaConvert.convertEntityToDTO(entity);
				listDto.add(dto);
			}
	        return new ResponseEntity<List<PropostaDTO>>(listDto, HttpStatus.OK);
		} catch (Exception e) {
	    	System.out.println("Error no Método listPropostas."+e.getCause());
			return new ResponseEntity<List<PropostaDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
	@ApiOperation(value = "Procure uma proposta por um id",response = PropostaDTO.class)
    @RequestMapping(
    		value = "/{id}", 
    		method= RequestMethod.GET, 
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<PropostaDTO> showProposta(@PathVariable Long id){
		try {
			PropostaDTO proposta = propostaConvert.convertEntityToDTO(propostaService.getById(id));
			return new ResponseEntity<PropostaDTO>(proposta, HttpStatus.CREATED);
		} catch (Exception e) {
	    	System.out.println("Error no Método showProposta."+e.getCause());
			return new ResponseEntity<PropostaDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Salvar um proposta",response=PropostaDTO.class)
    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PropostaDTO saveProposta(@RequestBody PropostaDTO dto) {
		try {

			Proposta entity = propostaConvert.convertDTOtoEntity(dto, DominioConverter.SAVE);
			
			entity = propostaService.save(entity);

			return propostaConvert.convertEntityToDTO(entity);
	    } catch (Exception e) {
	    	System.out.println("Error no Método save."+e.getCause());
	    	return null;
	    }
    }
	
	@ApiOperation(value = "Atualizar um proposta",response=PropostaDTO.class)
    @RequestMapping(
            value = "/",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PropostaDTO updateProposta(@RequestBody PropostaDTO dto) {
		try {
			Proposta proposta = propostaService.update(propostaConvert.convertDTOtoEntity(dto, DominioConverter.UPDATE));

			return propostaConvert.convertEntityToDTO(propostaService.update(proposta));
	    } catch (Exception e) {
	    	System.out.println("Error no Método update."+e.getCause());
	    	return null;
	    }
    }
	
	@ApiOperation(value = "Deletar um proposta",response=PropostaDTO.class)
	@RequestMapping(
			value = "/{id}", 
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<PropostaDTO> deleteProposta(@PathVariable Long id) {
		try {
			propostaService.delete(id);
			return new ResponseEntity<PropostaDTO>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<PropostaDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}