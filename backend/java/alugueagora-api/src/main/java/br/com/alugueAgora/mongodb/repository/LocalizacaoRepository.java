package br.com.alugueAgora.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alugueAgora.domain.Localizacao;

public interface LocalizacaoRepository extends MongoRepository<Localizacao, String> {

	public Localizacao findByCep(String cep);
	public List<Localizacao> findByDescricaoLocalizacao(String descricaoLocalizacao);

}
