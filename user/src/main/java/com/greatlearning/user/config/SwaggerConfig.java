package com.greatlearning.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket libraryApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("User-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.greatlearning.user.controller")).build();

	}
}
