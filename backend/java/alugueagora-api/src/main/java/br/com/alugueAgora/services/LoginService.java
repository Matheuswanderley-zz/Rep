package br.com.alugueAgora.services;


import br.com.alugueAgora.domain.Login;

public interface LoginService extends CRUDService<Login>{
    Login findByUsername(String username);
}
