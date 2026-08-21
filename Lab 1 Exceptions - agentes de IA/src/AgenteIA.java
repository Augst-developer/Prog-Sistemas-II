public class AgenteIA {

    public void processarPrompt(String prompt)
            throws FalhaProcessamentoAgenteException, PromptInadequadoException {

        try {

            // Primeiro verifica a segurança
            verificarSeguranca(prompt);

            // Verifica se o prompt é nulo ou vazio
            if (prompt == null || prompt.isEmpty()) {
                throw new FalhaProcessamentoAgenteException(
                        "O prompt não pode estar vazio."
                );
            }

            // Verifica o tamanho do prompt
            if (prompt.length() > 100) {
                throw new FalhaProcessamentoAgenteException(
                        "Prompt muito longo para o modelo atual."
                );
            }

            System.out.println("Agente processando: " + prompt);

        } finally {
            System.out.println("[LOG-AGENTE] Finalizando processamento do prompt.");
        }
    }

    public void verificarSeguranca(String prompt)
            throws PromptInadequadoException {

        // Trata null antes de utilizar métodos como contains()
        if (prompt == null) {
            return;
        }

        String promptMinusculo = prompt.toLowerCase();

        if (promptMinusculo.contains("hackear")
                || promptMinusculo.contains("roubar")) {

            throw new PromptInadequadoException(
                    "Prompt bloqueado pelo filtro de segurança."
            );
        }
    }

    public void chamarModeloExterno()
            throws ErroComunicacaoIAException {

        double numeroAleatorio = Math.random();

        System.out.println(
                "Tentando comunicação com modelo externo..."
        );

        System.out.println(
                "Número aleatório gerado: " + numeroAleatorio
        );

        if (numeroAleatorio > 0.7) {

            throw new ErroComunicacaoIAException(
                    "Falha na comunicação com o modelo externo."
            );
        }

        System.out.println(
                "Comunicação com o modelo externo realizada com sucesso."
        );
    }
}