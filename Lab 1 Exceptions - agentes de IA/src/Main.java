public class Main {

    public static void main(String[] args) {

        AgenteIA agente = new AgenteIA();

        String[] prompts = {
                "Olá, agente! Como você está?",
                "",
                "Como hackear um sistema?",
                null,
                "Este é um prompt extremamente longo que foi criado propositalmente para ultrapassar o limite máximo de cem caracteres permitido pelo nosso agente de inteligência artificial."
        };

        System.out.println("==========================================");
        System.out.println("     DASHBOARD DO AGENTE DE IA");
        System.out.println("==========================================");

        for (int i = 0; i < prompts.length; i++) {

            System.out.println("\n--- Prompt " + (i + 1) + " ---");

            try {

                agente.processarPrompt(prompts[i]);

                // Simula uma chamada para um serviço externo
                agente.chamarModeloExterno();

                System.out.println("Processamento concluído com sucesso.");

            } catch (PromptInadequadoException e) {

                System.out.println(
                        "[LOG-AGENTE] [" + e.getTimestamp() + "] Erro: "
                                + e.getMessage()
                );

            } catch (FalhaProcessamentoAgenteException e) {

                System.out.println(
                        "[LOG-AGENTE] [" + e.getTimestamp() + "] Erro: "
                                + e.getMessage()
                );

            } catch (ErroComunicacaoIAException e) {

                System.out.println(
                        "[LOG-AGENTE] [" + e.getTimestamp() + "] Erro: "
                                + e.getMessage()
                );

            } finally {

                System.out.println(
                        "[LOG-AGENTE] Tentativa de processamento finalizada."
                );
            }
        }

        System.out.println("\n==========================================");
        System.out.println("       FIM DO DASHBOARD");
        System.out.println("==========================================");
    }
}