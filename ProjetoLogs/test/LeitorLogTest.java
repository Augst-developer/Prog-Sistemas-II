import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

public class LeitorLogTest {

    @Test
    public void deveLerArquivo() throws IOException {

        LeitorLog leitor = new LeitorLog();
        ArrayList<Requisicao> lista = leitor.lerArquivo("log1.txt");

        assertEquals(6, lista.size());
    }

    @Test
    public void deveEncontrarFalhas() throws IOException {

        LeitorLog leitor = new LeitorLog();
        ArrayList<Requisicao> lista = leitor.lerArquivo("log1.txt");
        ArrayList<Requisicao> falhas = leitor.buscarFalhas(lista);

        assertEquals(3, falhas.size());
    }

    @Test
    public void deveCalcularMediaPagamentos() throws IOException {

        LeitorLog leitor = new LeitorLog();
        ArrayList<Requisicao> lista = leitor.lerArquivo("log1.txt");

        double media = leitor.calcularMediaPagamentos(lista);

        assertEquals(666.67, media, 0.01);
    }
}