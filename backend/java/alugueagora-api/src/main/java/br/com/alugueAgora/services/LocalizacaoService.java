package br.com.alugueAgora.services;


import java.util.List;

import br.com.alugueAgora.domain.Localizacao;

public interface LocalizacaoService extends CRUDService<Localizacao>{
	
	Localizacao getByCep(String cep);
	List<Localizacao> getByDescricao(String descricaoLocalizacao); 
		
}
