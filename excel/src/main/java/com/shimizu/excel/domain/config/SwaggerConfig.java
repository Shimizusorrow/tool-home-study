package com.shimizu.excel.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/21 15:50
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket config() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("Swagger UI Test By Shimizu")
                                .description("")
                                .version("4.0")
                                .build())
                .groupName("A-default")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }
}
