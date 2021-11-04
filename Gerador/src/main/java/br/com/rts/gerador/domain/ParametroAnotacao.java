package br.com.rts.gerador.domain;

import br.com.rts.gerador.utils.Constants;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class ParametroAnotacao {

    private String name;
    private String valor;
    private List<Anotacao> annotationList;

    @Override
    public String toString() {
        StringBuffer retorno = new StringBuffer();
        retorno.append(name);
        retorno.append(Constants.EQUALS_SIGN);

        if (Objects.nonNull(annotationList)
        && !annotationList.isEmpty()){

            retorno.append(Constants.OPEN_BRACES);
            boolean primeiro = true;
            for (Anotacao anotacao : annotationList) {

                if (!primeiro){
                    retorno.append(Constants.COMMA);
                    retorno.append(Constants.LINE_BREAK);
                }

                retorno.append(anotacao.toString());
            }
            retorno.append(Constants.CLOSE_BRACES);

        } else{
            retorno.append(Constants.QUOTE);
            retorno.append(valor);
            retorno.append(Constants.QUOTE);
        }

        return retorno.toString();
    }
}
