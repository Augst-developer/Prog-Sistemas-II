public class PluginGeradorCodigo implements IAcaoAgente {

    @Override
    public String executar(String comando)
            throws FalhaProcessamentoAgenteException {

        if (comando == null || comando.isEmpty()) {
            throw new FalhaProcessamentoAgenteException(
                "O comando para geração de código não pode estar vazio."
            );
        }

        if (comando.length() > 50) {
            throw new FalhaProcessamentoAgenteException(
                "Comando muito longo para o gerador de código."
            );
        }

        return "Snippet de código Java gerado para: " + comando;
    }
}