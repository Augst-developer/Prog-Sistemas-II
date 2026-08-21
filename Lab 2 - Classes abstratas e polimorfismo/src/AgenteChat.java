public class AgenteChat extends AgenteIA {

    public AgenteChat(String nome) {
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
                    "Mensagem vazia."
            );
        }

        System.out.println(
                "Agente Chat " + nome +
                        " respondendo: " + input
        );
    }
}