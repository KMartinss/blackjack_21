import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Baralho {
    private ArrayList<Cartas> cartas;

    public Baralho() {
        this.cartas = new ArrayList<Cartas>();
    }

    public void criandoBaralho() {
        for (Naipe naipeCarta : Naipe.values()) {
            for (ValorCarta valorCarta : ValorCarta.values()) {
                this.cartas.add(new Cartas(naipeCarta, valorCarta));
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
        case 5:
            System.out.println("Dificuldade escolhida: 5 baralhos.");
            TimeUnit.SECONDS.sleep(2);
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
        case 6:
            System.out.println("Dificuldade escolhida: 6 baralhos.");
            TimeUnit.SECONDS.sleep(2);
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
            criandoBaralho();
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
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public void removerCarta(int i) {
        this.cartas.remove(i);
    }

    public Cartas getCarta(int i) {
        return this.cartas.get(i);
    }

    public void adicionarCarta(Cartas adicionaCarta) {
        this.cartas.add(adicionaCarta);
    }

    public void tira(Baralho baralho) {
        this.cartas.add(baralho.getCarta(0));
        baralho.removerCarta(0);
    }

    public String toString() {
        String qualCartaSaiu = "";
        int i = 0;
        for (Cartas aCartas : this.cartas) {
            qualCartaSaiu += "\n" + aCartas.toString();
            i++;
        }
        return qualCartaSaiu;
    }

    public void moverTodasCartas(Baralho moveTo) {
        int tamanhoBaralho = this.cartas.size();
        for (int i = 0; i < tamanhoBaralho; i++) {
            moveTo.adicionarCarta(this.getCarta(i));
        }
        for (int i = 0; i < tamanhoBaralho; i++) {
            this.removerCarta(0);
        }
    }

    public int getTamanhoBaralho() {
        return this.cartas.size();
    }

    public int valorCartas() {
        int valorTotal = 0;
        int as = 0;
        for (Cartas aCard : this.cartas) {
            switch (aCard.getValorCarta()) {
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