public class Pilha {

    public Cartas[] pilha;
    public int posicaoPilha;

    public Pilha() {
        this.posicaoPilha = -1;
        this.pilha = new Cartas[1000];
    }

    public boolean pilhaVazia() {
        if (this.posicaoPilha == -1) {
            return true;
        }
        return false;
    }

    public int tamanho() {
        if (this.pilhaVazia()) {
            return 0;
        }
        return this.posicaoPilha + 1;
    }

    public Cartas exibeUltimoValor() {
        if (this.pilhaVazia()) {
            return null;
        }
        return this.pilha[this.posicaoPilha];
    }

    public Cartas desempilhar() {
        if (pilhaVazia()) {
            return null;
        }
        Cartas retorno = this.pilha[this.posicaoPilha];
        this.pilha[this.posicaoPilha] = null;
        this.posicaoPilha--;
        return retorno;
    }

    public void empilhar(Cartas valor) {
        if (this.posicaoPilha < this.pilha.length - 1) {
            this.pilha[++posicaoPilha] = valor;
        }
    }
}