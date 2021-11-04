package br.com.rts.gerador.enuns;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum TipoVariavelEnum {

    VOID("void", ""),
    BOOLEAN("Boolean", ""),
    INTEGER("Integer", ""),
    LONG("Long", ""),
    BIGDECIMAL("BigDecimal", "import java.math.BigDecimal"),
    LOCALDATE("LocalDate", "import java.time.LocalDate"),
    DATE("Date", "import java.util.Date"),
    STRING("String", ""),
    ;

    private String name;
    private String importClass;


}
