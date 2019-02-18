package br.com.alugueAgora.repositories;

import java.util.List;

public interface CRUDRepository<T> {
	
	List<T> listAll();

	T getById(Long id);

	T save(T domainObject);

	T update(T domainObject);

	Long delete(Long id);
}
