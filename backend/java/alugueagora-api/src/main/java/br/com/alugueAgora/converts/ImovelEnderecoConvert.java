package br.com.alugueAgora.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.alugueAgora.domain.Imovel;
import br.com.alugueAgora.domain.ImovelEndereco;
import br.com.alugueAgora.dto.ImovelEnderecoDTO;

@Component
public class ImovelEnderecoConvert {
	
	

	public List<ImovelEndereco> convertDTOToEntity (List<ImovelEnderecoDTO> dto,Imovel imovel,String dominio){

		List<ImovelEndereco> enderecos = new ArrayList<>();
		
		for(ImovelEnderecoDTO endereco : dto) {
			if("UPDATE".equalsIgnoreCase(dominio)) {
				enderecos.add(new ImovelEndereco(	endereco.getCodigoEndereco(),
						endereco.getBairro(),
						endereco.getCep(),
						endereco.getTipoEndereco(),
						endereco.getCidade(),
						endereco.getComplemento(),
						endereco.getEstado(),
						endereco.getLogradouro(),
						endereco.getNumero(),
						endereco.getPais(),
						endereco.getRegiao(),
						endereco.getTipoLogradouro(),
						imovel));
			}else {
				enderecos.add(new ImovelEndereco(
						endereco.getBairro(),
						endereco.getCep(),
						endereco.getTipoEndereco(),
						endereco.getCidade(),
						endereco.getComplemento(),
						endereco.getEstado(),
						endereco.getLogradouro(),
						endereco.getNumero(),
						endereco.getPais(),
						endereco.getRegiao(),
						endereco.getTipoLogradouro(),
						imovel));
			}
		}
		return enderecos;
	}
	public List<ImovelEnderecoDTO> convertEntityToDTO (List<ImovelEndereco> enderecos){

		List<ImovelEnderecoDTO> listEndereco = new ArrayList<>();
		
		for(ImovelEndereco endereco : enderecos) {
			listEndereco.add(new ImovelEnderecoDTO(	endereco.getCodigoEndereco(),
													endereco.getBairro(),
													endereco.getCep(),
													endereco.getTipoEndereco(),
													endereco.getCidade(),
													endereco.getComplemento(),
													endereco.getEstado(),
													endereco.getLogradouro(),
													endereco.getNumero(),
													endereco.getPais(),
													endereco.getRegiao(),
													endereco.getTipologradouro(),
													endereco.getImovel().getCodigoImovel()));
		}
		return listEndereco;
	}
	
}

