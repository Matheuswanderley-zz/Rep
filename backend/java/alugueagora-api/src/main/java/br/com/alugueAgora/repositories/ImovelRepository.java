package br.com.alugueAgora.repositories;

import java.util.List;

import br.com.alugueAgora.domain.Imovel;

public interface ImovelRepository extends CRUDRepository<Imovel> {

	List<Imovel> findBy(Long tipo, Long negocio, Long quantidadeBanheiros, Long quantidadeDormitorios,
			Long quantidadeSuites, Long quantidadeGaragem);
}