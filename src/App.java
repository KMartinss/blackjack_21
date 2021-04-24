import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
	public static void main(String[] args) throws Exception {
		int resposta, scoreJogador = 0, scorePC = 0;

		Baralho baralho = new Baralho();
		Scanner input = new Scanner(System.in);

		System.out.println("Olá! Vamos jogar 21!!");
		System.out.println("\n\nQuantos baralhos deseja utilizar? (Valores de 1 a 7): ");
		int nivel = input.nextInt();
		baralho.setDificuldade(nivel);
		while (true) {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Iniciando a partida...\n");
			baralho.embaralhar();

			Baralho cartasJogador = new Baralho();
			Baralho cartasDealer = new Baralho();

			cartasJogador.tira(baralho);
			cartasJogador.tira(baralho);

			cartasDealer.tira(baralho);
			cartasDealer.tira(baralho);

			System.out.println("Sua mão:\n" + cartasJogador.toString());
			System.out.println("Valor final: " + cartasJogador.valorCartas());
			System.out.println("\n========================= \n");

			System.out.println("Aguardando adversário...\n");
			System.out.println("\n========================= \n");
			TimeUnit.SECONDS.sleep(1);

			System.out.println("Mão do adversário:\n\n" + cartasDealer.toString() + "\n");
			System.out.println("Valor final: " + cartasDealer.valorCartas());
			System.out.println("\n=========================\n");

			do {
				if (cartasJogador.valorCartas() > 21) {
					System.out.println("Perdeu!\nValor final: " + cartasJogador.valorCartas());
					System.out.println("\n========================= \n");
					break;
				}

				System.out.println("[1] Tirar mais uma carta \n[2] Parar");
				resposta = input.nextInt();
				System.out.println("\n========================= \n");

				if (resposta == 2)
					break;

				cartasJogador.tira(baralho);
				System.out.println("Sua mão:\n" + cartasJogador.toString());
				System.out.println("Valor final: " + cartasJogador.valorCartas());
				System.out.println("\n========================= \n");
			} while (resposta == 1);

			do {
				if (cartasJogador.valorCartas() > 21 || (cartasDealer.valorCartas() > cartasJogador.valorCartas()
						&& cartasDealer.valorCartas() <= 21)) {

					System.out.println(
							"PC VENCEU de " + cartasDealer.valorCartas() + " para " + cartasJogador.valorCartas());
					scorePC++;
					break;
				}

				if (((cartasJogador.valorCartas() > cartasDealer.valorCartas() || cartasDealer.valorCartas() > 21)
						&& cartasJogador.valorCartas() <= 21) && cartasDealer.valorCartas() > 21) {
					System.out.println(
							"VOCÊ GANHOU de " + cartasJogador.valorCartas() + " para " + cartasDealer.valorCartas());
					scoreJogador++;
					break;
				}

				cartasDealer.tira(baralho);
				System.out.println("Mão do adversário:\n" + cartasDealer.toString());
				System.out.println("Valor final: " + cartasDealer.valorCartas());
				System.out.println("\n========================= \n");
			} while (true);

			if (cartasJogador.valorCartas() == cartasDealer.valorCartas())
				System.out.println("Puts. Empatou!");

			cartasJogador.moverTodasCartas(baralho);
			cartasDealer.moverTodasCartas(baralho);

			System.out.println("\n\n============PLACAR==============");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("USER: " + scoreJogador + "| PC: " + scorePC);

			System.out.println("\n\n=========================");
			System.out.println("[FIM DA PARTIDA]");

			System.out.println("\n[1] Jogar novamente\n[2] Sair do jogo");
			int jogarNovamente = input.nextInt();

			if (jogarNovamente == 1) {
				System.out.println("\nReiniciando partida...\n");
				TimeUnit.SECONDS.sleep(1);
			} else if (jogarNovamente == 2) {
				int tamBaralho = baralho.getTamanhoBaralho();
				for(int i = 0; i < tamBaralho; i++)
				{
					System.out.println("# " + (i + 1) + " - " + baralho.getCarta());
					baralho.removerCarta();
				}
				TimeUnit.SECONDS.sleep(1);
				System.out.println("\nEsperamos que tenha se divertido! Até mais.");
				break;
			}
		}
		input.close();
	}
}