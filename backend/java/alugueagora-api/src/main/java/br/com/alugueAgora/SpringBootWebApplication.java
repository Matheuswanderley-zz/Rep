package br.com.alugueAgora;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication(exclude={ErrorMvcAutoConfiguration.class})
public class SpringBootWebApplication implements CommandLineRunner {

	@Autowired
	DataSource dataSource;
    
	public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
      
    }
    @Transactional(readOnly = true)
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("DATASOURCE = " + dataSource);
		
	}
    
	
}
