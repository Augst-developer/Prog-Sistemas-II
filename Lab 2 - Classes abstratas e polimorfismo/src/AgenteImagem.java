public class AgenteImagem extends AgenteIA {

    public AgenteImagem(String nome) {
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

        String texto = input.toLowerCase();

        if (texto.contains("hackear")
                || texto.contains("roubar")
                || texto.contains("biométrico")) {

            throw new PromptInadequadoException(
                    "Prompt bloqueado pelo filtro de segurança."
            );
        }

        System.out.println(
                "Agente de Imagem " + nome +
                        " sintetizando pixels para: " + input
        );
    }
}