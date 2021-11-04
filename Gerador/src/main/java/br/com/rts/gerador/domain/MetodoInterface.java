package br.com.rts.gerador.domain;

import br.com.rts.gerador.utils.Constants;

import java.util.List;
import java.util.Objects;

public class MetodoInterface {

    private TipoVariavel tipoVariavel;

    private String name;

    private List<ParametroMetodo> parametroList;

    private List<Classe> exceptionList;

    @Override
    public String toString() {
        StringBuffer retorno = new StringBuffer();
        retorno.append(tipoVariavel.toString());
        retorno.append(name);

        retorno.append(Constants.OPEN_PARENTHESES);
        if (Objects.nonNull(parametroList)
                && !parametroList.isEmpty()) {

            boolean primeiro = true;
            for (ParametroMetodo parametro : parametroList) {

                if (primeiro)
                    primeiro = false;
                else
                    retorno.append(Constants.COMMA);

                retorno.append(parametro.toString());
            }
        }
        retorno.append(Constants.CLOSE_PARENTHESES);

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

        retorno.append(Constants.SEMICOLON);

        return retorno.toString();
    }
}
