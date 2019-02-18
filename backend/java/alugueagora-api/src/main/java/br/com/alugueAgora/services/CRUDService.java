package br.com.alugueAgora.services;

import java.util.List;


public interface CRUDService<T> {
	
	List<T> listAll();

	T getById(Long id);

	T save(T domainObject);

	T update(T domainObject);

	Long delete(Long id);
}
