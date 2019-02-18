package br.com.alugueAgora.services;

import java.util.List;

import br.com.alugueAgora.domain.Imovel;

public interface ImovelService extends CRUDService<Imovel> {

	List<Imovel> findBy(Long tipo, Long negocio, Long quantidadeBanheiros, Long quantidadeDormitorios,
			Long quantidadeSuites, Long quantidadeGaragem);

}
