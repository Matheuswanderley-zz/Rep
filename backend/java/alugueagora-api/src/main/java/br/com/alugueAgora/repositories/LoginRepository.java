package br.com.alugueAgora.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alugueAgora.domain.Login;

@Repository
public interface LoginRepository extends CRUDRepository<Login> {

	Login findByUsername(String email);

}
