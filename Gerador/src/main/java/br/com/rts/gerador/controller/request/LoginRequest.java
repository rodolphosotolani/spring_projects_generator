package br.com.rts.gerador.controller.request;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;

import static br.com.rts.gerador.configuration.validation.ClientErrorResponse.PASSWORD_IS_EMPTY;
import static br.com.rts.gerador.configuration.validation.ClientErrorResponse.USERNAME_IS_EMPTY;

@Data
public class LoginRequest {

    @NotEmpty(message = USERNAME_IS_EMPTY)
    private String username;

    @NotEmpty(message = PASSWORD_IS_EMPTY)
    private String password;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(this.getUsername(), this.getPassword());
    }

}
