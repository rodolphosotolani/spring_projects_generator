package br.com.rts.gerador.domain;

import br.com.rts.gerador.utils.Constants;
import br.com.rts.gerador.enuns.ModificadorAcessoEnum;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Method {

    private List<AnotacaoMetodo> annotationList;

    private ModificadorAcessoEnum modificadorAcesso;

    private TipoVariavel tipoVariavel;

    private String name;

    private List<ParametroMetodo> parametroMetodoList;

    private List<Classe> exceptionList;

    @Override
    public String toString() {
        StringBuffer retorno = new StringBuffer();

        /**
         * ANNOTATIONS
         */
        if (Objects.nonNull(annotationList)
                && !annotationList.isEmpty()) {
            annotationList
                    .stream()
                    .forEach(annotation -> {
                        retorno.append(annotation.toString());
                        retorno.append(Constants.LINE_BREAK);
                    });
        }

        retorno.append(modificadorAcesso.name());
        retorno.append(tipoVariavel.toString());
        retorno.append(name);
        retorno.append(Constants.OPEN_PARENTHESES);

        /**
         * PARAMETERS
         */
        if (Objects.nonNull(parametroMetodoList)
                && !parametroMetodoList.isEmpty()) {

            boolean primeiro = true;
            for (ParametroMetodo parametro : parametroMetodoList) {
                if (primeiro)
                    primeiro = false;
                else
                    retorno.append(Constants.COMMA);

                retorno.append(parametro.toString());
            }
        }

        /**
         * EXCEPTIONS
         */
        if (Objects.nonNull(exceptionList)
                && !exceptionList.isEmpty()) {

            retorno.append(Constants.THROWS);
            boolean primeiro = true;
            for (Classe exception : exceptionList) {
                if (primeiro)
                    primeiro = false;
                else
                    retorno.append(Constants.COMMA);

                retorno.append(exception.getName());
            }
        }

        retorno.append(Constants.CLOSE_PARENTHESES);

        retorno.append(Constants.OPEN_BRACES);
        retorno.append(Constants.LINE_BREAK);
        retorno.append(Constants.LINE_BREAK);
        retorno.append(Constants.CLOSE_BRACES);
        retorno.append(Constants.LINE_BREAK);

        return retorno.toString();
    }
}
