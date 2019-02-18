package br.com.alugueAgora.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author David Makson do Nascimento Tavares Classe responsável por restringir
 *         o acesso a determinadas APIs
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/v2/api-docs", 
				"/configuration/ui", 
				"/swagger-resources/**", 
				"/swagger-ui.html",
				"/webjars/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
		// cria uma conta default
		/*auth.inMemoryAuthentication()
			.withUser("admin")
			.password("password")
			.roles("ADMIN");*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, 	"/api/**").permitAll()
		.antMatchers(HttpMethod.POST, 	"/api/**").permitAll()
		.antMatchers(HttpMethod.PUT, 	"/api/**").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api/**").permitAll()
		.antMatchers(HttpMethod.POST, 	"/token").permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilterBefore(new JWTLoginFilter("/token", authenticationManager()),UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
