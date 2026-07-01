package br.com.senac.time;

public class Erro {
    private String mensagem;
    private String stack;

    public Erro(String mensagem, String stack) {
        this.mensagem = mensagem;
        this.stack = stack;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
}
