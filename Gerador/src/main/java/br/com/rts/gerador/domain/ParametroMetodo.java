package br.com.rts.gerador.domain;

import br.com.rts.gerador.utils.Constants;
import lombok.Data;

@Data
public class ParametroMetodo {

    private TipoVariavel tipoVariavel;

    private String name;

    @Override
    public String toString() {
        StringBuffer retorno = new StringBuffer();
        retorno.append(tipoVariavel.toString());
        retorno.append(Constants.SPACE);
        retorno.append(name);
        return retorno.toString();
    }
}
