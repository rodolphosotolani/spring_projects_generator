package br.com.rts.gerador.domain;

import br.com.rts.gerador.utils.Constants;
import br.com.rts.gerador.enuns.ModificadorAcessoEnum;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Field {

    private ModificadorAcessoEnum modificadorAcesso;
    private TipoVariavel tipoVariavel;
    private String name;
    private String nameDataBase;
    private String nameJson;
    private List<AnotacaoVariavel> annotationList;

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
                    .forEach(anotacao -> {
                        retorno.append(anotacao.toString());
                        retorno.append(Constants.LINE_BREAK);
                    });
        }

        retorno.append(modificadorAcesso.name());
        retorno.append(tipoVariavel.toString());
        retorno.append(name);
        retorno.append(Constants.SEMICOLON);

        return retorno.toString();
    }
}