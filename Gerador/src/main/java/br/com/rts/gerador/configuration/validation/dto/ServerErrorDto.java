package br.com.rts.gerador.configuration.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ServerErrorDto {
    public static final String SOMETHING_WENT_WRONG = "somenthing.went.wrong";
    String message;
}
