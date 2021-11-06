package br.com.rts.gerador;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApplicationProperties {

    @Value("${token.jwt.expiration}")
    private String tokenExpiration;

    @Value("${token.jwt.secret}")
    private String tokenSecret;

}
