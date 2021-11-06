package br.com.rts.gerador.configuration.validation;

import br.com.rts.gerador.configuration.validation.dto.ServerErrorDto;
import br.com.rts.gerador.configuration.validation.dto.ValidationErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static br.com.rts.gerador.configuration.validation.ClientErrorResponse.*;
import static br.com.rts.gerador.configuration.validation.dto.ServerErrorDto.SOMETHING_WENT_WRONG;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorDto>> handle(MethodArgumentNotValidException exception) {
        List<ValidationErrorDto> validationErrorDtoList = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ValidationErrorDto erro = new ValidationErrorDto(e.getField(), mensagem);
            validationErrorDtoList.add(erro);
        });
        log.error(validationErrorDtoList.toString());
        return ResponseEntity.badRequest().body(validationErrorDtoList);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    public ClientErrorResponse handleConstraintViolation(DataIntegrityViolationException e) {
        log.error(e.getMessage());
        return of(INCONSISTENT_DATA_CHECK_RELATIONSHIPS, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ServerErrorDto handleException(Exception e) {
        log.error(e.getMessage());
        return new ServerErrorDto(SOMETHING_WENT_WRONG);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(BAD_REQUEST)
    public ClientErrorResponse handleBadCredentials(BadCredentialsException e) {
        return singleMessage(USER_OR_PASSWORD_IS_INVALID);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ClientErrorResponse handleUsernameNotFound(UsernameNotFoundException e) {
        return singleMessage(USERNAME_DOES_NOT_EXIST);
    }
}