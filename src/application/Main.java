package application;

import java.util.Scanner;


public class Main {
	
	public static JokenPo startGame() {
		System.out.println("***** Jo-Ken-Po *****\n");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe seu nome: ");
		String playerName = sc.next().toUpperCase();
		
		Player user = new Player(playerName);
		Player IA = new Player("IA");
		
		System.out.print(playerName + ", informe quantos rounds você deseja jogar: ");
		int rounds = sc.nextInt();
		
		return new JokenPo(user, IA, rounds);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		JokenPo jokenPo = startGame();
		jokenPo.toPlay();
		jokenPo.showFinalResult();
		
	}
}
