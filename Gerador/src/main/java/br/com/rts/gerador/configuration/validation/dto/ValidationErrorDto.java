package br.com.rts.gerador.configuration.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ValidationErrorDto {

    private String campo;
    private String erro;

}
