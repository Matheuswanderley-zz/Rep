package br.com.teste;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Testes {
	
	public static void main(String[] args) {
		String encoded=new BCryptPasswordEncoder().encode("123123");
		System.out.println(encoded);
	}
}
