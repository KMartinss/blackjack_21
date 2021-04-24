import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Baralho {
    private Pilha cartas;

    public Baralho() {
        this.cartas = new Pilha();
    }

    public void criandoBaralho() {
        for (Naipe naipeCarta : Naipe.values()) {
            for (ValorCarta valorCarta : ValorCarta.values()) {
                this.cartas.empilhar(new Cartas(naipeCarta, valorCarta));
            }
        }
    }

    public void setDificuldade(int nivel) throws InterruptedException {
        switch (nivel) {
        case 1:
            System.out.println("Dificuldade escolhida: 1 baralho.");
            TimeUnit.SECONDS.sleep(2);
            criandoBaralho();
            break;
        case 2:
            System.out.println("Dificuldade escolhida: 2 baralhos.");
            TimeUnit.SECONDS.sleep(2);
            criandoBaralho();
            criandoBaralho();
            break;
        case 3:
            System.out.println("Dificuldade escolhida: 3 baralhos.");
            TimeUnit.SECONDS.sleep(2);
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            break;
        case 4:
            System.out.println("Dificuldade escolhida: 4 baralhos.");
            TimeUnit.SECONDS.sleep(2);
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            break;
        case 5:
            System.out.println("Dificuldade escolhida: 5 baralhos.");
            TimeUnit.SECONDS.sleep(2);
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            break;
        case 6:
            System.out.println("Dificuldade escolhida: 6 baralhos.");
            TimeUnit.SECONDS.sleep(2);
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            break;
        case 7:
            System.out.println("Dificuldade escolhida: 7 baralhos.");
            TimeUnit.SECONDS.sleep(2);
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            break;
        }
    }

    public void embaralhar() {
        ArrayList<Cartas> listaCartas = new ArrayList<Cartas>();
        int tam = this.cartas.tamanho();
        for (int i = 0; i < tam; i++) {
            listaCartas.add(this.cartas.desempilhar());
        }

        Collections.shuffle(listaCartas);
        for (int i = 0; i < listaCartas.size(); i++) {
            this.cartas.empilhar(listaCartas.get(i));
        }
    }

    public void removerCarta() {
        this.cartas.desempilhar();
    }

    public Cartas getCarta() {
        return this.cartas.exibeUltimoValor();
    }

    public void adicionarCarta(Cartas adicionaCarta) {
        this.cartas.empilhar(adicionaCarta);
    }

    public void tira(Baralho baralho) {
        this.cartas.empilhar(baralho.getCarta());
        baralho.removerCarta();
    }

    public String toString() {
        String qualCartaSaiu = "";
        int i = 0;
        Pilha pilhaAux = new Pilha();
        int tam = this.cartas.tamanho();
        for(i = 0; i < tam; i++) {
            pilhaAux.empilhar(this.cartas.desempilhar());
            Cartas aCartas = pilhaAux.exibeUltimoValor();
            qualCartaSaiu += "\n" + aCartas.toString();
        }
        tam = pilhaAux.tamanho();
        for (i = 0; i < tam; i++) {
            this.cartas.empilhar(pilhaAux.desempilhar());
        }
        return qualCartaSaiu;
    }

    public void moverTodasCartas(Baralho moveTo) {
        int tamanhoBaralho = this.cartas.tamanho();
        for (int i = 0; i < tamanhoBaralho; i++) {
            moveTo.adicionarCarta(this.getCarta());
            this.removerCarta();
        }
    }

    public int getTamanhoBaralho() {
        return this.cartas.tamanho();
    }

    public int valorCartas() {
        int valorTotal = 0;
        int as = 0;
        Pilha pilhaAux = new Pilha();
        int tam = this.cartas.tamanho();
        for(int i = 0; i < tam; i++) {
            pilhaAux.empilhar(this.cartas.desempilhar());
        }
        tam = pilhaAux.tamanho();
        for (int i = 0; i < tam; i++) {
            Cartas aCartas = pilhaAux.exibeUltimoValor();
            this.cartas.empilhar(pilhaAux.desempilhar());
            switch (aCartas.getValorCarta()) {
            case DOIS:
                valorTotal += 2;
                break;
            case TRES:
                valorTotal += 3;
                break;
            case QUATRO:
                valorTotal += 4;
                break;
            case CINCO:
                valorTotal += 5;
                break;
            case SEIS:
                valorTotal += 6;
                break;
            case SETE:
                valorTotal += 7;
                break;
            case OITO:
                valorTotal += 8;
                break;
            case NOVE:
                valorTotal += 9;
                break;
            case DEZ:
                valorTotal += 10;
                break;
            case VALETE:
                valorTotal += 10;
                break;
            case DAMA:
                valorTotal += 10;
                break;
            case REI:
                valorTotal += 10;
                break;
            case AS:
                as += 1;
                break;
            }
        }
        for (int i = 0; i < as; i++) {
            if (valorTotal > 10) {
                valorTotal += 1;
            } else {
                valorTotal += 11;
            }
        }
        return valorTotal;
    }
}