package br.com.alugueAgora.services;

import br.com.alugueAgora.domain.Login;
import br.com.alugueAgora.repositories.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *@author David Makson do Nascimento Tavares
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Login user = loginRepository.findByUsername(email);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", email));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getAcessos().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getTipoAcesso()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getEmail(), user.getPassword(), authorities);

        return userDetails;
    }
}