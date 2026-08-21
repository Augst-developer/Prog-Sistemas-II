public abstract class AgenteIA {

    protected String nome;
    protected String status;

    public AgenteIA(String nome) {
        this.nome = nome;
        this.status = "IDLE";
    }

    public String getNome() {
        return nome;
    }

    public void conectarServidor() throws ErroComunicacaoIAException {

        status = "CONECTANDO";

        ModuloConexao.validarLink();

        status = "CONECTADO";

        System.out.println(
                "Agente " + nome + " conectado ao servidor."
        );
    }

    public abstract void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException,
            PromptInadequadoException,
            ErroComunicacaoIAException;
}