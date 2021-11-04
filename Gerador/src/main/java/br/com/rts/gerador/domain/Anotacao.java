package br.com.rts.gerador.domain;

import br.com.rts.gerador.utils.Constants;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Anotacao {

    private String name;
    private String importName;
    private List<ParametroAnotacao> parametroAnotacaoList;

    @Override
    public String toString() {
        StringBuffer retorno = new StringBuffer();
        retorno.append(Constants.AT_SIGN);
        retorno.append(name);

        if (Objects.nonNull(parametroAnotacaoList)
                && !parametroAnotacaoList.isEmpty()) {

            retorno.append(Constants.OPEN_PARENTHESES);

            boolean primeiro = true;
            for (ParametroAnotacao parametro : parametroAnotacaoList) {
                if (primeiro)
                    primeiro = false;
                else
                    retorno.append(Constants.COMMA);

                retorno.append(parametro.toString());
            }

            retorno.append(Constants.CLOSE_PARENTHESES);
        }

        return retorno.toString();
    }
}
