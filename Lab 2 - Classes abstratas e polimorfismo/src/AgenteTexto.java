public class AgenteTexto extends AgenteIA {

    public AgenteTexto(String nome) {
        super(nome);
    }

    @Override
    public void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException,
            PromptInadequadoException,
            ErroComunicacaoIAException {

        conectarServidor();

        if (input == null || input.isEmpty()) {
            throw new FalhaProcessamentoAgenteException(
                    "Entrada vazia."
            );
        }

        if (input.length() > 500) {
            throw new FalhaProcessamentoAgenteException(
                    "Estouro de contexto."
            );
        }

        System.out.println(
                "Agente de Texto " + nome +
                        " gerando resposta para: " + input
        );
    }
}