package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Acesso;
import br.com.alugueAgora.domain.Login;
import br.com.alugueAgora.dto.AcessoDTO;
import br.com.alugueAgora.dto.LoginDTO;

@Component
public class AcessoConvert {

	@Autowired
	LoginConvert loginConvert;
	
	public List<Acesso> convertDTOToEntity(List<AcessoDTO> acessos, String dominio) {
		List<Acesso> lista= new ArrayList<>();
		
		for(AcessoDTO acesso: acessos) {
			if ("UPDATE".equalsIgnoreCase(dominio)) {
			lista.add(new Acesso(acesso.getCodigoAcesso(),
					acesso.getTipoAcesso()
					//,loginConvert.convertDTOtoEntity(acesso.getLogins(),"")
					));
			} else {
				lista.add(new Acesso(
						acesso.getTipoAcesso()
						//,loginConvert.convertDTOtoEntity(acesso.getLogins(),"")
						));
			}

		}
		return lista;
	}
	
	public Acesso convertDTOtoEntity(AcessoDTO dto,String dominio) {
		if ("UPDATE".equalsIgnoreCase(dominio)) {
			Acesso acesso = new Acesso(dto.getCodigoAcesso(),
					dto.getTipoAcesso()
					//,loginConvert.convertDTOtoEntity(acesso.getLogins(),"")
					);
			return acesso;
		}else {
				Acesso acesso = new Acesso(
						dto.getTipoAcesso()
						//,loginConvert.convertDTOtoEntity(acesso.getLogins(),"")
						);
				return acesso;	
		}
	}
	
	public List<AcessoDTO> convertEntityToDTO(List<Acesso> acessos) {
		List<AcessoDTO> lista= new ArrayList<>();
		
		for(Acesso acesso: acessos) {
			lista.add(new AcessoDTO(acesso.getCodigoAcesso(),
					acesso.getTipoAcesso()
					//,loginConvert.convertEntityToDTO(acesso.getLogins())
					));
		}
		return lista;
	}

	public AcessoDTO convertEntityToDTO(Acesso acesso) {
		return new AcessoDTO(acesso.getCodigoAcesso(),
							acesso.getTipoAcesso()
							//,loginConvert.convertEntityToDTO(acesso.getLogins())
							);
	}
}
