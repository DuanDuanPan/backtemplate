/**
 * @Project Name :  portal
 * @Package Name :  com.orient.portal.config
 * @Description :
 * @author :  panduanduan
 * @Creation Date:  2017-12-26 4:33 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.orient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author :  panduanduan
 * @Description :  契约初始化,加入springfox-swagger-ui依赖后，访问http://ip:port/contextName/swagger-ui.html
 * @Creation Date:  2017-12-26 4:33 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.orient"))
                .paths(PathSelectors.any())
                .build();
    }
}