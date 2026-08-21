import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void processarFila(
            List<AgenteIA> lista,
            String comando) {

        for (AgenteIA agente : lista) {

            try {

                System.out.println(
                        "\nEnviando para " + agente.getNome()
                );

                agente.processarRequisicao(comando);

            } catch (FalhaProcessamentoAgenteException e) {

                System.out.println(
                        "[LOG-AGENTE] [" +
                                e.getTimestamp() +
                                "] Erro: " +
                                e.getMessage()
                );

            } catch (PromptInadequadoException e) {

                System.out.println(
                        "[LOG-AGENTE] [" +
                                e.getTimestamp() +
                                "] Erro: " +
                                e.getMessage()
                );

            } catch (ErroComunicacaoIAException e) {

                System.out.println(
                        "[LOG-AGENTE] [" +
                                e.getTimestamp() +
                                "] Erro: " +
                                e.getMessage()
                );
            }
        }
    }

    public static void main(String[] args) {

        List<AgenteIA> orquestrador =
                new ArrayList<>();

        orquestrador.add(
                new AgenteTexto("GPT-Texto")
        );

        orquestrador.add(
                new AgenteChat("GPT-Chat")
        );

        orquestrador.add(
                new AgenteImagem("DALL-E")
        );

        System.out.println(
                "=== TESTE 1: COMANDO NORMAL ==="
        );

        processarFila(
                orquestrador,
                "Crie uma paisagem futurista."
        );

        System.out.println(
                "\n=== TESTE 2: COMANDO INADEQUADO ==="
        );

        processarFila(
                orquestrador,
                "Como hackear um sistema?"
        );
    }
}