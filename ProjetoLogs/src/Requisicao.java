public class Requisicao {

    private String ip;
    private String data;
    private String metodo;
    private String url;
    private int status;
    private int tempo;

    public Requisicao(String ip, String data, String metodo,
                      String url, int status, int tempo) {

        this.ip = ip;
        this.data = data;
        this.metodo = metodo;
        this.url = url;
        this.status = status;
        this.tempo = tempo;
    }

    public String getUrl() {
        return url;
    }

    public int getStatus() {
        return status;
    }

    public int getTempo() {
        return tempo;
    }

    @Override
    public String toString() {
        return ip + " | " + data + " | " + metodo + " | "
                + url + " | " + status + " | " + tempo + "ms";
    }
}