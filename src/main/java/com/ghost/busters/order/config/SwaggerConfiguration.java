package com.ghost.busters.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration("OrderSwaggerConfiguration")
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket ordersApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage("com.ghost.busters.order"))
                .paths(regex("/api/.*"))
                .build()
                .groupName("orders")
                .useDefaultResponseMessages(false)
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Orders REST API")
                .description("This API allows to perform all operations related to orders")
                .version("1.0")
                .build();
    }
}
