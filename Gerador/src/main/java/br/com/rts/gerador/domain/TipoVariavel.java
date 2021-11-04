package br.com.rts.gerador.domain;

import br.com.rts.gerador.utils.Constants;
import br.com.rts.gerador.enuns.TipoVariavelEnum;
import lombok.Data;

import java.util.Objects;

@Data
public class TipoVariavel {

    private Classe classe;

    private TipoVariavelEnum reservado;

    @Override
    public String toString() {
        StringBuffer retorno = new StringBuffer();
        if (Objects.nonNull(classe))
            retorno.append(classe.getName());
        else
            retorno.append(reservado.name());

        retorno.append(Constants.SPACE);

        return retorno.toString();
    }
}
