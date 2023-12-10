package object;

import java.util.ArrayList;
import java.util.Scanner;

import dice.DiceGame;

public class Player {
	private String name;
	private int score = 0;
	
	public Player(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public static void player(ArrayList<Player> players, ArrayList<DiceGame> dices) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of player: ");
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print("Name of player " + (i + 1) + ": ");
			scanner.nextLine();
			String name = scanner.nextLine();
			Player player = new Player(name);
			players.add(player);
		}
		
		for (int i = 0; i < (4 - n); i++) {
			String name = "Virtual player " + (i + 1);
			VirtualPlayer virtual = new VirtualPlayer(name);
			players.add(virtual);
		}
		
		for (int i = 0; i < 4; i++)
			dices.add(new DiceGame(i));
	}
	
	@Override
	public String toString() {
		return this.name + ": Current score = " + this.score + "\n";
	}
	
}
