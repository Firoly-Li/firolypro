package com.firolypro;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * com.firolypro
 * lihaoyang
 * 2018/7/2
 * 上午10:00
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalResponseMessage(RequestMethod.GET, Lists.newArrayList(new ResponseMessageBuilder().code(500).message("500 ERROR").build()));
    }

    public ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("关于firolypro项目的接口文档")
                .description("restful API文档")
                .contact(new Contact("LHY","",""))
                .version("1.0")
                .build();

        return apiInfo;
    }
}

