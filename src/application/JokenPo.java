package application;

import java.util.Random;
import java.util.Scanner;

public record JokenPo(Player user, Player IA, int rounds) {

	public void toPlay() {
		System.out.println("\n******* SEJA BEM VINDO(A), " + user.getName() + " ******");

		for (int i = 1; i <= rounds; i++) {
			int choiceUser = choiceUser();
			if (choiceUser < 1 || choiceUser > 3) {
				System.out.println("\n JOGADA INVALIDA (1, 2 ou 3): ");
				System.out.println("\t PONTO PARA " + IA.getName() + "\n");
				IA.incrementScore();
				continue;
			}

			int choiceIA = choiceIA();
			System.out.println("\n " + choiceUser + " X " + choiceIA + "\n");

			int result = choiceUser - choiceIA;

			winnerRound(result);

		}
	}

	public void showFinalResult() {
		System.out.println("\n*********************************\n");

		Integer finalScoreUser = user.getScore();
		Integer finalScoreIA = IA.getScore();

		System.out.println("\n\t PLACAR FINAL: " + user.getName() + " " + user.getScore() + " X " + IA.getScore() + " "
				+ IA.getName());

		if (finalScoreUser == finalScoreIA)
			System.out.println("\t\tEMPATE!");
		else {
			String finalWinner = (finalScoreUser > finalScoreIA) ? user.getName() : IA.getName();
			System.out.println("\t\tVENCEDOR = " + finalWinner.toUpperCase());
		}
	}

	public void winnerRound(int result) {
		String winnerRound;
		if (result == 0)
			winnerRound = "EMPATE!";
		else {
			if (result == -1 || result == 2) {
				IA.incrementScore();
				winnerRound = IA.getName();
			} else {
				user.incrementScore();
				winnerRound = user.getName();
			}
		}
		System.out.println("Vencedor do Round: " + winnerRound);
	}

	private int choiceIA() {
		Random random = new Random();
		return random.nextInt(3) + 1;
	}

	private int choiceUser() {
		Scanner sc = new Scanner(System.in);

		System.out.println("1 - PEDRA");
		System.out.println("2 - PAPEL");
		System.out.println("3 - TESOURA");

		System.out.print("Informe sua jogada ");

		return sc.nextInt();
	}

}
