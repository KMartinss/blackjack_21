import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Olá! Vamos jogar 21!!");

        Baralho baralho = new Baralho();
        baralho.criandoBaralho();
        baralho.embaralhar();

        Baralho cartasJogador = new Baralho();
		double dinheiroJogador = 100.0;
        Baralho cartasDealer = new Baralho();

        Scanner input = new Scanner(System.in);

        // APOSTA: remover dps
        while(dinheiroJogador > 0){
            System.out.println("Você tem $" + dinheiroJogador + ", quanto você deseja apostar?");
            double apostaDoJogador = input.nextDouble();
            boolean finalDaRodada = false;
            if(apostaDoJogador > dinheiroJogador){
                System.out.println("Você não pode apostar mais dinheiro do que vem tem.");
                break;
            }

            System.out.println("sela oq...");
            //jogador gets two cards
            cartasJogador.tira(baralho);
            cartasJogador.tira(baralho);
            
            //pc(?) gets two cards
            cartasDealer.tira(baralho);
            cartasDealer.tira(baralho);
        
            while(true)
			{
				//Display player cards
				System.out.println("Sua mão:\n" + cartasJogador.toString());
				
				//Display Value
				System.out.println("Seu valor final: " + cartasJogador.valorCartas());
                System.out.println("\n========================= \n");
				
				//Display dealer cards
				System.out.println("Mão do adversário:\n\n" + cartasDealer.getCarta(0).toString() + "\n[CARTA OCULTA]");
                System.out.println("\n========================= \n");

				//What do they want to do
				System.out.println("[1] Tirar mais uma carta \n[2] Parar");
				int resposta = input.nextInt();	
                System.out.println("\n========================= \n");

				//They hit
				if(resposta == 1){
					cartasJogador.tira(baralho);
					System.out.println("Você tirou: " + cartasJogador.getCarta(cartasJogador.tamanhoBaralho()-1).toString());
					//Bust if they go over 21
					if(cartasJogador.valorCartas() > 21){
						System.out.println("PERDEU!!. Valor final: " + cartasJogador.valorCartas());
                        System.out.println("\n========================= \n");

						dinheiroJogador -= apostaDoJogador;
						finalDaRodada = true;
						break;
					}
				}
				
				//Stand
				if(resposta == 2){
					break;
				}
			}

            //Reveal Dealer Cards
			System.out.println("Mão do adversário:\n" + cartasDealer.toString());
			//See if dealer has more points than player
			if((cartasDealer.valorCartas() > cartasJogador.valorCartas()) && finalDaRodada == false){
				System.out.println("PC VENCEU " + cartasDealer.valorCartas() + " para " + cartasJogador.valorCartas());
				dinheiroJogador -= apostaDoJogador;
				finalDaRodada = true;
			}

            //Dealer hits at 16 stands at 17
			while((cartasDealer.valorCartas() < 17) && finalDaRodada == false){
				cartasDealer.tira(baralho);
				System.out.println("Adversário tirou: " + cartasDealer.getCarta(cartasDealer.tamanhoBaralho() -1).toString());
			}

            //Display value of dealer
			System.out.println("Valor final do adversário: " + cartasDealer.valorCartas());
            System.out.println("\n========================= \n");
			//Determine if dealer busted
			if((cartasDealer.valorCartas() > 21)&& finalDaRodada == false){
				System.out.println("VOCÊ GANHOU! Aí sim meu patrão.");
				dinheiroJogador += apostaDoJogador;
				finalDaRodada = true;
			}

            //Determine if push
			if((cartasDealer.valorCartas() == cartasJogador.valorCartas()) && finalDaRodada == false){
				System.out.println("Puts. Empatou!");
				finalDaRodada = true;
			}
			//Determine if player wins
			if((cartasJogador.valorCartas() > cartasDealer.valorCartas()) && finalDaRodada == false){
				System.out.println("VOCÊ GANHOU A MÃO.");
				dinheiroJogador += apostaDoJogador;
				finalDaRodada = true;
			}
			else if(finalDaRodada == false) //dealer wins
			{
				System.out.println("O ADVERSÁRIO GANHOU!! Pena.");
				dinheiroJogador -= apostaDoJogador;
			}

            //End of hand - put cards back in deck
			cartasJogador.moverTodasCartas(baralho);
			cartasDealer.moverTodasCartas(baralho);
            System.out.println("\n\n=========================");
			System.out.println("[FIM DA PARTIDA]");
            System.out.println("=========================");

        }

        	//Game is over
		System.out.println("Game over! VOCE PERDEU TODO DINHEIRO. :(");
		
		//Close Scanner
		input.close();

    }
}
