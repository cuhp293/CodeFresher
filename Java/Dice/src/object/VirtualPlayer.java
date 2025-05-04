package object;

import java.util.ArrayList;

public class VirtualPlayer extends Player {
	
	public VirtualPlayer(String name) {
		super(name);
	}
	
	public String Lose1() {
		return "Huhu";
	}
	
	public String Lose2() {
		return "Hic";
	}
	
	public String Lose3() {
		return "Poor me!";
	}
	
	public String Lose4() {
		return "I'm crying inside";
	}
	
	public static void virtualLose(ArrayList<Player> players, int k) {
		for (int i = 0; i < players.size(); i++) {
			if (i != k) {
				if (players.get(i) instanceof VirtualPlayer) {
					if (i == 0) {
						System.out.println("Virtual player 1: Huhu");
					} else if (i == 1) {
						System.out.println("Virtual player 2: Hic");
					} else if (i == 2) {
						System.out.println("Virtual player 3: Poor me!");
					} else {
						System.out.println("Virtual player 4: I'm crying inside");
					}
				}
			}
		}
	}
	
}
