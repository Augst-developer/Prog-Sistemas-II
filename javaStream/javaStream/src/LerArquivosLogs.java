import java.io.*;

public class LerArquivosLogs {

    public static void main(String[] args) {

        String arquivo = "arquivo log2.txt";

        int somaTempo = 0;
        int quantidadePagamentos = 0;

        try {
            
            FileInputStream fis = new FileInputStream(arquivo);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            FileWriter fw = new FileWriter("falhas.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            String linha;

            System.out.println("REQUISIÇÕES COM FALHA:");
            System.out.println("-----------------------");

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split("\\|");

                String ip = dados[0].trim();
                String data = dados[1].trim();
                String metodo = dados[2].trim();
                String url = dados[3].trim();

                int status = Integer.parseInt(dados[4].trim());

                int tempo = Integer.parseInt(
                        dados[5].trim().replace("ms", "")
                );

                if (status >= 400) {
                    System.out.println(linha);
                    bw.write(linha);
                    bw.newLine();
                }

                if (url.equals("/api/v1/payments")) {
                    somaTempo += tempo;
                    quantidadePagamentos++;
                }
            }

            br.close();
            bw.close();

            System.out.println();
            System.out.println("TEMPO MÉDIO DA API /api/v1/payments");

            if (quantidadePagamentos > 0) {
                double media = (double) somaTempo / quantidadePagamentos;
                System.out.printf("Média: %.2f ms%n", media);
            } else {
                System.out.println("Nenhuma chamada encontrada.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }
    }
}