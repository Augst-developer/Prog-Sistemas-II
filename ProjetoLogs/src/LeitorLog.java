import java.io.*;
import java.util.ArrayList;

public class LeitorLog {

    public ArrayList<Requisicao> lerArquivo(String nomeArquivo) throws IOException {

        System.out.println("Lendo arquivo: " + nomeArquivo);

        ArrayList<Requisicao> lista = new ArrayList<>();

        FileInputStream fis = new FileInputStream(nomeArquivo);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String linha;

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

            lista.add(new Requisicao(ip, data, metodo, url, status, tempo));
        }

        br.close();

        return lista;
    }

    public ArrayList<Requisicao> buscarFalhas(ArrayList<Requisicao> lista) {

        ArrayList<Requisicao> falhas = new ArrayList<>();

        for (Requisicao r : lista) {
            if (r.getStatus() >= 400) {
                falhas.add(r);
            }
        }

        return falhas;
    }

    public double calcularMediaPagamentos(ArrayList<Requisicao> lista) {

        int soma = 0;
        int quantidade = 0;

        for (Requisicao r : lista) {

            if (r.getUrl().equals("/api/v1/payments")) {
                soma += r.getTempo();
                quantidade++;
            }
        }

        if (quantidade == 0) {
            return 0;
        }

        return (double) soma / quantidade;
    }
}