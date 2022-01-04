package com.greatlearning.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket restaurantmanagementapi() {
		return new Docket(DocumentationType.SWAGGER_2)  //.apiInfo(apiInfo())
				.groupName("CRUD-API").select()
				.apis(RequestHandlerSelectors.basePackage(
						"com.greatlearning.crud.controller"))
				.build();
	}

//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("CRUD API")
//				.description("CRUD API reference")
//				.termsOfServiceUrl("http://usercrud.com")
//				.contact(new Contact("CRUD API","http://usercrud.com","customersupport@usercrud.com"))
//				.license("CRUD License")
//				.licenseUrl("http://usercrud.com")
//				.version("1.0")
//				.build();
//	}

}
