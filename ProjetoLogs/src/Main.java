import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        LeitorLog leitor = new LeitorLog();

        try {

            ArrayList<Requisicao> logs =
                    leitor.lerArquivo("log1.txt");

            System.out.println("REQUISIÇÕES COM FALHA");
            System.out.println("---------------------");

            ArrayList<Requisicao> falhas =
                    leitor.buscarFalhas(logs);

            for (Requisicao r : falhas) {
                System.out.println(r);
            }

            System.out.println();
            System.out.println("Tempo médio pagamentos: "
                    + leitor.calcularMediaPagamentos(logs) + " ms");

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }

    }
}