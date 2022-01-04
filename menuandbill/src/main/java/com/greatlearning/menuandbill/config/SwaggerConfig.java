package com.greatlearning.menuandbill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket restaurantmanagementapi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.groupName("Menu-Bill-API").select()
				.apis(RequestHandlerSelectors.basePackage(
						"com.greatlearning.menuandbill.controller"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Menu-Bill API")
				.description("Menu-Bill API reference")
				.termsOfServiceUrl("http://menuandbill.com")
				.contact(new Contact("Menu-Bill API","http://menuandbill.com","customersupport@menuandbill.com"))
				.license("Menu-Bill License")
				.licenseUrl("http://menuandbill.com")
				.version("1.0")
				.build();
	}

}
