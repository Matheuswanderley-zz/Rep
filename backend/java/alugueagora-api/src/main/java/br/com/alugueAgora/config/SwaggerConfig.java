package br.com.alugueAgora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.*;

import java.util.Collections;

@Configuration("SwaggerConfig")
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                //.apis(RequestHandlerSelectors.basePackage("br.com.alugueAgora.controllers"))
                //.paths(regex("/imovel.*"))
                //.paths(paths())
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET,
						newArrayList(
								new ResponseMessageBuilder().code(500).message("500 message")
										.responseModel(new ModelRef("Error")).build(),
								new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build()));
	}

/*	private Predicate<String> paths() {
		return or(
		        regex("/teste1.*"),
		        regex("/teste2.*"),
		        regex("/imovel.*"));
	}*/

	private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "AlugueAgora - Alugue Agora",
                "Serviços disponíveis para consulta via REST API",
                "1.0",
                "Termos dos servicos",
                new Contact("David Makson do Nascimento Tavares", "https://www.a2f.com.br", "david.tavares@a2f.com.br"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
        return apiInfo;
	}
}