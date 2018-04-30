package com.girisb.swaggerspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String LICENSE_TEXT = "License";
    private static final String title = "Swagger Spring Boot";
    private static final String description = "This is a demo for swagger codegen and spring boot application.";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .license(LICENSE_TEXT)
                .version(SWAGGER_API_VERSION)
                .build();
    }

    @Bean
    public Docket swaggerSpringBootApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .enable(true)
                .groupName("Swagger Spring Boot")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.girisb.swaggerspringboot.controller"))
                .build()
                .apiInfo(apiInfo());
    }
}
