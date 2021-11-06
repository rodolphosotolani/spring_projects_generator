package br.com.rts.gerador.configuration.swagger;

import br.com.rts.gerador.configuration.security.domain.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfigurations {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(Usuario.class)
                .securitySchemes(Collections.singletonList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.rts.gerador"))
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization-Key", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        AuthorizationScope[] authScopes = new AuthorizationScope[1];
        authScopes[0] = new AuthorizationScopeBuilder().scope("global").description("full access").build();
        SecurityReference securityReference = SecurityReference.builder()
                .reference("Authorization-Key")
                .scopes(authScopes)
                .build();
        return SecurityContext.builder().securityReferences(
                Collections.singletonList(securityReference)).build();
    }
}