public class Cartas {

    private Naipe naipe;
    private ValorCarta valorCarta;

    public Cartas(Naipe naipe, ValorCarta valorCarta) {

        this.valorCarta = valorCarta;
        this.naipe = naipe;
    }

    public String toString() {
        return this.valorCarta.toString() + " de " + this.naipe.toString() + "\n";
    }

    public ValorCarta getValorCarta() {
        return this.valorCarta;
    }
}
