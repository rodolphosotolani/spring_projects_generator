package br.com.rts.gerador.configuration.validation;

import br.com.rts.gerador.exception.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static br.com.rts.gerador.configuration.validation.ClientErrorResponse.USER_DOES_NOT_EXIST;
import static br.com.rts.gerador.configuration.validation.ClientErrorResponse.singleMessage;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class EntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ClientErrorResponse handleUsuarioNotFound(UsuarioNotFoundException e) {
        return singleMessage(USER_DOES_NOT_EXIST);
    }

}