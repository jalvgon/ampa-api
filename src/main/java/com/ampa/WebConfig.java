package com.ampa;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@EnableWebMvc
@Configuration
@PropertySource("classpath:application.yaml")
public class WebConfig implements WebMvcConfigurer {

	@Bean
	GroupedOpenApi publicApi() {

		return GroupedOpenApi.builder().group("public-apis").pathsToMatch("/**").build();
	}

	@Bean
	OpenAPI customOpenApi() {
		return new OpenAPI().info(new Info().title("Ampa API").version("V1"))
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
				.components(new Components().addSecuritySchemes("bearerAuth",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
	}

}