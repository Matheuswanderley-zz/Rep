package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.ImovelAreaComum;
import br.com.alugueAgora.dto.ImovelAreaComumDTO;

@Component
public class ImovelAreaComumConvert {

	public List<ImovelAreaComum> convertDTOToEntity(List<ImovelAreaComumDTO> dto,Imovel imovel, String domino) {

		List<ImovelAreaComum> areasCom = new ArrayList<>();
		
		for(ImovelAreaComumDTO acomum : dto) {
			if("UPDATE".equalsIgnoreCase(domino)) {
				areasCom.add(new ImovelAreaComum( acomum.getCodigoImovelAreaComum(),
						acomum.getCodigoAreaComum(),
						acomum.getValor(),
						imovel));
			}else {
				areasCom.add(new ImovelAreaComum(	
						acomum.getCodigoAreaComum(),
						acomum.getValor(),
						imovel));
			}
		}
		return areasCom;
	}

	public List<ImovelAreaComumDTO> convertEntityToDTO(List<ImovelAreaComum> imoveis) {
		
		List<ImovelAreaComumDTO> areasCom = new ArrayList<>();
		
		for(ImovelAreaComum acomum : imoveis) {
			areasCom.add(new ImovelAreaComumDTO(acomum.getCodigoimovelareacomum(),
												acomum.getValor(),
												acomum.getAreaComum(),
												acomum.getImovel().getCodigoImovel()));
		}
		return areasCom;
	}

}
