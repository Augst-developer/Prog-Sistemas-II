public class ModuloConexao {

    public static void validarLink() throws ErroComunicacaoIAException {

        double valor = Math.random();

        if (valor > 0.8) {
            throw new ErroComunicacaoIAException(
                    "Falha na comunicação com a GPU."
            );
        }
    }
}