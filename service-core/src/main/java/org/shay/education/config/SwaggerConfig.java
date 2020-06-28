package org.shay.education.config;

import org.shay.education.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 配置
 *
 * @author shay
 * @date 2020/6/8
 */
@Configuration
@EnableSwagger2
@RefreshScope
public class SwaggerConfig {

    @Value("${server.controllerPackage}")
    private String controllerPackage;

    @Value("${server.appName}")
    private String appName;

    @Bean
    public Docket systemApi() {
        if ("".equals(controllerPackage)) {
            return new Docket(DocumentationType.SWAGGER_2);
        }
        return new Docket(DocumentationType.SWAGGER_12)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(controllerPackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title(appName)
                .description(String.format("%s接口文档", appName))
                .version(Constants.APPLICATION_VERSION).build();
    }
}
