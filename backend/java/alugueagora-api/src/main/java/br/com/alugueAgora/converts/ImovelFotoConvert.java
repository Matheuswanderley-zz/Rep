package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.ImovelFoto;
import br.com.alugueAgora.dto.ImovelFotoDTO;

@Component
public class ImovelFotoConvert {

	public List<ImovelFoto> convertDTOToEntity(List<ImovelFotoDTO> dto,Imovel imovel, String dominio) {

		List<ImovelFoto> fotos = new ArrayList<>();
		
		for(ImovelFotoDTO foto : dto) {
			if("UPDATE".equalsIgnoreCase(dominio)) {
				fotos.add(new ImovelFoto(foto.getCodigoFoto(),foto.getFoto(), imovel));
			}else{
				fotos.add(new ImovelFoto(foto.getFoto(),imovel));
			}
		}
		return fotos;
	}

	public List<ImovelFotoDTO> convertEntityToDTO(List<ImovelFoto> fotos) {
		List<ImovelFotoDTO> listaFotos = new ArrayList<>();

		for (ImovelFoto foto : fotos) {
				listaFotos.add(new ImovelFotoDTO(foto.getCodigoImovelFoto(), foto.getFoto(), foto.getImovel().getCodigoImovel()));
		}
		return listaFotos;
	}

}
