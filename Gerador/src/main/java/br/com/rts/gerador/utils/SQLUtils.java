package br.com.rts.gerador.utils;

import java.util.Objects;

public class SQLUtils {

    public static String formatterString(String texto) {
        if (Objects.isNull(texto))
            texto = "";
        StringBuilder builder = new StringBuilder("%");
        builder.append(texto.toUpperCase());
        builder.append("%");
        return builder.toString();
    }
}
