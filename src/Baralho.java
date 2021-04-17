import java.util.ArrayList;
import java.util.Random;

public class Baralho {
    private ArrayList<Cartas> cartas;

    public Baralho() {
        this.cartas = new ArrayList<Cartas>();
    }

    // criando baralho, 52 cartas
    public void criandoBaralho() {
        for (Naipe naipeCarta : Naipe.values()) {
            for (ValorCarta valorCarta : ValorCarta.values()) {
                // adiciona nova carta ao montante
                this.cartas.add(new Cartas(naipeCarta, valorCarta));
            }
        }
    }

     // substituir pelo metodo shuffle do professor
    // java.utils.Collection.shuffle

    public void embaralhar() {
        // segundo embaralhamento
        ArrayList<Cartas> tempBaralho = new ArrayList<Cartas>();
        Random random = new Random();
        int randomCarta = 0;
        int randomValorAnterior = this.cartas.size();
        for (int i = 0; i < randomValorAnterior; i++) {
            randomCarta = random.nextInt((this.cartas.size() - 1 - 0) + 1) + 0;
            tempBaralho.add(this.cartas.get(randomCarta));
            this.cartas.remove(randomCarta);
        }

        this.cartas = tempBaralho;
    }

    public void removerCarta(int i) {
        this.cartas.remove(i);
    }

     // substituir pelo método POP

    public Cartas getCarta(int i){
		return this.cartas.get(i);
	}

     // substituir pelo método push

    public void adicionarCarta(Cartas adicionaCarta) {
        this.cartas.add(adicionaCarta);
    }

    // tira carta topo do baralho
    public void tira(Baralho comingFrom) {
        this.cartas.add(comingFrom.getCarta(0));
        comingFrom.removerCarta(0);
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

    public void moverTodasCartas(Baralho moveTo){
        int tamanhoBaralho = this.cartas.size();
        for(int i = 0; i < tamanhoBaralho; i++){
            moveTo.adicionarCarta(this.getCarta(i));
        }
        for(int i=0; i < tamanhoBaralho; i++){
            this.removerCarta(0);
        }
    }

    public int tamanhoBaralho() {
        return this.cartas.size();
    }

    // Calculate the value of deck
    public int valorCartas() {
        int valorTotal = 0;
        int as = 0;
        // For every card in the deck
        for (Cartas aCard : this.cartas) {
            // Switch of possible values
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
        // Determine the total current value with aces
        // Aces worth 11 or 1 - if 11 would go over 21 make it worth 1
        for (int i = 0; i < as; i++) {
            // If they're already at over 10 getting an ace valued at 11 would put them up
            // to 22, so make ace worth one
            if (valorTotal > 10) {
                valorTotal += 1;
            } else {
                valorTotal += 11;
            }
        }

        // Return
        return valorTotal;
    }
}