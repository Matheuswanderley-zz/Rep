package br.com.alugueAgora.repositories;

import java.util.List;

import br.com.alugueAgora.domain.Localizacao;

public interface LocalizacaoRepository extends CRUDRepository<Localizacao> {
	
	Localizacao getByCep(String cep);
	List<Localizacao> getByDescricao(String descricaoLocalizacao); 
	
}