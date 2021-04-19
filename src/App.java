import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
	public static void main(String[] args) throws Exception {
		Baralho baralho = new Baralho();
		Scanner input = new Scanner(System.in);

		System.out.println("Olá! Vamos jogar 21!!");
		System.out.println("Quantos baralhos deseja utilizar? (Valores de 1 a 7): ");
		int nivel = input.nextInt();
		baralho.setDificuldade(nivel);

		TimeUnit.SECONDS.sleep(2);
		System.out.println("Iniciando a partida...\n");
		baralho.embaralhar();

		Baralho cartasJogador = new Baralho();
		Baralho cartasDealer = new Baralho();
		boolean finalDaRodada = false;

		cartasJogador.tira(baralho);
		cartasJogador.tira(baralho);

		cartasDealer.tira(baralho);
		cartasDealer.tira(baralho);

		while (true) {
			System.out.println("Sua mão:\n" + cartasJogador.toString());

			System.out.println("Seu valor final: " + cartasJogador.valorCartas());
			System.out.println("\n========================= \n");
			System.out.println("Aguardando adversário...\n");
			System.out.println("\n========================= \n");
			TimeUnit.SECONDS.sleep(2);

			System.out.println("Mão do adversário:\n\n" + cartasDealer.getCarta(0).toString() + "\n[CARTA OCULTA]");
			System.out.println("\n=========================\n");

			System.out.println("[1] Tirar mais uma carta \n[2] Parar");
			int resposta = input.nextInt();
			System.out.println("\n========================= \n");

			if (resposta == 1) {
				cartasJogador.tira(baralho);
				System.out.println(
						"Você tirou: " + cartasJogador.getCarta(cartasJogador.getTamanhoBaralho() - 1).toString());

				if (cartasJogador.valorCartas() > 21) {
					System.out.println("Perdeu!\nValor final: " + cartasJogador.valorCartas());
					System.out.println("\n========================= \n");
					finalDaRodada = true;
					break;
				}
			}
			if (resposta == 2) {
				break;
			}
		}

		System.out.println("Mão do adversário:\n" + cartasDealer.toString());

		if ((cartasDealer.valorCartas() > cartasJogador.valorCartas()) && finalDaRodada == false) {
			System.out.println("PC VENCEU " + cartasDealer.valorCartas() + " para " + cartasJogador.valorCartas());
		}

		while ((cartasDealer.valorCartas() < 17) && finalDaRodada == false) {
			cartasDealer.tira(baralho);
			System.out.println(
					"Adversário tirou: " + cartasDealer.getCarta(cartasDealer.getTamanhoBaralho() - 1).toString());
		}

		System.out.println("Valor final do adversário: " + cartasDealer.valorCartas());
		System.out.println("\n========================= \n");

		if ((cartasDealer.valorCartas() > 21) && finalDaRodada == false) {
			System.out.println("VOCÊ GANHOU! Aí sim meu patrão.");
			finalDaRodada = true;
		}

		if ((cartasDealer.valorCartas() == cartasJogador.valorCartas()) && finalDaRodada == false) {
			System.out.println("Puts. Empatou!");
			finalDaRodada = true;
		}
		if ((cartasJogador.valorCartas() > cartasDealer.valorCartas()) && finalDaRodada == false) {
			System.out.println("VOCÊ GANHOU A MÃO.");
			finalDaRodada = true;
		} else if (finalDaRodada == false) {
			System.out.println("O ADVERSÁRIO GANHOU!! Pena.");
		}

		cartasJogador.moverTodasCartas(baralho);
		cartasDealer.moverTodasCartas(baralho);
		System.out.println("\n\n=========================");
		System.out.println("[FIM DA PARTIDA]");
		System.out.println("=========================");

		System.out.println("\n[1] Jogar novamente\n[2] Sair do jogo");
		int jogarNovamente = input.nextInt();

		if (jogarNovamente == 1) {
			System.out.println("\nReiniciando partida...\n");
			TimeUnit.SECONDS.sleep(2);
			main(args);
		} else if (jogarNovamente == 2) {
			TimeUnit.SECONDS.sleep(2);
			System.out.println("\nEsperamos que tenha se divertido! Até mais.");
			System.exit(0);
		}
		input.close();

	}
}
