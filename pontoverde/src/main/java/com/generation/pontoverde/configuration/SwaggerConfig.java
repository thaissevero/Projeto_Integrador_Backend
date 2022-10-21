package com.generation.pontoverde.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springPontoVerdeOpenAPI() {
		
		return new OpenAPI() 
				.info(new Info()
					.title("Projeto Integrador")
					.description("Ponto Verde")
					.version("v0.0.1")
				.license(new License()
					.name("Generation Brasil")
					.url("https://brazil.generation.org/"))
				.contact(new Contact()
					.name("Ponto Verde")
					.url("https://github.com/marirebecca")
					.url("https://github.com/AnaPaulaNunes")
					.url("https://github.com/flrvia")
					.url("https://github.com/thaissevero")
					.url("https://github.com/lettycodes")
					.url("https://github.com/Lidianeangelo")
					.url("https://github.com/fabianagsilva")
					.email("mari_rebecca@hotmail.com")
					.email("apnuness29@gmail.com")
					.email("flavixbatista@gmail.com")
					.email("thais.severo21@gmail.com")
					.email("sps.leticia@gmail.com")
					.email("lidiane-angelo@hotmail.com")))
				.externalDocs(new ExternalDocumentation()
					.description("Github")
					.url("https://github.com/conteudoGeneration/"));
	}
	
	@Bean
	public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {

		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

			}));
		};
	}
	
	private ApiResponse createApiResponse(String message) {

		return new ApiResponse().description(message);

	}
}
