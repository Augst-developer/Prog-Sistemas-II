public class PluginPesquisaWeb implements IAcaoAgente {

    @Override
    public String executar(String comando)
            throws PromptInadequadoException {

        if (comando == null || comando.isEmpty()) {
            throw new PromptInadequadoException(
                "O comando de pesquisa não pode estar vazio."
            );
        }

        String comandoMinusculo = comando.toLowerCase();

        if (comandoMinusculo.equals("hackear")
                || comandoMinusculo.equals("roubar")) {

            throw new PromptInadequadoException(
                "Comando bloqueado pelo filtro de segurança da pesquisa."
            );
        }

        return "Resultado da pesquisa no Google sobre: " + comando;
    }
}