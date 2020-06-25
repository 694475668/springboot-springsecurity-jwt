package com.ratta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Swagger2配置
 * @Author: 刘明
 * @Date: 2020/4/29
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * swagger2的配置文件
     */
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization").description("用户令牌").modelRef(new ModelRef("String")).parameterType("header")
                .required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ratta.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars).apiInfo(apiInfo());
    }

    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     */
    private ApiInfo apiInfo() {
        // 获取工程名称
        String projectName = System.getProperty("user.dir");
        return new ApiInfoBuilder()
                .title(projectName.substring(projectName.lastIndexOf("\\") + 1) + " API接口文档")
                .contact(new Contact("夕颜源码官方地址", "http://xiyanyuanma.com", "694475668@qq.com"))
                .version("1.0")
                .description("API文档")
                .build();
    }
}
