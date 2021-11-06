package br.com.rts.gerador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Locale;

@EnableSpringDataWebSupport
@EnableSwagger2
@EnableWebSecurity
@SpringBootApplication
public class GeradorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeradorApplication.class, args);
    }

    /**
     * Define o Locale para o padrao no Brasil
	 */
    @Bean
    public LocaleResolver localeResolver() {
        return new FixedLocaleResolver(new Locale("pt", "BR"));
    }
}
