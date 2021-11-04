package br.com.rts.gerador.domain;

import br.com.rts.gerador.enuns.ModificadorAcessoEnum;
import br.com.rts.gerador.utils.Constants;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Interface {

    private ModificadorAcessoEnum modificadorAcesso;

    private String name;

    private List<MetodoInterface> metodoList;

    private List<String> importList;

    @Override
    public String toString() {
        StringBuffer retorno = new StringBuffer();

        retorno.append(modificadorAcesso.name());
        retorno.append(Constants.INTERFACE);
        retorno.append(name);
        retorno.append(Constants.OPEN_BRACES);
        retorno.append(Constants.LINE_BREAK);

        if (Objects.nonNull(metodoList)
                && !metodoList.isEmpty()) {

            retorno.append(Constants.LINE_BREAK);
            for (MetodoInterface metodoInterface : metodoList) {

                retorno.append(metodoInterface.toString());
                retorno.append(Constants.LINE_BREAK);

            }

        }
        retorno.append(Constants.LINE_BREAK);
        retorno.append(Constants.CLOSE_BRACES);

        return retorno.toString();
    }
}
