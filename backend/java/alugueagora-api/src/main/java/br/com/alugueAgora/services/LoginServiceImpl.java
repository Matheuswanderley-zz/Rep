package br.com.alugueAgora.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alugueAgora.domain.Acesso;
import br.com.alugueAgora.domain.Login;
import br.com.alugueAgora.repositories.AcessoRepository;
import br.com.alugueAgora.repositories.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private AcessoRepository acessoRepository;

	@Override
	public List<Login> listAll() {
		return (List<Login>) loginRepository.listAll();
	}

	@Override
	public Login getById(Long id) {
		return loginRepository.getById(id);
	}

	@Override
	public Login save(Login login) {
		List<Acesso> acessos = new ArrayList<>();
		Acesso acesso = new Acesso();
		acesso = acessoRepository.findByTipoAcesso("USUARIO");
		acessos.add(acesso);
		login.setAcessos(acessos);
		return loginRepository.save(login);
	}

	@Override
	public Login update(Login login) {
		return loginRepository.update(login);
	}

	@Override
	public Long delete(Long id) {
		return loginRepository.delete(id);
	}

	@Override
	public Login findByUsername(String email) {
		Login user = loginRepository.findByUsername(email);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("The username %s doesn't exist", email));
		}
		return user;
	}

}
