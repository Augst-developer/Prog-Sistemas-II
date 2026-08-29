public class Main {

    public static void main(String[] args) {

        AgenteIA agente = new AgenteIA("Agente Principal") {

            @Override
            public void processarRequisicao(String input)
                    throws FalhaProcessamentoAgenteException,
                           PromptInadequadoException,
                           ErroComunicacaoIAException {

                System.out.println(
                    "Processando requisição: " + input
                );
            }
        };

        IAcaoAgente pesquisaWeb =
                new PluginPesquisaWeb();

        IAcaoAgente geradorCodigo =
                new PluginGeradorCodigo();

        String comando = "Como aprender Java";

        System.out.println(
            "=== TESTE 1: PESQUISA WEB ==="
        );

        try {

            String resultado = agente.usarHabilidade(
                pesquisaWeb,
                comando
            );

            System.out.println(resultado);

        } catch (PromptInadequadoException e) {

            System.out.println(
                "[ERRO DE SEGURANÇA] " +
                e.getMessage()
            );

        } catch (FalhaProcessamentoAgenteException e) {

            System.out.println(
                "[ERRO DE PROCESSAMENTO] " +
                e.getMessage()
            );
        }


        System.out.println(
            "\n=== TESTE 2: GERADOR DE CÓDIGO ==="
        );

        try {

            String resultado = agente.usarHabilidade(
                geradorCodigo,
                comando
            );

            System.out.println(resultado);

        } catch (PromptInadequadoException e) {

            System.out.println(
                "[ERRO DE SEGURANÇA] " +
                e.getMessage()
            );

        } catch (FalhaProcessamentoAgenteException e) {

            System.out.println(
                "[ERRO DE PROCESSAMENTO] " +
                e.getMessage()
            );
        }


        System.out.println(
            "\n=== TESTE 3: COMANDO INADEQUADO ==="
        );

        try {

            String resultado = agente.usarHabilidade(
                pesquisaWeb,
                "hackear"
            );

            System.out.println(resultado);

        } catch (PromptInadequadoException e) {

            System.out.println(
                "[ERRO DE SEGURANÇA] " +
                e.getMessage()
            );

        } catch (FalhaProcessamentoAgenteException e) {

            System.out.println(
                "[ERRO DE PROCESSAMENTO] " +
                e.getMessage()
            );
        }
    }
}