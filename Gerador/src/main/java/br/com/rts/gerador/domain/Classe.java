package br.com.rts.gerador.domain;

import br.com.rts.gerador.utils.Constants;
import br.com.rts.gerador.enuns.ModificadorAcessoEnum;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Classe {

    /**
     * Nome final do pacote
     * Exemplo: domain, controller, service...
     */
    private String packageName;

    /**
     * Nome da Classe
     */
    private String name;

    /**
     * Lista de imports necessarios para a classe
     * Obs. Adicionado automaticamente com os packages, fields, implements e extends
     */
    private List<String> importNameList;

    /**
     * Modificador de Acesso da Classe.
     * Exemplo:
     * public, private, protected
     */
    private ModificadorAcessoEnum modificadorAcesso;

    /**
     * Lista de Annotations da Classe.
     * Utilizado para configurar o tipo de classe.
     * Exemplos:
     *
     * @Lombok, @Service, @Repository, @Entity...
     */
    private List<AnotacaoClasse> annotationList;

    /**
     * Lista de Campos contidos na Classe
     */
    private List<Field> fieldList;

    /**
     * Lista de Campos contidos na Classe
     */
    private List<Method> methodList;

    /**
     * Define se esta classe extends de outra classe
     */
    private Classe extendsClass;

    /**
     * Define se esta classe implementa uma interface
     */
    private Interface implementsClass;

    @Override
    public String toString() {
        StringBuffer retorno = new StringBuffer();
        retorno.append(Constants.PACKAGE);
        retorno.append(this.packageName);
        retorno.append(Constants.SEMICOLON);
        retorno.append(Constants.LINE_BREAK);

        /**
         * IMPORTS
         */
        if (Objects.nonNull(importNameList)
                && !importNameList.isEmpty()) {
            importNameList
                    .stream()
                    .forEach(imports -> {
                        retorno.append(Constants.IMPORT);
                        retorno.append(imports);
                        retorno.append(Constants.SEMICOLON);
                        retorno.append(Constants.LINE_BREAK);
                    });
            retorno.append(Constants.LINE_BREAK);
        }

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
        retorno.append(Constants.CLASS);
        retorno.append(name);

        /**
         * IMPLEMENTS
         */
        if (Objects.nonNull(implementsClass)) {
            retorno.append(Constants.IMPLEMENTS);
            retorno.append(implementsClass.getName());
        }

        /**
         * EXTENDS
         */
        if (Objects.nonNull(extendsClass)) {
            retorno.append(Constants.EXTENDS);
            retorno.append(extendsClass.getName());
        }

        retorno.append(Constants.OPEN_BRACES);
        retorno.append(Constants.LINE_BREAK);

        /**
         * FIELDS
         */
        if (Objects.nonNull(fieldList)
                && !fieldList.isEmpty()) {

            retorno.append(Constants.LINE_BREAK);
            fieldList
                    .stream()
                    .forEach(field -> {
                        retorno.append(field.toString());
                        retorno.append(Constants.LINE_BREAK);
                        retorno.append(Constants.LINE_BREAK);
                    });
        }

        /**
         * METHODS
         */
        if (Objects.nonNull(methodList)
                && !methodList.isEmpty()) {

            retorno.append(Constants.LINE_BREAK);
            methodList
                    .stream()
                    .forEach(method -> {
                        retorno.append(method.toString());
                        retorno.append(Constants.LINE_BREAK);
                        retorno.append(Constants.LINE_BREAK);
                    });
        }

        retorno.append(Constants.CLOSE_BRACES);

        return retorno.toString();
    }
}
