package com.flight.booking.system.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swaggerconfig {
    public static final Logger logger = LoggerFactory.getLogger(Swaggerconfig.class);
    public static final String PATH = "com.flight.booking.system.controller";

    @Bean
    public Docket api() {
        logger.info("Start Calling Swagger UI!!");
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(PATH)).
                paths(PathSelectors.any()).build();
    }

}
