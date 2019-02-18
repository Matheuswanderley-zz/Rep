package br.com.alugueAgora.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Classe para configurar o CORS e o acesso aos metodos REST.
 * 
 * Validar se o header contem os parametros necessarios: 
 * 
 * Authorization – Autenticacao basica. Ex.: Basic YXBwdGVjbmljb2NsaWVudGVkZXZ1c2VyOmEyRkAyMDE2
 * Content-Type - Tipo de conteudo. Ex.: application/json, application/xml (para todas as chamadas que não sejam GET) 
 * Accept - Content-Type - Tipo de conteudo. Ex.: application/json, application/xml (para todas as chamadas GET)
 * Api-Key - Identificador da API. Ex: 962cbc51-3140-46f6-8d55-d59170e0bbcb
 */
@Configuration("SecurityHeaderAcess")
public class SecurityHeaderAcess {

	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		String origem = "*";
		config.setAllowCredentials(true);
		config.addAllowedOrigin(origem);
		config.addAllowedHeader(
				"Accept,"
				+ "Api-Key,"
				+ "Content-Type,"
				+ "Authorization");
		config.addAllowedMethod("POST,GET,PUT,DELETE");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}
	
}